/**
 * Copyright (c) 2015 Dave Powell and George Smith.
 * Work done for Martin Kohlmeier
 */

package edu.elon.nutrigen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.*;

import edu.elon.nutrigen.business.Adequacy;
import edu.elon.nutrigen.business.Adjust;
import edu.elon.nutrigen.business.Allpass;
import edu.elon.nutrigen.business.Calories;
import edu.elon.nutrigen.business.DateManager;
import edu.elon.nutrigen.business.Diet;
import edu.elon.nutrigen.business.Exercise;
import edu.elon.nutrigen.business.FoodInfo;
import edu.elon.nutrigen.business.IndCombo;
import edu.elon.nutrigen.business.MealCombo;
import edu.elon.nutrigen.business.MealComboCompare;
import edu.elon.nutrigen.business.MealCombos;
import edu.elon.nutrigen.business.MealPlanner;
import edu.elon.nutrigen.business.OptInfo;
import edu.elon.nutrigen.business.State;
import edu.elon.nutrigen.business.User;
import edu.elon.nutrigen.business.Wts;
import edu.elon.nutrigen.data.AdequacyDB;
import edu.elon.nutrigen.data.AdjustDB;
import edu.elon.nutrigen.data.CaloriesDB;
import edu.elon.nutrigen.data.ConnectionPool;
import edu.elon.nutrigen.data.DietDB;
import edu.elon.nutrigen.data.ExerciseDB;
import edu.elon.nutrigen.data.FoodInfoDB;
import edu.elon.nutrigen.data.IndComboDB;
import edu.elon.nutrigen.data.MealPlannerDB;
import edu.elon.nutrigen.data.OptInfoDB;
import edu.elon.nutrigen.data.UserDB;
import edu.elon.nutrigen.data.WtsDB;
import edu.elon.nutrigen.facade.Meal;
import edu.elon.nutrigen.facade.MealItem;
import edu.elon.nutrigen.facade.NutritionalItem;
import edu.elon.nutrigen.facade.PongFacade;
import edu.elon.nutrigen.facade.PongJavaFacade;
import edu.elon.nutrigen.facade.ScheduledMeal;

/**
 * Servlet that tries to login in a registered user. If not registered then
 * returns a 401 status code. If registered then reads in User information from
 * testindinfo table and performs subsequent calculationd. The purpose of this
 * servlet is mainly in development to insure that the Adobe Flash code from
 * Martin Kolhmeier was properly ported.
 * 
 * @author dpowell2
 *
 */
