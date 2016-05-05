package edu.elon.nutrigen.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

public abstract class PongFacade implements Serializable {
	// unique number used to represent each user.
	private int indNum;
	
	public PongFacade() {
		this(1678); //youngwoman
	}

	public PongFacade(int indNum) {
		this.indNum = indNum;
	}
	
	public String getMealItemUrl(int item) {
		return null;
	}

	public int getIndNum() {
		return indNum;
	}

	/**
	 * Each user in Pong has a unique number assigned. This number is needed for
	 * querying database for information related to user.
	 * 
	 * @param indNum
	 *            int assigned to each user upon registration.
	 */
	public void setIndNum(int indNum) {
		this.indNum = indNum;
	}



	public abstract Meal getDailyMealPlan(Date date);

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
	public abstract List<ScheduledMeal> getMonthlyMealPlan(Date date);

	public abstract Meal getSortedMealPlan(int index);

	public abstract List<Meal> getSortedMealPlan();

	public abstract void setDailyMealPlan(Date date, int mealNumber);

	public abstract void deleteDailyMealPlan(Date date);
	
	
	/**
	 * Need a way to get the nutritional information on a given meal item. Each meal item has
	 * a unique number assigned. A DB lookup is done on number and full nutritional information
	 * is returned.
	 * 
	 * @param itemNumber int number assigned to each meal
	 * @return List of NutritionalItem for this meal item. Currently, the values are only the name, nutrient value and nutrient units. The
	 * nutrient target and nutrient bounds are not supplied as the GUI was not using them. They could be added if warranted.
	 */
	public abstract List<NutritionalItem> getMealItemNutritionInfo(int itemNumber);

	/**
	 * Gets individual target profile nutrient targets
	 * 
	 * @param session HttpSession for current signed on user
	 * @return ArrayList<NutrientItem> targets for the user.
	 */
	public abstract ArrayList<NutritionalItem> getIndividualNutrientTargets(
			HttpSession session);

}
