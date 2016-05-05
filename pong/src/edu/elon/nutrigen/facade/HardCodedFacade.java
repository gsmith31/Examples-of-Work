package edu.elon.nutrigen.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import edu.elon.nutrigen.business.DateManager;

public class HardCodedFacade extends PongFacade{

	@Override
	public Meal getDailyMealPlan(Date date) {
		NutritionalItem item1 = new NutritionalItem("Energy", 50, "kcal");
		NutritionalItem item2 = new NutritionalItem("Protien", 1.65,"g");
		NutritionalItem item3 = new NutritionalItem("Saturated Fat", 0.06, "g");
		NutritionalItem item4 = new NutritionalItem("Cholesterol", 0, "mg");
		NutritionalItem item5 = new NutritionalItem("Folate", 19, "ug");
		NutritionalItem item6 = new NutritionalItem("Added Folate", 15, "ug");
		NutritionalItem item7 = new NutritionalItem("Vitamin C", 0, "mg");
		NutritionalItem item8 = new NutritionalItem("Iron", 4.5,"mg");
		NutritionalItem item9 = new NutritionalItem("Sodium", 1, "mg");
		NutritionalItem item10 = new NutritionalItem("Calcium", 6, "mg");
		NutritionalItem item11 = new NutritionalItem("Magnesium", 13, "mg");
		NutritionalItem item12 = new NutritionalItem("Red Meat", 0, "g");
		NutritionalItem item13 = new NutritionalItem("Fruits/Veggies", 0, "g");
		NutritionalItem item14 = new NutritionalItem("Vitamin A", 0, "g");
		NutritionalItem item15 = new NutritionalItem("Preformed Vit A", 0, "iU");
		NutritionalItem item16 = new NutritionalItem("Beta Carotene", 0, "iU");
		ArrayList<NutritionalItem> items = new ArrayList<NutritionalItem>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		items.add(item10);
		items.add(item11);
		items.add(item12);
		items.add(item13);
		items.add(item14);
		items.add(item15);
		items.add(item16);
		
		Meal aMeal = new Meal();
		//BreakFast
		MealItem b1 = new MealItem("Kellogs Shredded Mini Wheats");
		b1.setItemInfo(items);
		MealItem b2 = new MealItem("Soy Milk");
		MealItem b3 = new MealItem("Banana");
		MealItem b4 = new MealItem("OJ");
		ArrayList<MealItem> breakfast = new ArrayList<MealItem>();
		breakfast.add(b1);
		breakfast.add(b2);
		breakfast.add(b3);
		breakfast.add(b4);
		//Lunch
		MealItem l1 = new MealItem("Chili");
		MealItem l2 = new MealItem("Potato");
		MealItem l3 = new MealItem("Asperagus");
		ArrayList<MealItem> lunch = new ArrayList<MealItem>();
		breakfast.add(l1);
		breakfast.add(l2);
		breakfast.add(l3);
		//Dinner
		MealItem d1 = new MealItem("McMuffin");
		MealItem d2 = new MealItem("Snack");
		MealItem d3 = new MealItem("Grapefruit");
		ArrayList<MealItem> dinner = new ArrayList<MealItem>();
		breakfast.add(d1);
		breakfast.add(d2);
		breakfast.add(d3);

		aMeal.setBreakfast(breakfast);;
		aMeal.setLunch(lunch);
		aMeal.setDinner(dinner);
		return aMeal;
		
	}

	@Override
	public List<ScheduledMeal> getMonthlyMealPlan(Date date) {
		ArrayList<ScheduledMeal> meals = new ArrayList<ScheduledMeal>();
		DateManager dateManager = new DateManager();
		for(int i = 0; i<30;i++){
			Date adate = new Date(2015-1900, 3, i + 1);
			ScheduledMeal aSMeal = new ScheduledMeal(true, 1, adate, 2249, dateManager.getReferenceDay(adate), null, 1);
			meals.add(aSMeal);
		}
		return meals;
	}

	@Override
	public Meal getSortedMealPlan(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> getSortedMealPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDailyMealPlan(Date date, int mealNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDailyMealPlan(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NutritionalItem> getMealItemNutritionInfo(int itemNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NutritionalItem> getIndividualNutrientTargets(
			HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

}
