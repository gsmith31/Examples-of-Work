package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Inserts values into the testadequacy table
 */
public class Adequacy implements Serializable {
	private transient User user;
	private transient Exercise exercise;
	private transient OptInfo optInfo;
	private transient Calories calories;
	private transient Adjust adjust;
	private transient Diet diet;

	// variables stored in DB
	private int ratefruits;
	private int ratevegs;
	private int ratemeat;
	private int ratefol;
	private int ratevc;
	private int ratebc;
	private int rateca;
	private int ratevd;
	private int asstype;

	// global variables
	private int enUL;
	private int nut0UL;
	private int nut1UL;
	private int nut2UL;
	private int nut3UL;
	private int nut4UL;
	private int nut5UL;
	private int nut6UL;
	private int nut7UL;
	private int nut8UL;
	private int nut9UL;
	private int nutaUL;
	private int nutbUL;
	private int nutcUL;
	private int nutdUL;
	private int nuteUL;

	private double rawendayTarget;
	  
	private double endayTarget;
	private double nut0dayTarget;
	private double nut1dayTarget;
	private double nut2dayTarget;
	private double nut3dayTarget;
	private double nut4dayTarget;
	private double nut5dayTarget;
	private double nut6dayTarget;
	private double nut7dayTarget;
	private double nut8dayTarget;
	private double nut9dayTarget;
	private double nutadayTarget;
	private double nutbdayTarget;
	private double nutcdayTarget;
	private double nutddayTarget;
	private double nutedayTarget;
	
	//added for code used in mealscalc in creating Limit object
	private double enTarget;
	private double nut0Target;
	private double nut1Target;
	private double nut2Target;
	private double nut3Target;
	private double nut4Target;
	private double nut5Target;
	private double nut6Target;
	private double nut7Target;
	private double nut8Target;
	private double nut9Target;
	private double nutaTarget;
	private double nutbTarget;
	private double nutcTarget;
	private double nutdTarget;
	private double nuteTarget;

	// temporary variables
	private int[] UL;
	private double[] RDA;
	private double noexrawendayTarget;
	private double ex;
	private double pa;
	private double RDAfactor;
	private double RDAfactornoex;
	private int dietapprox;

	public Adequacy() {
		UL = new int[50];
		RDA = new double[50];
	}

	public Adequacy(User user, Exercise exercise, OptInfo optInfo,
			Calories calories, Adjust adjust, Diet diet) {
		this.user = user;
		this.exercise = exercise; // get exercise info
		this.optInfo = optInfo; // get sel indexes
		this.calories = calories; // get enreduced
		this.adjust = adjust; // get enadj
		this.diet = diet;

		UL = new int[50];
		RDA = new double[50];
		dietapprox = 1;
		setUL(user.getDRIgrp());
		setRDA(user.getDRIgrp());
		estimateEnergy();
		setGlobalTargets();
		setDbVariables();
	}

