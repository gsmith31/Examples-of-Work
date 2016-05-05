package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.ArrayList;

import edu.elon.nutrigen.data.MealComboDB;

public class MealCombos implements Serializable {
	private ArrayList<MealCombo> selectedMealcombos;
	private ArrayList<MealComboNutrients> foodcombos;
	private transient ArrayList<MealComboNutrients> rawcombos;
	private ArrayList<MealComboCompare> currentfoods;
	private transient Allpass foods;
	private transient Adequacy adequacy;
	private transient MealPlanner mealPlanner;
	private transient Wts wts;
	private transient IndCombo indCombo; // gives access to pref array
	private transient OptInfo optInfo;
	private transient User user;
	private transient State state;
	private transient DateManager dateManager;
	private double currentFraction;

	public MealCombos(Adequacy adequacy, MealPlanner mealPlanner, Wts wts,
			IndCombo indCombo, OptInfo optInfo, User user, State state,
			DateManager dateManager) {
		currentFraction = 0.94;
		this.adequacy = adequacy;
		this.mealPlanner = mealPlanner;
		this.wts = wts;
		this.indCombo = indCombo;
		this.optInfo = optInfo;
		this.user = user;
		this.state = state;
		this.dateManager = dateManager;

		selectedMealcombos = new ArrayList<MealCombo>();
		foodcombos = new ArrayList<MealComboNutrients>();
		rawcombos = new ArrayList<MealComboNutrients>();
		initializeMealCombos();
		getCombos(this, adequacy, mealPlanner, wts);
		// add in comborating to selected foodcombos
		addComborating();
		// create Allpass instance and put combos into it
		createAndInitializeFoods();
		// sort selectedmealcombos have to be sorted in order of current meal
		// plan
		sortSelectedMealcombos();
	}

	/**
	 * current meal plan
	 */
	private void sortSelectedMealcombos() {
		int[] currentMealPlan = mealPlanner.getCurrentMealPlan();
		for (int m = 1; m < 9; m++) {
			for (int mm = 0; mm < rawcombos.size(); mm++) {
				int nrFC = rawcombos.get(mm).getNrFC();
				if ((nrFC != 0) && (nrFC == currentMealPlan[m])) {
					// DJP during port, created inheriticance hierarchy to allow
					// switching
					// a MealComboLabel with a MealComboNutrient
					selectedMealcombos.set(m, rawcombos.get(mm));
				}
			}
		}

	}

	/*
	 * Instantiate All pass with MenuFoodNutrients. Allpass will receive arrays
	 * of data in FoodInfo construction
	 */
	private void createAndInitializeFoods() {
		foods = new Allpass();
		foods.loadfoodcombos(foodcombos);
	}

	private void initializeMealCombos() {
		for (int i = 0; i < 10; i++) {
			MealCombo meal = new MealComboLabel();
			meal.settCo2(i);
			selectedMealcombos.add(meal);
		}
	}

	private void addComborating() {
		int[] prefArray = indCombo.getPrefArray();
		for (int i = 0; i < foodcombos.size(); i++) {
			MealComboNutrients meal = foodcombos.get(i);
			int nrFC = meal.getNrFC();
			if (prefArray[nrFC] != 0) {
				meal.setRating(prefArray[nrFC]);
			} else {
				meal.setRating(-1);
			}
		}

	}

	public void addFoodCombos(MealComboNutrients item) {
		foodcombos.add(item);
	}

	public void addRawCombos(MealComboNutrients item) {
		rawcombos.add(item);
	}

	/**
	 * Gets the meal combos from the DB
	 * 
	 * @param combos
	 * @param adequacy
	 * @param mealPlanner
	 * @param wts
	 */
	private void getCombos(MealCombos combos, Adequacy adequacy,
			MealPlanner mealPlanner, Wts wts) {
		MealComboDB.selectMealComboInfo(combos, adequacy, mealPlanner, wts);
	}

	public ArrayList<MealCombo> getSelectedMealcombos() {
		return selectedMealcombos;
	}

	public void setSelectedMealcombos(ArrayList<MealCombo> selectedMealcombos) {
		this.selectedMealcombos = selectedMealcombos;
	}

	public ArrayList<MealComboNutrients> getFoodcombos() {
		return foodcombos;
	}

	public void setFoodcombos(ArrayList<MealComboNutrients> foodcombos) {
		this.foodcombos = foodcombos;
	}

