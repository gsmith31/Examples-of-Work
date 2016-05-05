package edu.elon.nutrigen.business;

import java.io.Serializable;

public class User implements Serializable {
	private String indId;
	private String indPw;
	private String indPhysPw;
	private int allo;
	private int indHeight;
	private double indWeight;
	private int gender;
	private int pregnant;
	private int lactating;
	private int age;
	private int inState;
	private int indNum;
	private int preference;
	private int smoker;
	private int diabetes;
	private int celiac;
	private int lactintolerance;
	// variables not in database but calculated after data read in from db
	private int DRIgrp;
	private int pseudoAge;
	private int exclude;
	private int kosher;

	public User() {
		// intentionally empty
	}

	public User(String indId, String indPw, String indPhysPw, int allo,
			int height, double weight, int indGen, int preg, int lact,
			int inAge, int inState, int idNum, int inPref, int smoker,
			int diabetes, int celiac, int lactint) {
		super();
		this.indId = indId;
		this.indPw = indPw;
		this.indPhysPw = indPhysPw;
		this.allo = allo;
		this.indHeight = height;
		this.indWeight = weight;
		this.gender = indGen;
		this.pregnant = preg;
		this.lactating = lact;
		this.age = inAge;
		this.inState = inState;
		this.indNum = idNum;
		this.preference = inPref;
		this.smoker = smoker;
		this.diabetes = diabetes;
		this.celiac = celiac;
		this.lactintolerance = lactint;
	}

	public String getIndId() {
		return indId;
	}

	public void setIndId(String indId) {
		this.indId = indId;
	}

	public String getIndPw() {
		return indPw;
	}

	public void setIndPw(String indPw) {
		this.indPw = indPw;
	}

	public String getIndPhysPw() {
		return indPhysPw;
	}

	public void setIndPhysPw(String indPhysPw) {
		this.indPhysPw = indPhysPw;
	}

	public int getAllo() {
		return allo;
	}

	public void setAllo(int allo) {
		this.allo = allo;
	}

	public int getIndHeight() {
		return indHeight;
	}

	public void setIndHeight(int height) {
		this.indHeight = height;
	}

	public double getIndWeight() {
		return indWeight;
	}

	public void setIndWeight(double weight) {
		this.indWeight = weight;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int indGen) {
		this.gender = indGen;
	}

	public int getPregnant() {
		return pregnant;
	}

	public void setPregnant(int preg) {
		this.pregnant = preg;
	}

	public int getLactating() {
		return lactating;
	}

	public void setLactating(int lact) {
		this.lactating = lact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int inAge) {
		this.age = inAge;
	}

	public int getInState() {
		return inState;
	}

	public void setInState(int inState) {
		this.inState = inState;
	}

	public int getIndNum() {
		return indNum;
	}

	public void setIndNum(int idNum) {
		this.indNum = idNum;
	}

	public int getPreference() {
		return preference;
	}

	public void setPreference(int inPref) {
		this.preference = inPref;
	}

	public int getSmoker() {
		return smoker;
	}

	public void setSmoker(int smoker) {
		this.smoker = smoker;
	}

	public int getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(int diabetes) {
		this.diabetes = diabetes;
	}

	public int getCeliac() {
		return celiac;
	}

	public void setCeliac(int celiac) {
		this.celiac = celiac;
	}

	public int getLactintolerance() {
		return lactintolerance;
	}

	public void setLactint(int lactint) {
		this.lactintolerance = lactint;
	}

	public void calculateDRIgrp() {
		if ((preference == 1) || (preference == 3)) {
			exclude = 1;
		}
		if ((preference == 2) || (preference == 4)) {
			kosher = 1;
		}
		switch (age) {
		case 6:
			pseudoAge = 12;
			if (gender == 1) {
				DRIgrp = 5;
			} else if (gender == 2) {
				DRIgrp = 11;
			}
			break;
		case 7:
			pseudoAge = 16;
			if (gender == 1) {
				DRIgrp = 6;
			} else if (gender == 2) {
				DRIgrp = 12;
				if (pregnant == 1) {
					DRIgrp = 17;
				}
				if (lactating == 1) {
					DRIgrp = 20;
				}
			}
			break;
		case 8:
			pseudoAge = 25;
			if (gender == 1) {
				DRIgrp = 7;
			} else if (gender == 2) {
				DRIgrp = 13;
				if (pregnant == 1) {
					DRIgrp = 18;
				}
				if (lactating == 1) {
					DRIgrp = 21;
				}
			}
			break;
		case 9:
			pseudoAge = 40;
			if (gender == 1) {
				DRIgrp = 8;
			} else if (gender == 2) {
				DRIgrp = 14;
				if (pregnant == 1) {
					DRIgrp = 19;
				}
				if (lactating == 1) {
					DRIgrp = 22;
				}
			}
			break;
		case 10:
			pseudoAge = 60;
			if (gender == 1) {
				DRIgrp = 9;
			} else if (gender == 2) {
				DRIgrp = 15;
			}
			break;
		case 11:
			pseudoAge = 76;
			if (gender == 1) {
				DRIgrp = 10;
			} else if (gender == 2) {
				DRIgrp = 16;
			}
			break;
		default:
			// placed as a best practie
			break;

		}
	}

	public int getDRIgrp() {
		return DRIgrp;
	}

	public void setDRIgrp(int dRIgrp) {
		DRIgrp = dRIgrp;
	}

	public int getPseudoAge() {
		return pseudoAge;
	}

	public void setPseudoAge(int pseudoAge) {
		this.pseudoAge = pseudoAge;
	}

	@Override
	public String toString() {
		return "User [indId=" + indId + ", indPw=" + indPw + ", indPhysPw="
				+ indPhysPw + ", allo=" + allo + ", indHeight=" + indHeight
				+ ", indWeight=" + indWeight + ", gender=" + gender
				+ ", pregnant=" + pregnant + ", lactating=" + lactating
				+ ", age=" + age + ", inState=" + inState + ", indNum="
				+ indNum + ", preference=" + preference + ", smoker=" + smoker
				+ ", diabetes=" + diabetes + ", celiac=" + celiac
				+ ", lactintolerance=" + lactintolerance + ", DRIgrp=" + DRIgrp
				+ ", pseudoAge=" + pseudoAge + ", exclude=" + exclude
				+ ", kosher=" + kosher + "]";
	}

	public int getExclude() {
		return exclude;
	}

	public void setExclude(int exclude) {
		this.exclude = exclude;
	}

	public int getKosher() {
		return kosher;
	}

	public void setKosher(int kosher) {
		this.kosher = kosher;
	}

	public void setLactintolerance(int lactintolerance) {
		this.lactintolerance = lactintolerance;
	}

}