	private void setDbVariables() {
		double fruitintake = 0;
		double veggieintake = 0;
		double redmeatintake = 0;
		double folateintake = 0;
		double vitcintake = 0;
		double betacarintake = 0;
		double calciumintake = 0;
		double vitdintake = 0;

		if ((dietapprox == 1)) {
			// dietAss.htmlText =
			// "<font color=\"#990000\"><b>Brief Assessment</b>";
			asstype = 1;
		}

		redmeatintake = diet.getRedmeat();
		// targetText1.htmlText = "<b>Red Meat</b>";
		if ((redmeatintake < 90)) {
			// targetEval1.htmlText = "<font color=\"#008800\"><b>OK</b>";
			ratemeat = 2;
		}
		if ((redmeatintake < 30)) {
			// targetEval1.htmlText = "<font color=\"#008800\"><b>Good</b>";
			ratemeat = 1;
		}
		if ((redmeatintake >= 90)) {
			// targetEval1.htmlText = "<font color=\"#FF0000\"><b>High</b>";
			ratemeat = 3;
		}

		fruitintake = diet.getFruits() + diet.getOJ() * 0.5;

		if ((fruitintake < 320)) {
			// targetEval2.htmlText = "<font color=\"#FF0000\"><b>Low</b>";
			ratefruits = 1;
		}
		if ((fruitintake >= 320)) {
			// targetEval2.htmlText = "<font color=\"#008800\"><b>Good</b>";
			ratefruits = 2;
		}

		veggieintake = diet.getVeggies() + diet.getLegumes() * 0.5;
		// targetText3.htmlText = "<b>Vegetables</b>";
		if ((veggieintake < 270)) {
			// targetEval3.htmlText = "<font color=\"#FF0000\"><b>Low</b>";
			ratevegs = 1;
		}
		if ((veggieintake >= 270)) {
			// targetEval3.htmlText = "<font color=\"#008800\"><b>Good</b>";
			ratevegs = 2;
		}

		folateintake = diet.getMilk() * 0.05 + diet.getBoxcereal() * 3
				+ diet.getOranges() * 0.3 + diet.getOJ() * 0.3
				+ diet.getTomato() * 0.15 + diet.getDarkgreen() * 0.6
				+ diet.getMelon() * 0.2 + diet.getColdfish() * 0.2 + 180;
		// targetText4.htmlText = "<b>Folate</b>";
		if ((folateintake < nut3dayTarget * 0.8)) {
			// targetEval4.htmlText = "<font color=\"#FF0000\"><b>Low</b>";
			ratefol = 1;
		}
		if ((folateintake >= nut3dayTarget * 0.8) && (folateintake <= nut3UL)) {
			// targetEval4.htmlText = "<font color=\"#008800\"><b>Good</b>";
			ratefol = 2;
		}
		if ((folateintake >= nut3UL)) {
			// targetEval4.htmlText = "<font color=\"#FF0000\"><b>High</b>";
			ratefol = 3;
		}

		vitcintake = diet.getMilk() * 0.0012 + diet.getBoxcereal() * 0.03
				+ diet.getOranges() * 0.5 + diet.getOJ() * 0.5
				+ diet.getTomato() * 0.13 + diet.getDarkgreen() * 0.42
				+ diet.getMelon() * 0.35 + 5;
		// targetText5.htmlText = "<b>Vitamin C</b>";
		if ((vitcintake < nut5dayTarget * 0.8)) {
			// targetEval5.htmlText = "<font color=\"#FF0000\"><b>Low</b>";
			ratevc = 1;
		}
		if ((vitcintake >= nut5dayTarget * 0.8) && (vitcintake <= nut5UL)) {
			// targetEval5.htmlText = "<font color=\"#008800\"><b>Good</b>";
			ratevc = 2;
		}
		if ((vitcintake >= nut5UL)) {
			// targetEval5.htmlText = "<font color=\"#FF0000\"><b>High</b>";
			ratevc = 3;
		}

		betacarintake = diet.getOranges() * 2 + diet.getOJ() * 2
				+ diet.getTomato() * 0.15 + diet.getDarkgreen() * 20
				+ diet.getMelon() * 40 + diet.getLegumes() * 0.11 + 200;
		// targetText6.htmlText = "<b>Beta-Carotene</b>";
		if ((betacarintake < nutedayTarget * 0.8)) {
			// targetEval6.htmlText = "<font color=\"#FF0000\"><b>Low</b>";
			ratebc = 1;
		}
		if ((betacarintake >= nutedayTarget * 0.8)
				&& (betacarintake <= nuteUL * 2)) {
			// targetEval6.htmlText = "<font color=\"#008800\"><b>Good</b>";
			ratebc = 2;
		}
		if ((betacarintake >= nuteUL * 2)) {
			// targetEval6.htmlText = "<font color=\"#FF0000\"><b>High</b>";
			ratebc = 3;
		}

		calciumintake = diet.getMilk() * 1.1 + diet.getDairy() * 1.1
				+ diet.getBoxcereal() * 2 + diet.getCafortifiedjuice() * 1.1
				+ diet.getWholegrain() * 0.6 + diet.getTomato() * 0.1
				+ diet.getDarkgreen() * 0.35 + diet.getLegumes() * 0.35 + 300;
		// targetText7.htmlText = "<b>Calcium</b>";
		if ((calciumintake < nut8dayTarget * 0.8)) {
			// targetEval7.htmlText = "<font color=\"#FF0000\"><b>Low</b>";
			rateca = 1;
		}
		if ((calciumintake >= nut8dayTarget * 0.8) && (calciumintake <= nut7UL)) {
			// targetEval7.htmlText = "<font color=\"#008800\"><b>Good</b>";
			rateca = 2;
		}
		if ((calciumintake >= nut8UL)) {
			// targetEval7.htmlText = "<font color=\"#FF0000\"><b>High</b>";
			rateca = 3;
		}

		vitdintake = diet.getMilk() * 0.4 + diet.getBoxcereal() * 2
				+ diet.getEggs() * 0.35 + diet.getColdfish() * 5 + diet.getUV()
				+ 40;
		// targetText8.htmlText = "<b> </b>";
		if ((vitdintake < 400)) {
			// targetEval8.htmlText = "<font color=\"#FF0000\"><b> </b>";
			// targetEval8.htmlText = "<font color=\"#FF0000\"><b>Low</b>";
			ratevd = 1;
		}
		if ((vitdintake >= 400)) {
			// targetEval8.htmlText = "<font color=\"#008800\"><b> </b>";
			// targetEval8.htmlText = "<font color=\"#008800\"><b>Good</b>";
			ratevd = 2;
		}

	}

