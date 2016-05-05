/**
 * Copyright (c) 2015 Dave Powell and George Smith.
 * Work done for Martin Kohlmeier
 */
package edu.elon.nutrigen.controller;

import edu.elon.nutrigen.business.*;
import edu.elon.nutrigen.data.*;
import edu.elon.nutrigen.facade.Meal;
import edu.elon.nutrigen.facade.MealItem;
import edu.elon.nutrigen.facade.NutritionalItem;
import edu.elon.nutrigen.facade.PongFacade;
import edu.elon.nutrigen.facade.PongJavaFacade;
import edu.elon.nutrigen.facade.ScheduledMeal;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.tools.admin.ConfirmationCallback.Action;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {

	// Potentially adds these to the facade as this will allow further
	// decoupling from the servlet
	private Date currentDate;
	private Date dateToPopulateWithAMeal;
	private Meal currentMeal;
	private int currentIndex = -1;
	private int currentMealNumber = -1;
	private int copiedMealNumber = -1;
	private int offsetDays = -1;
	private Date currentMonth;
	private int month = -1;
	private int year = -1;

	/**
	 * We should probably only support doPost for the final implementation of
	 * the controller servlet but for now doGet and doPost are equivalent. This
	 * is the controller servlet that all requests come through
	 * 
	 * @param request
	 *            HttpServletRequest submitted from all web pages with key
	 *            values for processing and navigating to next page
	 * @param response
	 *            HttpServletResponse used for forwarding to the next page in
	 *            application
	 */

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String action = request.getParameter("action");
		if (action == null || action.equalsIgnoreCase("login")) {
			System.out.println("User: null   action: login");
			response.sendRedirect("/Log.html");
			// Attempted Login to validates if user exists
		} else if (action.equalsIgnoreCase("loginAttempt")) {
			System.out.println("login attempt");
			String userName = request.getParameter("user");
			String password = request.getParameter("password");
			boolean userExists = UserDB.userExists(userName, password);
			if (!userExists) {
				response.sendRedirect("/CreateAccount.jsp");
			} else {
				// Uses session variable to pass meal and nutritional
				// information to
				// front end
				user = UserDB.selectUser(userName, password);
				initializeSession(session, user, out);
				currentDate = new Date();
				session.setAttribute("date", formateDate(currentDate));
				PongFacade facade = getFacade(session, user);
				currentMeal = facade.getDailyMealPlan(currentDate);
				if (currentMeal != null) {
					attachNutrientInfo(currentMeal, facade);
					session.setAttribute("meal", currentMeal);
					session.setAttribute("userInfo", correctLabel(facade
							.getIndividualNutrientTargets(session)));
					session.setAttribute("mealInfo",
							correctLabel(currentMeal.getNutrientInfo()));
					session.setAttribute("breakfastMeal",
							currentMeal.getBreakfast());
					session.setAttribute("breakfast",
							currentMeal.getBreakfast());
					session.setAttribute("lunch", currentMeal.getLunch());
					session.setAttribute("dinner", currentMeal.getDinner());
					response.sendRedirect("/day.jsp");
				} else {
					session.setAttribute("userInfo", correctLabel(facade
							.getIndividualNutrientTargets(session)));
					response.sendRedirect("/NoDay.jsp");
				}

			}
			// Logic to support selection of Previous Month
		} else if (action.equalsIgnoreCase("previousMonth")) {
			PongFacade facade = getFacade(session, user);
			currentMonth = changeMonth(currentMonth, -1);
			session.setAttribute("userInfo",
					correctLabel(facade.getIndividualNutrientTargets(session)));
			session.setAttribute("month", getMonthString(currentMonth));
			session.setAttribute("monthlySchedule",
					formatMonthlyMeals(facade.getMonthlyMealPlan(currentMonth)));
			session.setAttribute("offset", offsetDays);
			response.sendRedirect("/Calendar.jsp");
			// Logic to support selection of Next Month
		} else if (action.equalsIgnoreCase("nextMonth")) {
			PongFacade facade = getFacade(session, user);
			currentMonth = changeMonth(currentMonth, 1);
			session.setAttribute("userInfo",
					correctLabel(facade.getIndividualNutrientTargets(session)));
			session.setAttribute("month", getMonthString(currentMonth));
			session.setAttribute("monthlySchedule",
					formatMonthlyMeals(facade.getMonthlyMealPlan(currentMonth)));
			session.setAttribute("offset", offsetDays);
			response.sendRedirect("/Calendar.jsp");
			// Logic to support editing of a meal plan
		} else if (action.equalsIgnoreCase("edit")) {
			PongFacade facade = getFacade(session, user);
			session.setAttribute("date", formateDate(currentDate));
			currentMeal = facade.getDailyMealPlan(currentDate);
			if (currentMeal != null) {
				session.setAttribute("meal", currentMeal);
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				session.setAttribute("mealInfo",
						correctLabel(currentMeal.getNutrientInfo()));
				session.setAttribute("breakfast", currentMeal.getBreakfast());
				session.setAttribute("lunch", currentMeal.getLunch());
				session.setAttribute("dinner", currentMeal.getDinner());
				response.sendRedirect("/EditDay.jsp");
			} else {
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				response.sendRedirect("/NoEditDay.jsp");
			}
			// Logic to support selection of calendar feature
		} else if (action.equalsIgnoreCase("calendar")) {
			PongFacade facade = getFacade(session, user);
			currentMonth = currentDate;
			year = getYearString(currentDate);
			session.setAttribute("userInfo",
					correctLabel(facade.getIndividualNutrientTargets(session)));
			session.setAttribute("month", getMonthString(currentMonth));
			session.setAttribute("monthlySchedule",
					formatMonthlyMeals(facade.getMonthlyMealPlan(currentMonth)));
			session.setAttribute("offset", offsetDays);
			response.sendRedirect("/Calendar.jsp");
			// Logic to support deletion of meal plan
		} else if (action.equalsIgnoreCase("delete")) {
			PongFacade facade = getFacade(session, user);
			facade.deleteDailyMealPlan(currentDate);
			currentMeal = facade.getDailyMealPlan(currentDate);
			if (currentMeal == null) {
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				response.sendRedirect("/NoDay.jsp");
			}
			// Logic to support copy of meal plan
		} else if (action.equalsIgnoreCase("copy")) {
			PongFacade facade = getFacade(session, user);
			if (currentMeal == null) {
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				response.sendRedirect("/NoEditDay.jsp");
			}
			copiedMealNumber = currentMeal.getMealNumber();
			session.setAttribute("date", formateDate(currentDate));
			currentMeal = facade.getDailyMealPlan(currentDate);
			session.setAttribute("mealInfo",
					correctLabel(currentMeal.getNutrientInfo()));
			session.setAttribute("breakfast", currentMeal.getBreakfast());
			session.setAttribute("lunch", currentMeal.getLunch());
			session.setAttribute("dinner", currentMeal.getDinner());
			session.setAttribute("userInfo",
					facade.getIndividualNutrientTargets(session));
			response.sendRedirect("/EditDay.jsp");
			// Logic to support pasting of selected meal plan to new day
		} else if (action.equalsIgnoreCase("paste")) {
			PongFacade facade = getFacade(session, user);
			if (currentDate == null || copiedMealNumber == -1) {
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				response.sendRedirect("/NoDay.jsp");
			} else {
				facade.setDailyMealPlan(currentDate, copiedMealNumber);
				currentMeal = facade.getDailyMealPlan(currentDate);
				if (currentMeal != null) {
					attachNutrientInfo(currentMeal, facade);
					session.setAttribute("mealInfo",
							correctLabel(currentMeal.getNutrientInfo()));
					session.setAttribute("breakfast",
							currentMeal.getBreakfast());
					session.setAttribute("lunch", currentMeal.getLunch());
					session.setAttribute("dinner", currentMeal.getDinner());
					session.setAttribute("userInfo",
							facade.getIndividualNutrientTargets(session));
					response.sendRedirect("/day.jsp");
				} else {
					session.setAttribute("userInfo", correctLabel(facade
							.getIndividualNutrientTargets(session)));
					response.sendRedirect("/NoDay.jsp");
				}
			}
			// Logic to support replacement of current meal plan
		} else if (action.equalsIgnoreCase("replace")) {
			PongFacade facade = getFacade(session, user);
			facade.deleteDailyMealPlan(currentDate);
			dateToPopulateWithAMeal = currentDate;
			if (currentIndex != 0) {
				currentIndex = 0;
				currentMeal = facade.getSortedMealPlan(currentIndex);
				session.setAttribute("mealInfo",
						correctLabel(currentMeal.getNutrientInfo()));
				double score = currentMeal.getDlt();
				currentMealNumber = currentMeal.getMealNumber();
				if (score < 35) {
					session.setAttribute("panelColor", "panel panel-success");
				} else if (score > 35 && score < 75) {
					session.setAttribute("panelColor", "panel panel-warning");
				} else {
					session.setAttribute("panelColor", "panel panel-danger");
				}
				attachNutrientInfo(currentMeal, facade);
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				session.setAttribute("breakfast", currentMeal.getBreakfast());
				session.setAttribute("lunch", currentMeal.getLunch());
				session.setAttribute("dinner", currentMeal.getDinner());
				response.sendRedirect("/ChooseDay.jsp");
			} else {
				out.print("currentIndex was 0");
			}
			// Logic to support selection of Previous day and next day
		} else if (action.equalsIgnoreCase("previousday")
				|| action.equalsIgnoreCase("nextday")) {
			PongFacade facade = getFacade(session, user);
			if (action.equalsIgnoreCase("previousday")) {
				currentDate = addDays(currentDate, -1);
				session.setAttribute("date", formateDate(currentDate));
				currentMeal = facade.getDailyMealPlan(currentDate);
				if (currentMeal != null) {
					attachNutrientInfo(currentMeal, facade);
					session.setAttribute("meal", currentMeal);
					session.setAttribute("userInfo", correctLabel(facade
							.getIndividualNutrientTargets(session)));
					session.setAttribute("mealInfo",
							correctLabel(currentMeal.getNutrientInfo()));
					session.setAttribute("breakfast",
							currentMeal.getBreakfast());
					session.setAttribute("lunch", currentMeal.getLunch());
					session.setAttribute("dinner", currentMeal.getDinner());
					response.sendRedirect("/day.jsp");
				} else {
					session.setAttribute("userInfo", correctLabel(facade
							.getIndividualNutrientTargets(session)));
					response.sendRedirect("/NoDay.jsp");
				}
			} else {
				currentDate = addDays(currentDate, 1);
				session.setAttribute("date", formateDate(currentDate));
				currentMeal = facade.getDailyMealPlan(currentDate);
				if (currentMeal != null) {
					attachNutrientInfo(currentMeal, facade);
					session.setAttribute("meal", currentMeal);
					session.setAttribute("userInfo", correctLabel(facade
							.getIndividualNutrientTargets(session)));
					session.setAttribute("mealInfo",
							correctLabel(currentMeal.getNutrientInfo()));
					session.setAttribute("breakfast",
							currentMeal.getBreakfast());
					session.setAttribute("lunch", currentMeal.getLunch());
					session.setAttribute("dinner", currentMeal.getDinner());
					response.sendRedirect("/day.jsp");
				} else {
					response.sendRedirect("/NoDay.jsp");
				}
			}
			// Logic to support selection of potential meal plans. Cycles to
			// previous option
		} else if (action.equalsIgnoreCase("previous")) {
			PongFacade facade = getFacade(session, user);
			if (currentIndex > 0) {
				currentIndex--;
				currentMeal = facade.getSortedMealPlan(currentIndex);
				attachNutrientInfo(currentMeal, facade);
				session.setAttribute("mealInfo",
						correctLabel(currentMeal.getNutrientInfo()));
				double score = currentMeal.getDlt();
				currentMealNumber = currentMeal.getMealNumber();
				if (score < 35) {
					session.setAttribute("panelColor", "panel panel-success");
				} else if (score > 35 && score < 75) {
					session.setAttribute("panelColor", "panel panel-warning");
				} else {
					session.setAttribute("panelColor", "panel panel-danger");
				}
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				session.setAttribute("score", score);
				session.setAttribute("breakfast", currentMeal.getBreakfast());
				session.setAttribute("lunch", currentMeal.getLunch());
				session.setAttribute("dinner", currentMeal.getDinner());
				response.sendRedirect("/ChooseDay.jsp");
			}
			response.sendRedirect("/ChooseDay.jsp");
			// Logic to support selection of potential meal plans. Cycles to
			// next option
		} else if (action.equalsIgnoreCase("next")) {
			PongFacade facade = getFacade(session, user);
			currentIndex++;
			currentMeal = facade.getSortedMealPlan(currentIndex);
			attachNutrientInfo(currentMeal, facade);
			session.setAttribute("mealInfo",
					correctLabel(currentMeal.getNutrientInfo()));
			double score = currentMeal.getDlt();
			session.setAttribute("score", score);
			currentMealNumber = currentMeal.getMealNumber();
			if (score < 35) {
				session.setAttribute("panelColor", "panel panel-success");
			} else if (score > 35 && score < 75) {
				session.setAttribute("panelColor", "panel panel-warning");
			} else {
				session.setAttribute("panelColor", "panel panel-danger");
			}
			session.setAttribute("userInfo",
					correctLabel(facade.getIndividualNutrientTargets(session)));
			session.setAttribute("breakfast", currentMeal.getBreakfast());
			session.setAttribute("lunch", currentMeal.getLunch());
			session.setAttribute("dinner", currentMeal.getDinner());
			response.sendRedirect("/ChooseDay.jsp");
			// Logic to support select current meal plan and apply it to
			// selected day
		} else if (action.equalsIgnoreCase("chooseday")) {
			PongFacade facade = getFacade(session, user);
			dateToPopulateWithAMeal = currentDate;

			currentIndex = 0;
			currentMeal = facade.getSortedMealPlan(currentIndex);
			session.setAttribute("mealInfo",
					correctLabel(currentMeal.getNutrientInfo()));
			double score = currentMeal.getDlt();
			session.setAttribute("score", score);
			currentMealNumber = currentMeal.getMealNumber();
			if (score < 35) {
				session.setAttribute("panelColor", "panel panel-success");
			} else if (score > 35 && score < 75) {
				session.setAttribute("panelColor", "panel panel-warning");
			} else {
				session.setAttribute("panelColor", "panel panel-danger");
			}
			attachNutrientInfo(currentMeal, facade);
			session.setAttribute("userInfo",
					correctLabel(facade.getIndividualNutrientTargets(session)));
			session.setAttribute("breakfast", currentMeal.getBreakfast());
			session.setAttribute("lunch", currentMeal.getLunch());
			session.setAttribute("dinner", currentMeal.getDinner());
			response.sendRedirect("/ChooseDay.jsp");
		 //Logic to support selection of day
		} else if (action.equalsIgnoreCase("select")) {
			PongFacade facade = getFacade(session, user);
			facade.setDailyMealPlan(dateToPopulateWithAMeal, currentMealNumber);
			currentMealNumber = -1;
			currentIndex = -1;
			currentMeal = facade.getDailyMealPlan(dateToPopulateWithAMeal);
			attachNutrientInfo(currentMeal, facade);
			session.setAttribute("meal", currentMeal);
			session.setAttribute("userInfo",
					correctLabel(facade.getIndividualNutrientTargets(session)));
			session.setAttribute("date", formateDate(currentDate));
			session.setAttribute("mealInfo",
					correctLabel(currentMeal.getNutrientInfo()));
			session.setAttribute("breakfast", currentMeal.getBreakfast());
			session.setAttribute("lunch", currentMeal.getLunch());
			session.setAttribute("dinner", currentMeal.getDinner());
			response.sendRedirect("/day.jsp");
			//Logic to navigate to dayView
		} else if (action.equalsIgnoreCase("dayView")) {
			PongFacade facade = getFacade(session, user);
			currentMeal = facade.getDailyMealPlan(currentDate);
			if (currentMeal != null) {
				attachNutrientInfo(currentMeal, facade);
				session.setAttribute("meal", currentMeal);
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				session.setAttribute("date", formateDate(currentDate));
				session.setAttribute("mealInfo",
						correctLabel(currentMeal.getNutrientInfo()));
				session.setAttribute("breakfast", currentMeal.getBreakfast());
				session.setAttribute("lunch", currentMeal.getLunch());
				session.setAttribute("dinner", currentMeal.getDinner());
				response.sendRedirect("/day.jsp");
			} else {
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				response.sendRedirect("/NoDay.jsp");
			}
		//Logic to support navigation to specific, selected day
		} else if (action.equalsIgnoreCase("selectDay")) {
			PongFacade facade = getFacade(session, user);
			String day = request.getParameter("day");
			currentDate = getDate(day);
			currentMeal = facade.getDailyMealPlan(currentDate);
			if (currentMeal != null) {
				attachNutrientInfo(currentMeal, facade);
				session.setAttribute("meal", currentMeal);
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				session.setAttribute("date", formateDate(currentDate));
				session.setAttribute("mealInfo",
						correctLabel(currentMeal.getNutrientInfo()));
				session.setAttribute("breakfast", currentMeal.getBreakfast());
				session.setAttribute("lunch", currentMeal.getLunch());
				session.setAttribute("dinner", currentMeal.getDinner());
				response.sendRedirect("/day.jsp");
			} else {
				session.setAttribute("date", formateDate(currentDate));
				session.setAttribute("userInfo", correctLabel(facade
						.getIndividualNutrientTargets(session)));
				response.sendRedirect("/NoDay.jsp");
			}
		//Logic to support logging user out
		} else if (action.equalsIgnoreCase("logout")) {
			currentDate = null;
			dateToPopulateWithAMeal = null;
			currentMeal = null;
			currentIndex = -1;
			currentMealNumber = -1;
			copiedMealNumber = -1;
			offsetDays = -1;
			currentMonth = null;
			month = -1;
			year = -1;
			session.invalidate();
			response.sendRedirect("/Log.html");
		} else {
			//
		}

	}

	/**
	 * Attached the nutritional information for the item in each meal for a menu
	 * 
	 * @param meal
	 *            Meal that need nutritional information
	 * @param facade
	 *            Facade allowing access to the nutritional information to
	 *            attach
	 * @return the updated meal
	 */
	public Meal attachNutrientInfo(Meal meal, PongFacade facade) {
		for (MealItem item : meal.getBreakfast()) {
			int itemNum = item.getItemNumber();
			ArrayList<NutritionalItem> nutitems = (ArrayList<NutritionalItem>) facade
					.getMealItemNutritionInfo(itemNum);
			item.setItemInfo(nutitems);
		}
		for (MealItem item : meal.getLunch()) {
			int itemNum = item.getItemNumber();
			ArrayList<NutritionalItem> nutitems = (ArrayList<NutritionalItem>) facade
					.getMealItemNutritionInfo(itemNum);
			item.setItemInfo(nutitems);
		}
		for (MealItem item : meal.getDinner()) {
			int itemNum = item.getItemNumber();
			ArrayList<NutritionalItem> nutitems = (ArrayList<NutritionalItem>) facade
					.getMealItemNutritionInfo(itemNum);
			item.setItemInfo(nutitems);
		}
		return meal;
	}

	/**
	 * Corrects the labels for some nutritional items that are labels with a
	 * micro gram
	 * 
	 * @param items
	 *            list of nutritional items to test
	 * @return updated items
	 */
	public ArrayList<NutritionalItem> correctLabel(
			ArrayList<NutritionalItem> items) {
		for (NutritionalItem item : items) {
			if (item.getUnits().equalsIgnoreCase("�g")) {
				item.setUnits("µg");
			}
		}
		return items;
	}

	/**
	 * Initializes the session
	 * 
	 * @param session
	 *            to initialize
	 * @param user
	 *            User to initialize
	 * @param out
	 *            print writer
	 */
	public void initializeSession(HttpSession session, User user,
			PrintWriter out) {
		boolean DEBUG = false;
		State state = new State();

		if (DEBUG) {
			out.println();

			out.println("Status: " + HttpServletResponse.SC_OK);
			out.println(user);
		}

		// log login to database in loginlog table
		int count = UserDB.loginLogging(user.getIndNum());

		OptInfo optInfo = OptInfoDB.selectOptInfo(user.getIndNum());
		if (DEBUG) {
			out.println(optInfo);
		}

		// get adjust info
		Adjust adjust = AdjustDB.selectAdjustInfo(user.getIndNum(), optInfo);
		if (DEBUG) {
			out.println(adjust);
		}

		// get wts info
		Wts wts = WtsDB.selectWtsInfo(user.getIndNum(), optInfo);
		if (DEBUG) {
			out.println(wts);
		}

		// get exercise info
		Exercise exercise = ExerciseDB.selectExerciseInfo(user.getIndNum());
		if (DEBUG) {
			out.println(exercise);
		}

		// get indcombo info
		IndCombo indCombo = IndComboDB.selectIndComboInfo(user.getIndNum());
		if (DEBUG) {
			out.println(indCombo);
		}

		// get calories info
		Calories calories = CaloriesDB.selectCaloriesInfo(user.getIndNum());
		if (DEBUG) {
			out.println(calories);
		}

		DateManager dateManager = new DateManager();
		if (DEBUG) {
			out.println(dateManager);
		}

		// get CurrentMealPlanner Info
		MealPlanner mealPlanner = MealPlannerDB.selectMealPlannerInfo(
				user.getIndNum(), (int) dateManager.getReferenceday());
		if (DEBUG) {
			out.println(mealPlanner);
		}

		// get Diet Info
		Diet diet = DietDB.selectDietInfo(user.getIndNum());
		if (DEBUG) {
			out.println(diet);
		}

		// insert Adequacy rates into testadequacy table
		Adequacy adequacy = new Adequacy(user, exercise, optInfo, calories,
				adjust, diet);
		// Put data into testadequacy database
		AdequacyDB.insertAdequacyRates(user.getIndNum(), adequacy);
		if (DEBUG) {
			out.println(adequacy);
		}

		// get the current user weekly meals and all of the meals ranked
		// for the user

		MealCombos mealcombos = new MealCombos(adequacy, mealPlanner, wts,
				indCombo, optInfo, user, state, dateManager);
		if (DEBUG) {
			out.println("Found " + mealcombos.getFoodcombos().size()
					+ "Food combinations");
			out.println(mealcombos.getFoodcombos().get(0));

			// DJP - print size of selected food combos. This is the number of
			// days
			// from MealPlanning for the upcoming week that have a nrFC set
			out.println("\n\n\nRaw Food Combos for current meal plan"
					+ mealcombos.getRawcombos().size());

			// DJP print raw combos
			for (MealCombo m : mealcombos.getRawcombos()) {
				out.println(m);
			}

			// **This has a size of 10 for the current meal plan. In general it
			// has
			// the raw food combos listed first followed by blank meals
			// **Keep in mind that Martin starts at 1 and not 0 for array
			// looping
			out.println("\n\n\nSelected Food Combos for current meal plan"
					+ mealcombos.getSelectedMealcombos().size());
			for (MealCombo m : mealcombos.getSelectedMealcombos()) {
				out.println(m);
			}
		}

		// get food info and loads into AllpASS

		FoodInfo foodInfo = FoodInfoDB.selectFoodInfo(optInfo,
				mealcombos.getFoods());
		Allpass foods = mealcombos.getFoods();
		if (DEBUG) {
			out.println("Allpass has " + foods.getFoodcombos().size()
					+ " to process in meals calc");
		}

		// Calculate the meals
		mealcombos.mealscalc();

		// Call planscalc()
		mealcombos.planscalc();

		// print out the number of currentfoods that should be in sorted
		// order
		ArrayList<MealComboCompare> currentfoods = mealcombos.getCurrentfoods();

		if (DEBUG) {
			out.println();
			out.println("MealComboCompare has " + currentfoods.size()
					+ "entries");
			out.println(currentfoods.get(0));

			// print out MealComboCompare to see if it has NR = nrFC
			out.println("\n\nTrying to see if NR equals nrFC for 2079");
			for (MealComboCompare c : currentfoods) {
				if (c.getNr() == 2249) {
					out.println(c);
				}
			}
		}

		// save session attributes so only pay this price one time.

		session.setAttribute("state", state);
		session.setAttribute("user", user);
		session.setAttribute("optInfo", optInfo);
		session.setAttribute("adjust", adjust);
		session.setAttribute("wts", wts);
		session.setAttribute("exercise", exercise);
		session.setAttribute("indCombo", indCombo);
		session.setAttribute("calories", calories);
		session.setAttribute("dateManager", dateManager);
		session.setAttribute("mealPlanner", mealPlanner);
		session.setAttribute("diet", diet);
		session.setAttribute("adequacy", adequacy);
		session.setAttribute("mealcombos", mealcombos);
		// this is huge and seems to cause appengine to say no
		// session.setAttribute("foodInfo", foodInfo);
	}

	/**
	 * The PongFacade is the key interface between Martin's system and the new
	 * Bootstrap front end.
	 * 
	 * @param session
	 *            HttpSession state holding user and other key values for
	 *            session
	 * @param user
	 *            User object containing user information
	 * @return instance of PongFacade for interacting with servlet
	 */
	public PongFacade getFacade(HttpSession session, User user) {
		PongFacade aFacade = (PongJavaFacade) session.getAttribute("facade");
		if (aFacade == null) {
			aFacade = new PongJavaFacade(user.getIndNum(), session);
		}

		return aFacade;

	}

	/**
	 * addDays allows one to iterate through the possible menus by moving to the
	 * next for previous day. Adjusts the date to support iether operation
	 * 
	 * @param days
	 *            integer that represents the number of days that the date is
	 *            supposed to be adjusted
	 * 
	 * @param date
	 *            the date that is to be adjusted
	 * @Date instance of PongFacade for interacting with servlet
	 */
	public Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Allows for the adjustment of months so that the calendar and move to a
	 * previous or next month
	 * 
	 * @param date
	 *            Representing the current day with the current month
	 * @param months
	 *            number of months to adjust by (Should never be more than one)
	 * @return
	 */
	public Date changeMonth(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		// cal.set(Calendar.DAY_OF_MONTH,
		// cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();

	}

	/**
	 * Takes the current date and returns a string representing the month
	 * 
	 * @param date
	 *            Date to use
	 * @return String representing the value of the month associated with the
	 *         given date
	 */
	public String getMonthString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int num = cal.get(Calendar.MONTH);
		month = cal.get(Calendar.MONTH);
		String m = "NOPE";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (num >= 0 && num <= 11) {
			m = months[num];
		}
		return m;
	}

	/**
	 * Takes a date and returns the years associated with it
	 * 
	 * @param date
	 *            Date value
	 * @return Int representing the year assocaited with the date
	 */
	public int getYearString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	/**
	 * Takes a day of the month and uses several global variables to create a
	 * date Used to move from calendar view to day view when a day is clicked
	 * 
	 * @param day
	 *            String value representing the day of the month
	 * @return the new created Date
	 */
	public Date getDate(String day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DATE, Integer.parseInt(day));
		return cal.getTime();
	}

	/**
	 * Formats the Meals that the calendar displays so the the first of the
	 * month is on the accurate day of the week
	 * 
	 * @param meals
	 *            ScheduledMeals to format
	 * @return formated meals
	 */
	public ArrayList<ScheduledMeal> formatMonthlyMeals(List<ScheduledMeal> meals) {
		ArrayList<ScheduledMeal> someMeals = (ArrayList<ScheduledMeal>) meals;
		ScheduledMeal firstMeal = someMeals.get(0);
		Date date = firstMeal.getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int num = cal.get(Calendar.DAY_OF_WEEK);
		offsetDays = num - 1;
		for (int i = 0; i < offsetDays; i++) {
			ScheduledMeal aMeal = new ScheduledMeal();
			someMeals.add(0, aMeal);
		}
		return someMeals;
	}

	/**
	 * Formats the date to one that is easily readable to display to user
	 * 
	 * @param date
	 *            to format
	 * @return formated date
	 */
	public String formateDate(Date date) {
		DateFormat df = new SimpleDateFormat("MMMMM dd, yyyy");
		String newDate = df.format(date);
		return newDate;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
