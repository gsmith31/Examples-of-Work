package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Class gets data from testmealplanner DB
 * 
 * @author dpowell2
 *
 */
public class MealPlanner implements Serializable {
	private int[] currentMealPlan;
	private String mealplantext1;
 
	public MealPlanner() {
		//Dave - support meal planning for 12 months out or 360 days
		//Martin had set at 10 days but George is going to support 12 months out.
		currentMealPlan = new int[360];
	}
	
	public void setCurrentMealPlanItem(int transmeals, int nrFC) {
		//Martins code returns negative indexes
		if (transmeals < 0) {
			return;
		}
//		if (transmeals >= currentMealPlan.length) {
//			currentMealPlan = Arrays.copyOf(currentMealPlan,transmeals + 1);
//		}
		currentMealPlan[transmeals] = nrFC;
	}

	@Override
	public String toString() {
		return "MealPlanner [currentMealPlan="
				+ Arrays.toString(currentMealPlan) + "]";
	}

	public int[] getCurrentMealPlan() {
		return currentMealPlan;
	}

	public void setCurrentMealPlan(int[] currentMealPlan) {
		this.currentMealPlan = currentMealPlan;
	}

	public String getMealplantext1() {
		return mealplantext1;
	}

	public void setMealplantext1(String mealplantext1) {
		this.mealplantext1 = mealplantext1;
	}

}