	private void setUL(int DRIgrp) {
		switch (DRIgrp) {
		case 5: // 9=13 males
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 149;
			UL[14] = 50;
			UL[16] = 2200;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 90;
			UL[35] = 1000;
			UL[38] = 400;
			UL[39] = 2000;
			UL[40] = 5667;
			UL[41] = 5667;
			UL[42] = 8000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 40;
			break;
		case 6: // 14-18 males
			UL[0] = 7000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 183;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 875;
			UL[25] = 88;
			UL[35] = 1000;
			UL[38] = 400;
			UL[39] = 2000;
			UL[40] = 9333;
			UL[41] = 9333;
			UL[42] = 12000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 7: // 19-30 males
			UL[0] = 8000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 214;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 1000;
			UL[25] = 100;
			UL[35] = 1000;
			UL[38] = 400;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 8: // 31-50 males
			UL[0] = 8000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 214;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 1000;
			UL[25] = 100;
			UL[35] = 1000;
			UL[38] = 1000;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2000;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 9: // 51-70 males
			UL[0] = 8000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 197;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 1000;
			UL[25] = 100;
			UL[35] = 1000;
			UL[38] = 1000;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2000;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 10: // > 70 males
			UL[0] = 8000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 149;
			UL[14] = 185;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 1000;
			UL[25] = 100;
			UL[35] = 1000;
			UL[38] = 1000;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2000;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 11: // 9=13 females
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2200;
			UL[6] = 2300;
			UL[12] = 149;
			UL[14] = 130;
			UL[16] = 2200;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 400;
			UL[39] = 2000;
			UL[40] = 5667;
			UL[41] = 5667;
			UL[42] = 8000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 40;
			break;
		case 12: // 14-18 females
			UL[0] = 7000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 147;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 875;
			UL[25] = 88;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 9333;
			UL[41] = 9333;
			UL[42] = 12000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 13: // 19-30 females
			UL[0] = 7000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 176;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 875;
			UL[25] = 88;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2000;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 14: // 31-50 females
			UL[0] = 7000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 161;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 875;
			UL[25] = 88;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 15: // 51-70 females
			UL[0] = 7000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 149;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 875;
			UL[25] = 88;
			UL[35] = 1000;
			UL[38] = 400;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 16: // > 70 females
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 140;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 400;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 17: // 14-18 pregnant
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 176;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 9333;
			UL[41] = 9333;
			UL[42] = 12000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 18: // 19-30 pregnant
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 175;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 19: // 31-50 pregnant
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 168;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 20: // 14-18 lactating
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 214;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 9333;
			UL[41] = 9333;
			UL[42] = 12000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 21: // 19-30 lactating
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 214;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		case 22: // 31-50 lactating
			UL[0] = 6000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 207;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 750;
			UL[25] = 75;
			UL[35] = 1000;
			UL[38] = 600;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;
		default:
			UL[0] = 8000;
			UL[1] = 200;
			UL[2] = 200;
			UL[5] = 2300;
			UL[6] = 2300;
			UL[12] = 197;
			UL[14] = 50;
			UL[16] = 2300;
			UL[18] = 500;
			UL[24] = 1000;
			UL[25] = 100;
			UL[35] = 1000;
			UL[38] = 1000;
			UL[39] = 2000;
			UL[40] = 10000;
			UL[41] = 10000;
			UL[42] = 15000;
			UL[46] = 2500;
			UL[47] = 600;
			UL[49] = 45;
			break;

		}
	}

