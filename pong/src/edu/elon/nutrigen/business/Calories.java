package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.util.Arrays;

public class Calories implements Serializable {
	private String [] caloriemod;
	private double [] calorieadj;
	private String enmodified;
	private double enreduced;
	
	public Calories() {
		enreduced = 1;
		caloriemod = new String[16];
		caloriemod[0] = "";
		caloriemod[1] = "120% ";
		caloriemod[2] = "115% ";
		caloriemod[3] = "110% ";
		caloriemod[4] = "105% ";
		caloriemod[5] = "";
		caloriemod[6] = "95% ";
		caloriemod[7] = "90% ";
		caloriemod[8] = "85% ";
		caloriemod[9] = "80% ";
		caloriemod[10] = "75% ";
		caloriemod[11] = "70% ";
		caloriemod[12] = "65% ";
		caloriemod[13] = "60% ";
		caloriemod[14] = "55% ";
		caloriemod[15] = "50% ";
		
		calorieadj = new double[16];
		calorieadj[0] = 1;
		calorieadj[1] = 1.2;
		calorieadj[2] = 1.15;
		calorieadj[3] = 1.1;
		calorieadj[4] = 1.05;
		calorieadj[5] = 1;
		calorieadj[6] = 0.95;
		calorieadj[7] = 0.90;
		calorieadj[8] = 0.85;
		calorieadj[9] = 0.80;
		calorieadj[10] = 0.75;
		calorieadj[11] = 0.70;
		calorieadj[12] = 0.65;
		calorieadj[13] = 0.60;
		calorieadj[14] = 0.55;
		calorieadj[15] = 0.50;
	}

	public void additionalProcessing(int calIndex) {
		enmodified = caloriemod[calIndex];
		enreduced = calorieadj[calIndex];
	}

	public String[] getCaloriemod() {
		return caloriemod;
	}

	public void setCaloriemod(String[] caloriemod) {
		this.caloriemod = caloriemod;
	}

	public double[] getCalorieadj() {
		return calorieadj;
	}

	public void setCalorieadj(double[] calorieadj) {
		this.calorieadj = calorieadj;
	}

	public String getEnmodified() {
		return enmodified;
	}

	public void setEnmodified(String enmodified) {
		this.enmodified = enmodified;
	}

	public double getEnreduced() {
		return enreduced;
	}

	public void setEnreduced(double enreduced) {
		this.enreduced = enreduced;
	}

	@Override
	public String toString() {
		return "Calories [caloriemod=" + Arrays.toString(caloriemod)
				+ ", calorieadj=" + Arrays.toString(calorieadj)
				+ ", enmodified=" + enmodified + ", enreduced=" + enreduced
				+ "]";
	}

}
