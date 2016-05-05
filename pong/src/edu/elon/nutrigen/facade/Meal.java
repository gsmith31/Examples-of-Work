package edu.elon.nutrigen.facade;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Serializable {

	private ArrayList<MealItem> breakfast;
	private ArrayList<MealItem> lunch;
	private ArrayList<MealItem> dinner;
	private ArrayList<NutritionalItem> nutrientInfo;
	private int mealNumber;
	private int rating;
	private double dlt;
	private String icon;

	public double getDlt() {
		return dlt;
	}

	public void setDlt(double dlt) {
		this.dlt = dlt;
	}

	public ArrayList<NutritionalItem> getNutrientInfo() {
		return nutrientInfo;
	}

	public void setNutrientInfo(ArrayList<NutritionalItem> nutrientInfo) {
		this.nutrientInfo = nutrientInfo;
	}

	public ArrayList<MealItem> getBreakfast() {
		return breakfast;
	}

	public ArrayList<MealItem> getLunch() {
		return lunch;
	}

	public ArrayList<MealItem> getDinner() {
		return dinner;
	}

	public Meal(int mealNumber, int rating) {
		super();
		this.mealNumber = mealNumber;
		this.rating = rating;
		breakfast = new ArrayList<MealItem>();
		lunch = new ArrayList<MealItem>();
		dinner = new ArrayList<MealItem>();
		nutrientInfo = new ArrayList<NutritionalItem>();
	}

	public Meal() {
		this(0, 0);
	}

	public int getMealNumber() {
		return mealNumber;
	}

	public void setMealNumber(int mealNumber) {
		this.mealNumber = mealNumber;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setBreakfast(ArrayList<MealItem> b) {
		breakfast = b;
	}

	public void setLunch(ArrayList<MealItem> l) {
		lunch = l;
	}

	public void setDinner(ArrayList<MealItem> d) {
		dinner = d;
	}

	@Override
	public String toString() {
		return "Meal [breakfast=" + breakfast + ", lunch=" + lunch
				+ ", dinner=" + dinner + ", nutrientInfo=" + nutrientInfo
				+ ", mealNumber=" + mealNumber + ", rating=" + rating
				+ ", dlt=" + dlt + "]";
	}

	public String getIcon() {
		if (dlt < 35) {
			return "panel panel-success";
		}
		else if (dlt >= 35 && dlt < 75) {
			return "panel panel-warning";
		}
		else{
			return "panel panel-danger";
		}
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