	private void setRDA(int DRIgrp) {
		switch (DRIgrp) {
		case 4: // 4-8 children
			RDA[0] = 1662;
			RDA[1] = 75;
			RDA[2] = 75;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 49.9;
			RDA[14] = 18.5;
			RDA[16] = 1200;
			RDA[18] = 300;
			RDA[24] = 229;
			RDA[25] = 23;
			RDA[35] = 200;
			RDA[38] = 200;
			RDA[39] = 25;
			RDA[40] = 1333;
			RDA[41] = 1333;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 130;
			RDA[49] = 10;
			break;
		case 5: // 9=13 males
			RDA[0] = 1987;
			RDA[1] = 75;
			RDA[2] = 75;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 59.6;
			RDA[14] = 22.1;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 273;
			RDA[25] = 27;
			RDA[35] = 300;
			RDA[38] = 300;
			RDA[39] = 45;
			RDA[40] = 2000;
			RDA[41] = 2000;
			RDA[42] = 1750;
			RDA[46] = 1300;
			RDA[47] = 240;
			RDA[49] = 8;
			break;
		case 6: // 14-18 males
			RDA[0] = 2445;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 73.4;
			RDA[14] = 27.2;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 336;
			RDA[25] = 34;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 75;
			RDA[40] = 3000;
			RDA[41] = 3000;
			RDA[42] = 1750;
			RDA[46] = 1300;
			RDA[47] = 410;
			RDA[49] = 11;
			break;
		case 7: // 19-30 males
			RDA[0] = 2445;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 73.4;
			RDA[14] = 27.2;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 336;
			RDA[25] = 34;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 90;
			RDA[40] = 3000;
			RDA[41] = 3000;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 400;
			RDA[49] = 8;
			break;
		case 8: // 31-50 males
			RDA[0] = 2445;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 73.4;
			RDA[14] = 27.2;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 336;
			RDA[25] = 34;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 90;
			RDA[40] = 3000;
			RDA[41] = 3000;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 420;
			RDA[49] = 8;
			break;
		case 9: // 51-70 males
			RDA[0] = 2254;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 67.6;
			RDA[14] = 25.0;
			RDA[16] = 1300;
			RDA[18] = 300;
			RDA[24] = 310;
			RDA[25] = 31;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 90;
			RDA[40] = 3000;
			RDA[41] = 3000;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 420;
			RDA[49] = 8;
			break;
		case 10: // > 70 males
			RDA[0] = 2111;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 63.3;
			RDA[14] = 23.4;
			RDA[16] = 1200;
			RDA[18] = 300;
			RDA[24] = 290;
			RDA[25] = 29;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 90;
			RDA[40] = 3000;
			RDA[41] = 3000;
			RDA[42] = 1750;
			RDA[46] = 1200;
			RDA[47] = 420;
			RDA[49] = 8;
			break;
		case 11: // 9=13 females
			RDA[0] = 1727;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 51.8;
			RDA[14] = 19.2;
			RDA[16] = 1200;
			RDA[18] = 300;
			RDA[24] = 290;
			RDA[25] = 29;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 45;
			RDA[40] = 2000;
			RDA[41] = 2000;
			RDA[42] = 1750;
			RDA[46] = 1300;
			RDA[47] = 240;
			RDA[49] = 8;
			break;
		case 12: // 14-18 females
			RDA[0] = 1960;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 58.8;
			RDA[14] = 21.8;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 270;
			RDA[25] = 27;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 65;
			RDA[40] = 2333;
			RDA[41] = 2333;
			RDA[42] = 1750;
			RDA[46] = 1300;
			RDA[47] = 360;
			RDA[49] = 15;
			break;
		case 13: // 19-30 females
			RDA[0] = 2013;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 60.4;
			RDA[14] = 22.4;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 277;
			RDA[25] = 27;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 75;
			RDA[40] = 2333;
			RDA[41] = 2333;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 310;
			RDA[49] = 18;
			break;
		case 14: // 31-50 females
			RDA[0] = 1839;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 55.2;
			RDA[14] = 20.4;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 253;
			RDA[25] = 25;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 75;
			RDA[40] = 2333;
			RDA[41] = 2333;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 320;
			RDA[49] = 18;
			break;
		case 15: // 51-70 females
			RDA[0] = 1701;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 51.0;
			RDA[14] = 18.9;
			RDA[16] = 1300;
			RDA[18] = 300;
			RDA[24] = 234;
			RDA[25] = 23;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 75;
			RDA[40] = 2333;
			RDA[41] = 2333;
			RDA[42] = 1750;
			RDA[46] = 1200;
			RDA[47] = 320;
			RDA[49] = 8;
			break;
		case 16: // > 70 females
			RDA[0] = 1597;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 47.9;
			RDA[14] = 17.7;
			RDA[16] = 1200;
			RDA[18] = 300;
			RDA[24] = 220;
			RDA[25] = 22;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 75;
			RDA[40] = 2333;
			RDA[41] = 2333;
			RDA[42] = 1750;
			RDA[46] = 1200;
			RDA[47] = 320;
			RDA[49] = 8;
			break;
		case 17: // 14-18 pregnant
			RDA[0] = 2010;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 60.3;
			RDA[14] = 22.3;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 276;
			RDA[25] = 28;
			RDA[35] = 600;
			RDA[38] = 600;
			RDA[39] = 80;
			RDA[40] = 2500;
			RDA[41] = 2500;
			RDA[42] = 1750;
			RDA[46] = 1300;
			RDA[47] = 400;
			RDA[49] = 27;
			break;
		case 18: // 19-30 pregnant
			RDA[0] = 1999;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 60.0;
			RDA[14] = 22.2;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 275;
			RDA[25] = 28;
			RDA[35] = 600;
			RDA[38] = 600;
			RDA[39] = 85;
			RDA[40] = 2567;
			RDA[41] = 2567;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 350;
			RDA[49] = 27;
			break;
		case 19: // 31-50 pregnant
			RDA[0] = 1923;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 57.7;
			RDA[14] = 21.4;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 264;
			RDA[25] = 26;
			RDA[35] = 600;
			RDA[38] = 600;
			RDA[39] = 85;
			RDA[40] = 2567;
			RDA[41] = 2567;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 360;
			RDA[49] = 27;
			break;
		case 20: // 14-18 lactating
			RDA[0] = 2447;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 73.4;
			RDA[14] = 27.2;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 336;
			RDA[25] = 34;
			RDA[35] = 500;
			RDA[38] = 500;
			RDA[39] = 115;
			RDA[40] = 4000;
			RDA[41] = 4000;
			RDA[42] = 1750;
			RDA[46] = 1300;
			RDA[47] = 360;
			RDA[49] = 10;
			break;
		case 21: // 19-30 lactating
			RDA[0] = 2443;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 73.3;
			RDA[14] = 27.1;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 336;
			RDA[25] = 34;
			RDA[35] = 500;
			RDA[38] = 500;
			RDA[39] = 120;
			RDA[40] = 4333;
			RDA[41] = 4333;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 310;
			RDA[49] = 9;
			break;
		case 22: // 31-50 lactating
			RDA[0] = 2367;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 71.0;
			RDA[14] = 26.3;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 325;
			RDA[25] = 33;
			RDA[35] = 500;
			RDA[38] = 500;
			RDA[39] = 120;
			RDA[40] = 4333;
			RDA[41] = 4333;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 320;
			RDA[49] = 9;
			break;
		default:
			RDA[0] = 2254;
			RDA[1] = 100;
			RDA[2] = 100;
			RDA[5] = 600;
			RDA[6] = 600;
			RDA[12] = 67.6;
			RDA[14] = 25.0;
			RDA[16] = 1500;
			RDA[18] = 300;
			RDA[24] = 310;
			RDA[25] = 31;
			RDA[35] = 400;
			RDA[38] = 400;
			RDA[39] = 90;
			RDA[40] = 3000;
			RDA[41] = 3000;
			RDA[42] = 1750;
			RDA[46] = 1000;
			RDA[47] = 420;
			RDA[49] = 18;
			break;
		}

	}