	public ArrayList<MealComboNutrients> getRawcombos() {
		return rawcombos;
	}

	public void setRawcombos(ArrayList<MealComboNutrients> rawcombos) {
		this.rawcombos = rawcombos;
	}

	@Override
	public String toString() {
		return "MealCombos [selectedMealcombos=" + selectedMealcombos
				+ ", foodcombos=" + foodcombos + ", rawcombos=" + rawcombos
				+ "]";
	}

	public Allpass getFoods() {
		return foods;
	}

	public void setFoods(Allpass foods) {
		this.foods = foods;
	}

	public double getCurrentFraction() {
		return currentFraction;
	}

	public void setCurrentFraction(double currentFraction) {
		this.currentFraction = currentFraction;
	};

	/**
	 * Creates information needed by AllPass for sorting and then asks Allpass
	 * to sort the items by dlt
	 */
	public void mealscalc() {
		Limit limit = new Limit(adequacy, this, optInfo, user, wts);
		currentfoods = foods.sortItems(limit);
		state.setReplaceitemtext("");
		state.setAfterloginVisible(true);
		state.setCurrentTab(0);
		state.setCurrentState("mealplans");
		dateManager.setSelectedday(2);
		if (mealPlanner.getCurrentMealPlan()[2] > 0) {
			mealPlanner.setMealplantext1("Combination "
					+ mealPlanner.getCurrentMealPlan()[1]);
		} else {
			mealPlanner.setMealplantext1("No Combination");
		}
		state.setCurrentitemRow(0);
	}

	public ArrayList<MealComboCompare> getCurrentfoods() {
		return currentfoods;
	}

	public void setCurrentfoods(ArrayList<MealComboCompare> currentfoods) {
		this.currentfoods = currentfoods;
	}

	private int getNumberOfDefinedPlans() {
		int total = 0;
		for (int i = 1; i < 9; i++) {
			total = total + mealPlanner.getCurrentMealPlan()[i];
		}
		return total;
	}

	public void planscalc() {
		int mploaded = getNumberOfDefinedPlans();

		System.out.println("Mploaded: " + mploaded);
		if (mploaded == 0) {
			int mp;
			int mpday;
			int nrFC;
			int mpdlt;
			Date useNow;
			long usedayTime;
			String usedata = "000000000000000000000000000000000000000000000";

			for (mp = 1; mp < 9; mp++) {
				if (this.getCurrentfoods().get(mp).getDlt() < 101) {
					mealPlanner.getCurrentMealPlan()[mp] = currentfoods.get(mp)
							.getNr();
				}

				mpday = (int) dateManager.getReferenceday() + mp - 1;
				nrFC = currentfoods.get(mp).getNr();
				mpdlt = (int) Math.round(currentfoods.get(mp).getDlt());
				useNow = new Date();
				usedayTime = useNow.getTime();
				// need to insert into DB
				// String insert = INSERT INTO `testmealplanner`
				// (menucounter,useday_time,ind_num,nrFC,usedata,dlt,useday)
				// VALUES (DEFAULT,?,?,?,?,?,?)" ,"
				// + "			GetSQLValueString($_REQUEST["menucounter"], "int"), # "
				// + "GetSQLValueString($_REQUEST["useday_time"], "text"), #
				// GetSQLValueString($_REQUEST["ind_num"], "text"), #
				// GetSQLValueString($_REQUEST["nrFC"], "int"), #
				// GetSQLValueString($_REQUEST["usedata"], "text"), #
				// GetSQLValueString($_REQUEST["dlt"], "int"), #
				// GetSQLValueString($_REQUEST["useday"], "int")#
				// menucounter is ""
				// useday_time is useday_time ?? does not make sense as getTime
				// is number of seconds since 1970
				// ind_num
				// nrFC
				// usedata
				// dlt is mpdlt
				// useday is mpday
				System.out.println("Menucounter: " + "");
				System.out.println("UsedayTime: " + usedayTime);
				System.out.println("ind_num: " + user.getIndNum());
				System.out.println("nrfc: " + nrFC);
				System.out.println("usedata: " + usedata);
				System.out.println("dlt: " + mpdlt);
				System.out.println("useday: " + mpday);
				System.out.println("reference day: "
						+ dateManager.getReferenceday());
			}

		}

	}

}
