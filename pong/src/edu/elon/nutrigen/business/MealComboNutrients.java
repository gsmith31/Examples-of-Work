package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class is modeled after DB testmalcombo
 * 
 * @author dpowell2
 *
 */
public class MealComboNutrients extends MealCombo implements Serializable  {
	 
	private String FC;
	private Timestamp newcomboTime;
	private String sysnr = "";
	private int tEnergy;
	private int tSodium;
	private int tPotassium;
	private int tFreefol;
	private double tFiber;
	private int tPork;
	private int tKosher;
	private double tLactose;
	private int tOvolacto;
	private int tVegan;
	private int tGluten;
	private int rating;
	
	public MealComboNutrients() {
		//intentionally empty
	}

	 
	public String getFC() {
		return FC;
	}

	public void setFC(String fC) {
		FC = fC;
	}

	public Timestamp getNewcomboTime() {
		return newcomboTime;
	}

	public void setNewcomboTime(Timestamp newcomboTime) {
		this.newcomboTime = newcomboTime;
	}

	 

	public String getSysnr() {
		return sysnr;
	}

	public void setSysnr(String sysnr) {
		this.sysnr = sysnr;
	}

	public int gettEnergy() {
		return tEnergy;
	}

	public void settEnergy(int tEnergy) {
		this.tEnergy = tEnergy;
	}

	public int gettSodium() {
		return tSodium;
	}

	public void settSodium(int tSodium) {
		this.tSodium = tSodium;
	}

	public int gettPotassium() {
		return tPotassium;
	}

	public void settPotassium(int tPotassium) {
		this.tPotassium = tPotassium;
	}

	public int gettFreefol() {
		return tFreefol;
	}

	public void settFreefol(int tFreefol) {
		this.tFreefol = tFreefol;
	}

	public double gettFiber() {
		return tFiber;
	}

	public void settFiber(double tFiber) {
		this.tFiber = tFiber;
	}

	public int gettPork() {
		return tPork;
	}

	public void settPork(int tPork) {
		this.tPork = tPork;
	}

	public int gettKosher() {
		return tKosher;
	}

	public void settKosher(int tKosher) {
		this.tKosher = tKosher;
	}

	public double gettLactose() {
		return tLactose;
	}

	public void settLactose(double tLactose) {
		this.tLactose = tLactose;
	}

	public int gettOvolacto() {
		return tOvolacto;
	}

	public void settOvolacto(int tOvolacto) {
		this.tOvolacto = tOvolacto;
	}

	public int gettVegan() {
		return tVegan;
	}

	public void settVegan(int tVegan) {
		this.tVegan = tVegan;
	}

	public int gettGluten() {
		return tGluten;
	}

	public void settGluten(int tGluten) {
		this.tGluten = tGluten;
	}

  

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "MealComboNutrients [FC=" + FC + ", newcomboTime="
				+ newcomboTime + ", sysnr=" + sysnr + ", tEnergy=" + tEnergy
				+ ", tSodium=" + tSodium + ", tPotassium=" + tPotassium
				+ ", tFreefol=" + tFreefol + ", tFiber=" + tFiber + ", tPork="
				+ tPork + ", tKosher=" + tKosher + ", tLactose=" + tLactose
				+ ", tOvolacto=" + tOvolacto + ", tVegan=" + tVegan
				+ ", tGluten=" + tGluten + ", rating=" + rating
				+ ", toString()=" + super.toString() + "]";
	}


 
	

}