	private void estimateEnergy() {
		ex = 1.3 + ((exercise.getIntexercise() + exercise.getModexercise())/10.0);

		switch (user.getGender()) {
		case 1:
			if (ex < 1.4) {
				pa = 1.0;
			} else if (ex < 1.6) {
				pa = 1.11;
			} else if (ex < 1.9) {
				pa = 1.25;
			} else {
				pa = 1.48;
			}
			rawendayTarget = pa
					* ((15.91 * user.getIndWeight()) + (5.396 * user
							.getIndHeight())) + 661.8
					- (9.53 * user.getPseudoAge());
			noexrawendayTarget = ((15.91 * user.getIndWeight()) + (5.396 * user
					.getIndHeight())) + 661.8 - (9.53 * user.getPseudoAge());
			break;
		case 2:
			if (ex < 1.4) {
				pa = 1.0;
			} else if (ex < 1.6) {
				pa = 1.12;
			} else if (ex < 1.9) {
				pa = 1.27;
			} else {
				pa = 1.45;
			}
			rawendayTarget = pa
					* ((9.36 * user.getIndWeight()) + (7.260 * user
							.getIndHeight())) + 354.0
					- (6.91 * user.getPseudoAge());
			noexrawendayTarget = ((9.36 * user.getIndWeight()) + (7.260 * user
					.getIndHeight())) + 354.0 - (6.91 * user.getPseudoAge());
			break;
		default:
			// best practice. Should never enter
			break;
		}

		RDAfactor = rawendayTarget / RDA[0];
		RDAfactornoex = (noexrawendayTarget / RDA[0]);
		RDAfactor = Math.pow(RDAfactor, 0.75);
		RDAfactornoex = Math.pow(RDAfactor, 0.75);
	}

