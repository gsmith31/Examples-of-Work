package edu.elon.nutrigen.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import edu.elon.nutrigen.business.Adequacy;
import edu.elon.nutrigen.business.Calories;
import edu.elon.nutrigen.business.DateManager;
import edu.elon.nutrigen.business.MealComboCompare;
import edu.elon.nutrigen.business.MealCombos;
import edu.elon.nutrigen.business.OptInfo;
import edu.elon.nutrigen.data.FoodInfoDB;
import edu.elon.nutrigen.data.MealPlannerDB;
import edu.elon.nutrigen.data.RecipeDB;

/**
 * Implementation for proof of concept using servets/JSP, app engine and MySQL
 * backend.
 * 
 * @author dpowell2
 *
 */
public class PongJavaFacade extends PongFacade implements Serializable {
	private HttpSession session;

	/**
	 * Critical piece for Facade is to know which individual it is querying data
	 * for. The entire DB that is read in is based on the individual and the meals ratings
	 * and nutrients are based on the individual profile (age, weight, etc)
	 * 
	 * 
	 * @param indNum int value for unique value attached to each user
	 */
	public PongJavaFacade(int indNum) {
		super(indNum);
	}

	/**
	 * Creates instance based on validated login user and current session. The session is critical for accessing
	 * previously time intensive data collection of meals.
	 * 
	 * @param indNum int number unique for each user
	 * @param session HttpSession state associated with current login user
	 */
	public PongJavaFacade(int indNum, HttpSession session) {
		this.session = session;
	}

	/**
	 * Gets the meal plan if any set for the current date. If none are set then
	 * returns null. If MealPlan is set then build up the Meal wihich is made up
	 * of MealItems for breakfast, lunch and dinner along with the daily
	 * nutrition info for the meail
	 * 
	 * @param date
	 *            Date desired for meal
	 */
	@Override
	public Meal getDailyMealPlan(Date date) {
		DateManager dateManager = new DateManager();
		// get reference day associated with date
		int day = dateManager.getReferenceDay(date);
		// get the meal plan number from dB associated with this date.
		Meal meal = MealPlannerDB.selectMealPlanByDateInfo(this.getIndNum(),
				day);
		// if meal plan associated with date then get MealComboCompare to get
		// meal item info
		if (meal != null) {
			MealCombos mealCombos = (MealCombos) session
					.getAttribute("mealcombos");
			MealComboCompare foundMeal = null;
			// get Meal Combo and rating

			for (MealComboCompare mc : mealCombos.getCurrentfoods()) {
				if (mc.getNr() == meal.getMealNumber()) {
					foundMeal = mc;
					meal.setRating(mc.getRating());
					meal.setDlt(mc.getDlt());
					meal.setNutrientInfo(getMealNutrients(mc, session));
					break;
				}
			}
			// Need to make breakfast, lunch and dinner
			meal.setBreakfast(getBreakfast(foundMeal));
			meal.setLunch(getLunch(foundMeal));
			meal.setDinner(getDinner(foundMeal));
			//DJP try to see if faster if call separately
			ArrayList<MealItem> items = meal.getBreakfast();
			for (MealItem item : items) {
				item.setUrl(this.getMealItemUrl(item.getItemNumber()));
			}
			 
			for (MealItem item : meal.getLunch()) {
				item.setUrl(this.getMealItemUrl(item.getItemNumber()));
			}
			
			for (MealItem item : meal.getDinner()) {
				item.setUrl(this.getMealItemUrl(item.getItemNumber()));
			}
		}
		return meal;
	}
	