public class UserServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		long startTime = 0;
		long endTime = 0;

		boolean userExists = UserDB.userExists(username, password);
		HttpSession session = request.getSession();

		if (userExists) {
			response.setStatus(HttpServletResponse.SC_OK);
			startTime = System.currentTimeMillis();
			User user = UserDB.selectUser(username, password);

			// George: I am assuming that once you have validated a user then
			// you will call only once intializeSession
			// to do all initialization,

			// From that point on you can get create an instance of facade and
			// call it for other needs.

			initializeSession(session, user, out);
			PongFacade facade = getFacade(session, user);

			// George these are simple debugging sample calls that I currently
			// have in to test the facade.
//			 out.println("\n\nCalling facade");
//			 List<ScheduledMeal> meals = facade.getMonthlyMealPlan(new
//			 Date());
//			 out.println("\n\nMeals are: " + meals);

			// debug finding March 20, 2015
//			Date date = new Date(2015 - 1900, 2, 20);
//			Meal meal = facade.getDailyMealPlan(date);
//			
//			 ArrayList<NutritionalItem> items = facade.getIndividualNutrientTargets(session);
//			 out.println("\n\n\nIindivual Profile Targets\n");
//			 out.println(items);
//			 
//			if (meal != null) {
//			 out.println("\n\nMarch 20 meal is: " + meal);
//			 } else {
//			 out.println("\n\nMarch 20 has no meal");
//			 }

			// demonstrate getting the first two indexes if George was choosing
			// a plan
//			out.println("\n\n First item on sorted meal plan check URL");
//			out.println(facade.getSortedMealPlan(0));
//			out.println("\n\n 2item on sorted meal plan check URL");
//			out.println(facade.getSortedMealPlan(1));
//			out.println("\n\n 3 item on sorted meal plan check URL");
//			out.println(facade.getSortedMealPlan(2));
//			out.println("\n\n 4 item on sorted meal plan check URL");
//			out.println(facade.getSortedMealPlan(3));
//			out.println("\n\n 5 item on sorted meal plan check URL");
//			out.println(facade.getSortedMealPlan(4));
			
			//get meal item url for 1313
//			out.println("\n\nGet Meal Item URL " + facade.getMealItemUrl(1313));

			// out.println("\n\nSecond item on sorted meal plan");
			// out.println(facade.getSortedMealPlan(1));

			// demonstrate ability to add a meal plan of 1942 on April 3
			// date = new Date(2015 - 1900, 3, 3);
			// facade.setDailyMealPlan(date, 1942);
			// facade.deleteDailyMealPlan(date);
			// demonstrate ability to add a meal plan of 2250 on May 3
			// allow selecting a day out to 1 year. Note rest of Martins code
			// only looks out 9 days.
			// date = new Date(2015 - 1900, 4, 3);
			// facade.setDailyMealPlan(date, 2250);

			// demonstrate ability to retrievel nutrional information on a meal
			// item by item number
//			out.println("\n\nMeal Item 1899 ");
//			out.println(facade.getMealItemNutritionInfo(1899));
			
			//attachNutrientInfo(meal, facade);
			//session.setAttribute("meal", meal);
			//response.sendRedirect("/nutrients.jsp");
//			if (meal != null) {
//				 out.println("\n\nMarch 20 meal is: " + meal);
//		    } else {
//				 out.println("\n\nMarch 20 has no meal");
//		    }

		}
	}
	
	
	//Helper method deevloped by George and I to add MealItemNutrietns to a meal
	public void attachNutrientInfo(Meal meal, PongFacade facade){
		for(MealItem item: meal.getBreakfast()){
			int itemNum = item.getItemNumber();
			ArrayList<NutritionalItem> nutitems = (ArrayList<NutritionalItem>) facade.getMealItemNutritionInfo(itemNum);
			item.setItemInfo(nutitems);
		}for(MealItem item: meal.getLunch()){
			int itemNum = item.getItemNumber();
			ArrayList<NutritionalItem> nutitems = (ArrayList<NutritionalItem>) facade.getMealItemNutritionInfo(itemNum);
			item.setItemInfo(nutitems);
		}for(MealItem item: meal.getDinner()){
			int itemNum = item.getItemNumber();
			ArrayList<NutritionalItem> nutitems = (ArrayList<NutritionalItem>) facade.getMealItemNutritionInfo(itemNum);
			item.setItemInfo(nutitems);
		}
	}
	

	public PongFacade getFacade(HttpSession session, User user) {
		PongFacade aFacade = (PongJavaFacade) session.getAttribute("facade");
		if (aFacade == null) {
			aFacade = new PongJavaFacade(user.getIndNum(), session);
		}

		return aFacade;

	}

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
		if (DEBUG) {
			System.out.println("Number of login enteries added: " + count);
		}

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

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost1(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		long startTime = 0;
		long endTime = 0;

		boolean userExists = UserDB.userExists(username, password);
		HttpSession session = request.getSession();
		State state = new State();
		if (userExists) {
			response.setStatus(HttpServletResponse.SC_OK);
			startTime = System.currentTimeMillis();
			User user = UserDB.selectUser(username, password);
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Login: " + (endTime - startTime));
			out.println("Status: " + HttpServletResponse.SC_OK);
			out.println(user);

			// log login to database in loginlog table

			int count = UserDB.loginLogging(user.getIndNum());
			System.out.println("Number of login enteries added: " + count);

			// get optinfo
			startTime = System.currentTimeMillis();
			OptInfo optInfo = OptInfoDB.selectOptInfo(user.getIndNum());
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Optinfo: " + (endTime - startTime));
			out.println(optInfo);

			// get adjust info
			startTime = System.currentTimeMillis();
			Adjust adjust = AdjustDB
					.selectAdjustInfo(user.getIndNum(), optInfo);
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Adjust: " + (endTime - startTime));
			out.println(adjust);

			// get wts info
			startTime = System.currentTimeMillis();
			Wts wts = WtsDB.selectWtsInfo(user.getIndNum(), optInfo);
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Wts: " + (endTime - startTime));
			out.println(wts);

			// get exercise info
			startTime = System.currentTimeMillis();
			Exercise exercise = ExerciseDB.selectExerciseInfo(user.getIndNum());
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Exercise: " + (endTime - startTime));
			out.println(exercise);

			// get indcombo info
			startTime = System.currentTimeMillis();
			IndCombo indCombo = IndComboDB.selectIndComboInfo(user.getIndNum());
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time IndCombo: " + (endTime - startTime));
			out.println(indCombo);

			// get calories info
			startTime = System.currentTimeMillis();
			Calories calories = CaloriesDB.selectCaloriesInfo(user.getIndNum());
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Calories: " + (endTime - startTime));
			out.println(calories);

			DateManager dateManager = new DateManager();
			out.println();
			out.println("Data Manager: ");
			out.println(dateManager);

			// get CurrentMealPlanner Info
			startTime = System.currentTimeMillis();
			MealPlanner mealPlanner = MealPlannerDB.selectMealPlannerInfo(
					user.getIndNum(), (int) dateManager.getReferenceday());
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time MealPlanner: " + (endTime - startTime));
			out.println(mealPlanner);

			// get Diet Info
			startTime = System.currentTimeMillis();
			Diet diet = DietDB.selectDietInfo(user.getIndNum());
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Diet: " + (endTime - startTime));
			out.println(diet);

			// insert Adequacy rates into testadequacy table
			startTime = System.currentTimeMillis();
			Adequacy adequacy = new Adequacy(user, exercise, optInfo, calories,
					adjust, diet);
			// Put data into testadequacy database
			AdequacyDB.insertAdequacyRates(user.getIndNum(), adequacy);
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Adequacy: " + (endTime - startTime));
			out.println(adequacy);

			// get the current user weekly meals and all of the meals ranked
			// for the user
			startTime = System.currentTimeMillis();
			MealCombos mealcombos = new MealCombos(adequacy, mealPlanner, wts,
					indCombo, optInfo, user, state, dateManager);
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Meal Combos: " + (endTime - startTime));
			out.println("Found " + mealcombos.getFoodcombos().size()
					+ "Food combinations");
			out.println(mealcombos.getFoodcombos().get(0));

			// DJP - print size of selected food combos. This is the number of
			// days from MealPlanning for the upcoming week that have a nrFC set
			out.println("\n\n\nRaw Food Combos for current meal plan"
					+ mealcombos.getRawcombos().size());
			// DJP print raw combos
			for (MealCombo m : mealcombos.getRawcombos()) {
				out.println(m);
			}

			// **This has a size of 10 for the current meal plan. In general it
			// has the raw food combos listed first followed by blank meals
			// **Keep in mind that Martin starts at 1 and not 0 for array
			// looping
			out.println("\n\n\nSelected Food Combos for current meal plan"
					+ mealcombos.getSelectedMealcombos().size());
			for (MealCombo m : mealcombos.getSelectedMealcombos()) {
				out.println(m);
			}

			// get food info and loads into AllpASS
			startTime = System.currentTimeMillis();
			FoodInfo foodInfo = FoodInfoDB.selectFoodInfo(optInfo,
					mealcombos.getFoods());
			Allpass foods = mealcombos.getFoods();
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time FoodInfo to read in data and initialize data in Allpass: "
					+ (endTime - startTime));
			out.println("Allpass has " + foods.getFoodcombos().size()
					+ " to process in meals calc");

			// Calculate the meals
			startTime = System.currentTimeMillis();
			mealcombos.mealscalc();
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Allpass to mealcalc: " + (endTime - startTime));

			// Call planscalc() - TODO In progress
			mealcombos.planscalc();

			// print out the number of currentfoods that should be in sorted
			// order
			ArrayList<MealComboCompare> currentfoods = mealcombos
					.getCurrentfoods();
			out.println();
			out.println("MealComboCompare has " + currentfoods.size()
					+ "entries");
			out.println(currentfoods.get(0));

			// print out MealComboCompare to see if it has NR = nrFC
			out.println("\n\nTrying to see if NR equals nrFC");
			for (MealComboCompare c : currentfoods) {
				if (c.getNr() == 2079) {
					out.println(c);
				}

			}

			PongFacade facade = new PongJavaFacade(user.getIndNum());
			out.println("\n\nCalling facade");
			List<ScheduledMeal> meals = facade.getMonthlyMealPlan(new Date());

			out.println("\n\nMeals are: " + meals);
			
			

			// TODO determine variables that need to be in session scope
			startTime = System.currentTimeMillis();
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
			endTime = System.currentTimeMillis();
			out.println();
			out.println("Time Save Session States: " + (endTime - startTime));

			// session.setAttribute("foodInfo", foodInfo);
			// session.setAttribute("foods", foods); //this is Allpass
			//
			// My hypothesis is that without editing, just need
			// currentmealplans, currentfoods,
			// optInfo for nutrient names and adequacy for nutrient targets.

		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			out.println("Status: " + HttpServletResponse.SC_UNAUTHORIZED);
		}

	}
}