	private void setGlobalTargets() {
		double enadj = adjust.getEnadj();
		double enreduced = calories.getEnreduced();
		endayTarget = rawendayTarget * enadj * enreduced;
		nut0dayTarget = user.getIndWeight() * 0.8;
		nut1dayTarget = RDA[optInfo.getSel1()] * RDAfactornoex
				* adjust.getNut1adj();
		nut2dayTarget = RDA[optInfo.getSel2()] * RDAfactornoex
				* adjust.getNut2adj();
		nut3dayTarget = RDA[optInfo.getSel3()] * RDAfactornoex
				* adjust.getNut3adj();
		nut4dayTarget = RDA[optInfo.getSel4()] * RDAfactornoex
				* adjust.getNut4adj();
		nut5dayTarget = RDA[optInfo.getSel5()] * RDAfactornoex
				* adjust.getNut5adj();
		nut6dayTarget = RDA[optInfo.getSel6()] * RDAfactornoex
				* adjust.getNut6adj();
		nut7dayTarget = RDA[optInfo.getSel7()] * RDAfactor
				* adjust.getNut7adj();
		nut8dayTarget = RDA[optInfo.getSel8()] * RDAfactornoex
				* adjust.getNut8adj();
		nut9dayTarget = RDA[optInfo.getSel9()] * RDAfactornoex
				* adjust.getNut9adj();
		nutadayTarget = RDA[optInfo.getSela()] * RDAfactornoex
				* adjust.getNutaadj();
		nutbdayTarget = RDA[optInfo.getSelb()] * RDAfactornoex
				* adjust.getNutbadj();
		nutcdayTarget = RDA[optInfo.getSelc()] * RDAfactornoex
				* adjust.getNutcadj();
		nutddayTarget = RDA[optInfo.getSeld()] * RDAfactornoex
				* adjust.getNutdadj();
		nutedayTarget = RDA[optInfo.getSele()] * RDAfactornoex
				* adjust.getNuteadj();

		enUL = UL[0];
		nut0UL = UL[optInfo.getSel0()];
		nut1UL = UL[optInfo.getSel1()];
		nut2UL = UL[optInfo.getSel2()];
		nut3UL = UL[optInfo.getSel3()];
		nut4UL = UL[optInfo.getSel4()];
		nut5UL = UL[optInfo.getSel5()];
		nut6UL = UL[optInfo.getSel6()];
		nut7UL = UL[optInfo.getSel7()];
		nut8UL = UL[optInfo.getSel8()];
		nut9UL = UL[optInfo.getSel9()];
		nutaUL = UL[optInfo.getSela()];
		nutbUL = UL[optInfo.getSelb()];
		nutcUL = UL[optInfo.getSelc()];
		nutdUL = UL[optInfo.getSeld()];
		nuteUL = UL[optInfo.getSele()];
	}

	public int getEnUL() {
		return enUL;
	}

	public void setEnUL(int enUL) {
		this.enUL = enUL;
	}

	public int getNut0UL() {
		return nut0UL;
	}

	public void setNut0UL(int nut0ul) {
		nut0UL = nut0ul;
	}

	public int getNut1UL() {
		return nut1UL;
	}

	public void setNut1UL(int nut1ul) {
		nut1UL = nut1ul;
	}

	public int getNut2UL() {
		return nut2UL;
	}

	public void setNut2UL(int nut2ul) {
		nut2UL = nut2ul;
	}

	public int getNut3UL() {
		return nut3UL;
	}

	public void setNut3UL(int nut3ul) {
		nut3UL = nut3ul;
	}

	public int getNut4UL() {
		return nut4UL;
	}

	public void setNut4UL(int nut4ul) {
		nut4UL = nut4ul;
	}

	public int getNut5UL() {
		return nut5UL;
	}

	public void setNut5UL(int nut5ul) {
		nut5UL = nut5ul;
	}

	public int getNut6UL() {
		return nut6UL;
	}

	public void setNut6UL(int nut6ul) {
		nut6UL = nut6ul;
	}

	public int getNut7UL() {
		return nut7UL;
	}

	public void setNut7UL(int nut7ul) {
		nut7UL = nut7ul;
	}

	public int getNut8UL() {
		return nut8UL;
	}

	public void setNut8UL(int nut8ul) {
		nut8UL = nut8ul;
	}

	public int getNut9UL() {
		return nut9UL;
	}

	public void setNut9UL(int nut9ul) {
		nut9UL = nut9ul;
	}

	public int getNutaUL() {
		return nutaUL;
	}

	public void setNutaUL(int nutaUL) {
		this.nutaUL = nutaUL;
	}

	public int getNutbUL() {
		return nutbUL;
	}

	public void setNutbUL(int nutbUL) {
		this.nutbUL = nutbUL;
	}

	public int getNutcUL() {
		return nutcUL;
	}

	public void setNutcUL(int nutcUL) {
		this.nutcUL = nutcUL;
	}

	public int getNutdUL() {
		return nutdUL;
	}

	public void setNutdUL(int nutdUL) {
		this.nutdUL = nutdUL;
	}

	public int getNuteUL() {
		return nuteUL;
	}

	public void setNuteUL(int nuteUL) {
		this.nuteUL = nuteUL;
	}

	public double getRawendayTarget() {
		return rawendayTarget;
	}

	public void setRawendayTarget(double rawendayTarget) {
		this.rawendayTarget = rawendayTarget;
	}

	public double getNut0dayTarget() {
		return nut0dayTarget;
	}

	public void setNut0dayTarget(double nut0dayTarget) {
		this.nut0dayTarget = nut0dayTarget;
	}

	public double getNut1dayTarget() {
		return nut1dayTarget;
	}

	public void setNut1dayTarget(double nut1dayTarget) {
		this.nut1dayTarget = nut1dayTarget;
	}

	public double getNut2dayTarget() {
		return nut2dayTarget;
	}