	/**
	 * The nutrients for a complete meal are calculated at different parts of the program. This
	 * method gets the values for a complete meal and returns it as an array list of nutrionalitems.
	 * 
	 * @param mc MealComboCompare for access to calculated nutrional values
	 * @param session HttpSession that stores the information between requests for a user.
	 * @return ArrayList of NutrionalItems that describe the name, value, units, target value and bound
	 */
	private ArrayList<NutritionalItem> getMealNutrients(MealComboCompare mc, HttpSession session) {
		ArrayList<NutritionalItem> nutrients = new ArrayList<NutritionalItem>();
		Calories calories = (Calories) session.getAttribute("calories");
		OptInfo optInfo = (OptInfo) session.getAttribute("optInfo");
		Adequacy adequacy = (Adequacy) session.getAttribute("adequacy");
		String category = calories.getEnmodified() + " Energy";
		double nutrientValue = mc.getEn();
		String units = "kcal";
		double target = adequacy.getEnTarget();
		String bound = "=";
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));
		
		category = optInfo.getNut0name();
		nutrientValue = mc.getNut0();
		units = optInfo.getNut0unit();
		target = adequacy.getNut0Target();
		bound = optInfo.getNut0linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));	
		
		category = optInfo.getNut1name();
		nutrientValue = mc.getNut1();
		units = optInfo.getNut1unit();
		target = adequacy.getNut1Target();
		bound = optInfo.getNut1linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));	
		
		category = optInfo.getNut2name();
		nutrientValue = mc.getNut2();
		units = optInfo.getNut2unit();
		target = adequacy.getNut2Target();
		bound = optInfo.getNut2linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));	
		
		category = optInfo.getNut3name();
		nutrientValue = mc.getNut3();
		units = optInfo.getNut3unit();
		target = adequacy.getNut3Target();
		bound = optInfo.getNut3linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));	
		
		category = optInfo.getNut4name();
		nutrientValue = mc.getNut4();
		units = optInfo.getNut4unit();
		target = adequacy.getNut4Target();
		bound = optInfo.getNut4linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));	
		
		category = optInfo.getNut5name();
		nutrientValue = mc.getNut5();
		units = optInfo.getNut5unit();
		target = adequacy.getNut5Target();
		bound = optInfo.getNut5linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));	
		
		category = optInfo.getNut6name();
		nutrientValue = mc.getNut6();
		units = optInfo.getNut6unit();
		target = adequacy.getNut6Target();
		bound = optInfo.getNut6linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));
		
		category = optInfo.getNut7name();
		nutrientValue = mc.getNut7();
		units = optInfo.getNut7unit();
		target = adequacy.getNut7Target();
		bound = optInfo.getNut7linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));
		
		category = optInfo.getNut8name();
		nutrientValue = mc.getNut8();
		units = optInfo.getNut8unit();
		target = adequacy.getNut8Target();
		bound = optInfo.getNut8linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));
		
		category = optInfo.getNut9name();
		nutrientValue = mc.getNut9();
		units = optInfo.getNut9unit();
		target = adequacy.getNut9Target();
		bound = optInfo.getNut9linker();
		nutrients.add(new NutritionalItem(category, nutrientValue, units, target, bound));
		
				
		return nutrients;
	}
	
	/**
	 * Each meal item can have a recipe. If it does then it has a URL for the location of recipe. Method looks up
	 * URL in DB based on itemNumber. 
	 * 
	 * @param itemNumber unique number for each food item
	 * @return String of URL or null if no recipe exists.
	 */
	public String getMealItemUrl(int itemNumber) {
		return RecipeDB.getUrl(itemNumber);
	}

	private ArrayList<MealItem> getBreakfast(MealComboCompare meal) {
		OptInfo optInfo = (OptInfo) session.getAttribute("optInfo");
		ArrayList<MealItem> breakfast = new ArrayList<MealItem>();
		if (meal.getItem1() != 0) {
			int itemNumber = meal.getItem1();
			MealItem item = new MealItem(meal.getLabel1(), itemNumber);
			breakfast.add(item);
		}
		if (meal.getItem2() != 0) {
			int itemNumber = meal.getItem2();
			MealItem item = new MealItem(meal.getLabel2(), itemNumber);
			breakfast.add(item);
		}
		if (meal.getItem3() != 0) {
			int itemNumber = meal.getItem3();
			MealItem item = new MealItem(meal.getLabel3(), itemNumber);
			breakfast.add(item);
		}
		if (meal.getItem4() != 0) {
			int itemNumber = meal.getItem4();
			MealItem item = new MealItem(meal.getLabel4(), itemNumber);
			breakfast.add(item);
		}
		if (meal.getItem5() != 0) {
			int itemNumber = meal.getItem5();
			MealItem item = new MealItem(meal.getLabel5(), itemNumber);
			breakfast.add(item);
		}
		if (meal.getItem6() != 0) {
			int itemNumber = meal.getItem6();
			MealItem item = new MealItem(meal.getLabel6(), itemNumber);
			breakfast.add(item);
		}
		if (meal.getItem7() != 0) {
			int itemNumber = meal.getItem7();
			MealItem item = new MealItem(meal.getLabel7(), itemNumber);
			breakfast.add(item);
		}
		return breakfast;
	}

	private ArrayList<MealItem> getLunch(MealComboCompare meal) {
		ArrayList<MealItem> lunch = new ArrayList<MealItem>();
		if (meal.getItem8() != 0) {
			lunch.add(new MealItem(meal.getLabel8(), meal.getItem8()));
		}
		if (meal.getItem9() != 0) {
			lunch.add(new MealItem(meal.getLabel9(), meal.getItem9()));
		}
		if (meal.getItem10() != 0) {
			lunch.add(new MealItem(meal.getLabel10(), meal.getItem10()));
		}
		if (meal.getItem11() != 0) {
			lunch.add(new MealItem(meal.getLabel11(), meal.getItem11()));
		}
		if (meal.getItem12() != 0) {
			lunch.add(new MealItem(meal.getLabel12(), meal.getItem12()));
		}
		if (meal.getItem13() != 0) {
			lunch.add(new MealItem(meal.getLabel13(), meal.getItem13()));
		}
		if (meal.getItem14() != 0) {
			lunch.add(new MealItem(meal.getLabel14(), meal.getItem14()));
		}
		return lunch;
	}

	private ArrayList<MealItem> getDinner(MealComboCompare meal) {
		ArrayList<MealItem> dinner = new ArrayList<MealItem>();
		if (meal.getItem15() != 0) {
			dinner.add(new MealItem(meal.getLabel15(), meal.getItem15()));
		}
		if (meal.getItem16() != 0) {
			dinner.add(new MealItem(meal.getLabel16(), meal.getItem16()));
		}
		if (meal.getItem17() != 0) {
			dinner.add(new MealItem(meal.getLabel17(), meal.getItem17()));
		}
		if (meal.getItem18() != 0) {
			dinner.add(new MealItem(meal.getLabel18(), meal.getItem18()));
		}
		if (meal.getItem19() != 0) {
			dinner.add(new MealItem(meal.getLabel19(), meal.getItem19()));
		}
		if (meal.getItem20() != 0) {
			dinner.add(new MealItem(meal.getLabel20(), meal.getItem20()));
		}
		if (meal.getItem21() != 0) {
			dinner.add(new MealItem(meal.getLabel21(), meal.getItem21()));
		}
		return dinner;
	}

	/**
	 * Given the Date, returns a full month of ScheduledMeal instances. Each
	 * ScheduledMeal instance will reflect a Date of the month and whether there
	 * is or is not a planned meal for that day.
	 * 
	 * @param date
	 *            - represents a day in the month for which the month of
	 *            scheduled meals will be determined.
	 * @return Fully month of days filled and unfilled
	 */
	@Override
	public List<ScheduledMeal> getMonthlyMealPlan(Date date) {
		DateManager dateManager = new DateManager();
		// get first day of month as reference day
		int firstDay = dateManager.getFirstDayOfMonthRefDay(date);
		// get last day of month as reference day
		int lastDay = dateManager.getLastDayOfMonthRefDay(date);

		// query DB for list of meals within date ranges inclusive sorted by
		// referenceday
		List<ScheduledMeal> meals = MealPlannerDB.selectMealPlannerByMonthInfo(
				this.getIndNum(), firstDay, lastDay);

		// transform and update list into a full month and add values for
		// exists, ratings and date.
		// create a list with days of the month and then fill in with meals
		List<ScheduledMeal> monthOfMeals = new ArrayList<ScheduledMeal>();
		for (int i = firstDay; i <= lastDay; i++) {
			ScheduledMeal meal = new ScheduledMeal();
			meal.setExists(false);
			meal.setReferenceDay(i);
			meal.setDate(dateManager.getDateFromReferenceDay(i));
			meal.setMealNumber(0); // unknown at this point
			meal.setRating(0); // unknown at this point
			meal.setDlt(0); //unknown as this point
			monthOfMeals.add(meal);
		}
		// walk list of meals from DB and overwrite in proper location
		for (int i = 0; i < meals.size(); i++) {
			for (int j = 0; j < monthOfMeals.size(); j++) {
				if (meals.get(i).getReferenceDay() == monthOfMeals.get(j)
						.getReferenceDay()) {
					// replace in month
					monthOfMeals.set(j, meals.get(i));
				}
			}
		}

		MealCombos mealCombos = (MealCombos) session.getAttribute("mealcombos");
		// build property list of all ratings based on meal number
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Double> map1 = new HashMap<Integer, Double>();
		for (MealComboCompare mc : mealCombos.getCurrentfoods()) {
			map.put(mc.getNr(), mc.getRating());
			map1.put(mc.getNr(), mc.getDlt());
		}
		// only need to fill in rating and dlt
		for (int j = 0; j < monthOfMeals.size(); j++) {
			Integer rating = map.get(monthOfMeals.get(j).getMealNumber());
			Double dlt = map1.get(monthOfMeals.get(j).getMealNumber());
			if (rating != null) {
				monthOfMeals.get(j).setRating(rating);
			}
			if (dlt != null) {
				monthOfMeals.get(j).setDlt(dlt);
			}
		}
		return monthOfMeals;
	}

	/**
	 * Not efficiently implemented but returns the requested Meal
	 * 
	 * @param index the number or the meal is the ordered list to get
	 * @return Meal at the specified index or null if the index is out of bounds.
	 */
	@Override
	public Meal getSortedMealPlan(int index) {
		List<Meal> meals = getSortedMealPlan();
		Meal meal = null;
		if (index < meals.size()) {
			meal = getSortedMealPlan().get(index);
		}
		return meal;
	}

	/**
	 * Returns the sorted list in optimized rank order of recommended meals for
	 * the current user
	 * 
	 * @return List of Meals sorted in rank order for individual
	 */
	@Override
	public List<Meal> getSortedMealPlan() {
		MealCombos mealCombos = (MealCombos) session.getAttribute("mealcombos");
		// get Meal Combo and rating
		ArrayList<Meal> meals = new ArrayList<Meal>();
		for (MealComboCompare mc : mealCombos.getCurrentfoods()) {
			Meal meal = new Meal();
			meal.setRating(mc.getRating());
			meal.setDlt(mc.getDlt());
			meal.setMealNumber(mc.getNr());
			meal.setBreakfast(getBreakfast(mc));
			meal.setLunch(getLunch(mc));
			meal.setDinner(getDinner(mc));
			meals.add(meal);
		}
		return meals;
	}

	/**
	 * Updates the database with the mealNumber for current user for the 
	 * specified date.
	 * 
	 * @param date Date of the year for the meal to be assigned
	 * @param mealNumber int value for the meal number to be assigned.
	 */
	@Override
	public void setDailyMealPlan(Date date, int mealNumber) {
		// if the day currently has a meal plan then delete it.
		deleteDailyMealPlan(date);
		
		DateManager dateManager = new DateManager();
		int referenceDay = dateManager.getReferenceDay(date);
		
		
		//Need to get the meal combo to get at the dlt
		MealCombos mealCombos = (MealCombos) session
				.getAttribute("mealcombos");
		MealComboCompare foundMeal = null;
		
		for (MealComboCompare mc : mealCombos.getCurrentfoods()) {
			if (mc.getNr() == mealNumber) {
				foundMeal = mc;
				break;
			}
		}
		int dlt = 0;
		if (foundMeal != null) {
			dlt = (int) Math.round(foundMeal.getDlt());
		}
		
		MealPlannerDB.assignMealPlan(this.getIndNum(), date, referenceDay, mealNumber, dlt);
		
	}

	/**
	 * Deletes the meal plan for the current user on the specified date
	 * 
	 * @param date Date instance for day to remove meal plan
	 */
	@Override
	public void deleteDailyMealPlan(Date date) {
		DateManager dateManager = new DateManager();
		int referenceDay = dateManager.getReferenceDay(date);
		MealPlannerDB.deleteMealPlan(this.getIndNum(), referenceDay);
	}

	@Override
	public List<NutritionalItem> getMealItemNutritionInfo(int itemNumber) {
		OptInfo optInfo = (OptInfo) session.getAttribute("optInfo");
		return FoodInfoDB.selectMealItemNutrientInfo(optInfo, itemNumber);
	}
	
	/**
	 * The nutrients for a complete meal are calculated at different parts of the program. This
	 * method gets the values for a complete meal and returns it as an array list of nutrionalitems.
	 * 
	 * @param mc MealComboCompare for access to calculated nutrional values
	 * @param session HttpSession that stores the information between requests for a user.
	 * @return ArrayList of NutrionalItems that describe the name, value, units, target value and bound
	 */
	public ArrayList<NutritionalItem> getIndividualNutrientTargets(HttpSession session) {
		ArrayList<NutritionalItem> nutrients = new ArrayList<NutritionalItem>();
		Calories calories = (Calories) session.getAttribute("calories");
		OptInfo optInfo = (OptInfo) session.getAttribute("optInfo");
		Adequacy adequacy = (Adequacy) session.getAttribute("adequacy");
		String category = calories.getEnmodified() + " Energy";
		String units = "kcal";
		double target = adequacy.getEnTarget();
		String bound = "=";
		nutrients.add(new NutritionalItem(category, 0 , units, target, bound));
		
		category = optInfo.getNut0name();
		 
		units = optInfo.getNut0unit();
		target = adequacy.getNut0Target();
		bound = optInfo.getNut0linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));	
		category = optInfo.getNut1name();
	 
		units = optInfo.getNut1unit();
		target = adequacy.getNut1Target();
		bound = optInfo.getNut1linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));	
		
		category = optInfo.getNut2name();
		units = optInfo.getNut2unit();
		target = adequacy.getNut2Target();
		bound = optInfo.getNut2linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));	
		
		category = optInfo.getNut3name();
		units = optInfo.getNut3unit();
		target = adequacy.getNut3Target();
		bound = optInfo.getNut3linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));	
		
		category = optInfo.getNut4name();
		units = optInfo.getNut4unit();
		target = adequacy.getNut4Target();
		bound = optInfo.getNut4linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));	
		
		category = optInfo.getNut5name();
		units = optInfo.getNut5unit();
		target = adequacy.getNut5Target();
		bound = optInfo.getNut5linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));	
		
		category = optInfo.getNut6name();
		units = optInfo.getNut6unit();
		target = adequacy.getNut6Target();
		bound = optInfo.getNut6linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNut7name();
		units = optInfo.getNut7unit();
		target = adequacy.getNut7Target();
		bound = optInfo.getNut7linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNut8name();
		units = optInfo.getNut8unit();
		target = adequacy.getNut8Target();
		bound = optInfo.getNut8linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNut9name();
		units = optInfo.getNut9unit();
		target = adequacy.getNut9Target();
		bound = optInfo.getNut9linker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNutaname();
		units = optInfo.getNutaunit();
		target = adequacy.getNutaTarget();
		bound = optInfo.getNutalinker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNutbname();
		units = optInfo.getNutbunit();
		target = adequacy.getNutbTarget();
		bound = optInfo.getNutblinker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNutcname();
		units = optInfo.getNutcunit();
		target = adequacy.getNutcTarget();
		bound = optInfo.getNutclinker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNutdname();
		units = optInfo.getNutdunit();
		target = adequacy.getNutdTarget();
		bound = optInfo.getNutdlinker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
		category = optInfo.getNutename();
		units = optInfo.getNuteunit();
		target = adequacy.getNuteTarget();
		bound = optInfo.getNutelinker();
		nutrients.add(new NutritionalItem(category, 0, units, target, bound));
		
				
		return nutrients;
	}
	
 
	
 

}