	public void setNut2dayTarget(double nut2dayTarget) {
		this.nut2dayTarget = nut2dayTarget;
	}

	public double getNut3dayTarget() {
		return nut3dayTarget;
	}

	public void setNut3dayTarget(double nut3dayTarget) {
		this.nut3dayTarget = nut3dayTarget;
	}

	public double getNut4dayTarget() {
		return nut4dayTarget;
	}

	public void setNut4dayTarget(double nut4dayTarget) {
		this.nut4dayTarget = nut4dayTarget;
	}

	public double getNut5dayTarget() {
		return nut5dayTarget;
	}

	public void setNut5dayTarget(double nut5dayTarget) {
		this.nut5dayTarget = nut5dayTarget;
	}

	public double getNut6dayTarget() {
		return nut6dayTarget;
	}

	public void setNut6dayTarget(double nut6dayTarget) {
		this.nut6dayTarget = nut6dayTarget;
	}

	public double getNut7dayTarget() {
		return nut7dayTarget;
	}

	public void setNut7dayTarget(double nut7dayTarget) {
		this.nut7dayTarget = nut7dayTarget;
	}

	public double getNut8dayTarget() {
		return nut8dayTarget;
	}

	public void setNut8dayTarget(double nut8dayTarget) {
		this.nut8dayTarget = nut8dayTarget;
	}

	public double getNut9dayTarget() {
		return nut9dayTarget;
	}

	public void setNut9dayTarget(double nut9dayTarget) {
		this.nut9dayTarget = nut9dayTarget;
	}

	public double getNutadayTarget() {
		return nutadayTarget;
	}

	public void setNutadayTarget(double nutadayTarget) {
		this.nutadayTarget = nutadayTarget;
	}

	public double getNutbdayTarget() {
		return nutbdayTarget;
	}

	public void setNutbdayTarget(double nutbdayTarget) {
		this.nutbdayTarget = nutbdayTarget;
	}

	public double getNutcdayTarget() {
		return nutcdayTarget;
	}

	public void setNutcdayTarget(double nutcdayTarget) {
		this.nutcdayTarget = nutcdayTarget;
	}

	public double getNutddayTarget() {
		return nutddayTarget;
	}

	public void setNutddayTarget(double nutddayTarget) {
		this.nutddayTarget = nutddayTarget;
	}

	public double getNutedayTarget() {
		return nutedayTarget;
	}

	public void setNutedayTarget(double nutedayTarget) {
		this.nutedayTarget = nutedayTarget;
	}

	public int getRatefruits() {
		return ratefruits;
	}

	public void setRatefruits(int ratefruits) {
		this.ratefruits = ratefruits;
	}

	public int getRatevegs() {
		return ratevegs;
	}

	public void setRatevegs(int ratevegs) {
		this.ratevegs = ratevegs;
	}

	public int getRatemeat() {
		return ratemeat;
	}

	public void setRatemeat(int ratemeat) {
		this.ratemeat = ratemeat;
	}

	public int getRatefol() {
		return ratefol;
	}

	public void setRatefol(int ratefol) {
		this.ratefol = ratefol;
	}

	public int getRatevc() {
		return ratevc;
	}

	public void setRatevc(int ratevc) {
		this.ratevc = ratevc;
	}

	public int getRatebc() {
		return ratebc;
	}

	public void setRatebc(int ratebc) {
		this.ratebc = ratebc;
	}

	public int getRateca() {
		return rateca;
	}

	public void setRateca(int rateca) {
		this.rateca = rateca;
	}

	public int getRatevd() {
		return ratevd;
	}

	public void setRatevd(int ratevd) {
		this.ratevd = ratevd;
	}

	public int getAsstype() {
		return asstype;
	}

	public void setAsstype(int asstype) {
		this.asstype = asstype;
	}

	 

	@Override
	public String toString() {
		return "Adequacy [ratefruits=" + ratefruits + ", ratevegs=" + ratevegs
				+ ", ratemeat=" + ratemeat + ", ratefol=" + ratefol
				+ ", ratevc=" + ratevc + ", ratebc=" + ratebc + ", rateca="
				+ rateca + ", ratevd=" + ratevd + ", asstype=" + asstype
				+ ", enUL=" + enUL + ", nut0UL=" + nut0UL + ", nut1UL="
				+ nut1UL + ", nut2UL=" + nut2UL + ", nut3UL=" + nut3UL
				+ ", nut4UL=" + nut4UL + ", nut5UL=" + nut5UL + ", nut6UL="
				+ nut6UL + ", nut7UL=" + nut7UL + ", nut8UL=" + nut8UL
				+ ", nut9UL=" + nut9UL + ", nutaUL=" + nutaUL + ", nutbUL="
				+ nutbUL + ", nutcUL=" + nutcUL + ", nutdUL=" + nutdUL
				+ ", nuteUL=" + nuteUL + ", rawendayTarget=" + rawendayTarget
				+ ", endayTarget=" + endayTarget + ", nut0dayTarget="
				+ nut0dayTarget + ", nut1dayTarget=" + nut1dayTarget
				+ ", nut2dayTarget=" + nut2dayTarget + ", nut3dayTarget="
				+ nut3dayTarget + ", nut4dayTarget=" + nut4dayTarget
				+ ", nut5dayTarget=" + nut5dayTarget + ", nut6dayTarget="
				+ nut6dayTarget + ", nut7dayTarget=" + nut7dayTarget
				+ ", nut8dayTarget=" + nut8dayTarget + ", nut9dayTarget="
				+ nut9dayTarget + ", nutadayTarget=" + nutadayTarget
				+ ", nutbdayTarget=" + nutbdayTarget + ", nutcdayTarget="
				+ nutcdayTarget + ", nutddayTarget=" + nutddayTarget
				+ ", nutedayTarget=" + nutedayTarget + ", enTarget=" + enTarget
				+ ", nut0Target=" + nut0Target + ", nut1Target=" + nut1Target
				+ ", nut2Target=" + nut2Target + ", nut3Target=" + nut3Target
				+ ", nut4Target=" + nut4Target + ", nut5Target=" + nut5Target
				+ ", nut6Target=" + nut6Target + ", nut7Target=" + nut7Target
				+ ", nut8Target=" + nut8Target + ", nut9Target=" + nut9Target
				+ ", nutaTarget=" + nutaTarget + ", nutbTarget=" + nutbTarget
				+ ", nutcTarget=" + nutcTarget + ", nutdTarget=" + nutdTarget
				+ ", nuteTarget=" + nuteTarget + ", UL=" + Arrays.toString(UL)
				+ ", RDA=" + Arrays.toString(RDA) + ", noexrawendayTarget="
				+ noexrawendayTarget + ", ex=" + ex + ", pa=" + pa
				+ ", RDAfactor=" + RDAfactor + ", RDAfactornoex="
				+ RDAfactornoex + ", dietapprox=" + dietapprox + "]";
	}

	public double getEndayTarget() {
		return endayTarget;
	}

	public void setEndayTarget(double endayTarget) {
		this.endayTarget = endayTarget;
	}

	public double getEnTarget() {
		return enTarget;
	}

	public void setEnTarget(double enTarget) {
		this.enTarget = enTarget;
	}

	public double getNut0Target() {
		return nut0Target;
	}

	public void setNut0Target(double nut0Target) {
		this.nut0Target = nut0Target;
	}

	public double getNut1Target() {
		return nut1Target;
	}

	public void setNut1Target(double nut1Target) {
		this.nut1Target = nut1Target;
	}

	public double getNut2Target() {
		return nut2Target;
	}

	public void setNut2Target(double nut2Target) {
		this.nut2Target = nut2Target;
	}

	public double getNut3Target() {
		return nut3Target;
	}

	public void setNut3Target(double nut3Target) {
		this.nut3Target = nut3Target;
	}

	public double getNut4Target() {
		return nut4Target;
	}

	public void setNut4Target(double nut4Target) {
		this.nut4Target = nut4Target;
	}

	public double getNut5Target() {
		return nut5Target;
	}

	public void setNut5Target(double nut5Target) {
		this.nut5Target = nut5Target;
	}

	public double getNut6Target() {
		return nut6Target;
	}

	public void setNut6Target(double nut6Target) {
		this.nut6Target = nut6Target;
	}

	public double getNut7Target() {
		return nut7Target;
	}

	public void setNut7Target(double nut7Target) {
		this.nut7Target = nut7Target;
	}

	public double getNut8Target() {
		return nut8Target;
	}

	public void setNut8Target(double nut8Target) {
		this.nut8Target = nut8Target;
	}

	public double getNut9Target() {
		return nut9Target;
	}

	public void setNut9Target(double nut9Target) {
		this.nut9Target = nut9Target;
	}

	public double getNutaTarget() {
		return nutaTarget;
	}

	public void setNutaTarget(double nutaTarget) {
		this.nutaTarget = nutaTarget;
	}

	public double getNutbTarget() {
		return nutbTarget;
	}

	public void setNutbTarget(double nutbTarget) {
		this.nutbTarget = nutbTarget;
	}

	public double getNutcTarget() {
		return nutcTarget;
	}

	public void setNutcTarget(double nutcTarget) {
		this.nutcTarget = nutcTarget;
	}

	public double getNutdTarget() {
		return nutdTarget;
	}

	public void setNutdTarget(double nutdTarget) {
		this.nutdTarget = nutdTarget;
	}

	public double getNuteTarget() {
		return nuteTarget;
	}

	public void setNuteTarget(double nuteTarget) {
		this.nuteTarget = nuteTarget;
	}

}
