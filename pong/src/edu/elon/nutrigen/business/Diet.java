package edu.elon.nutrigen.business;

import java.io.Serializable;

/**
 * Class interfaces with testintake table in nutrigen db
 * 
 * @author dpowell2
 */
public class Diet implements Serializable {
	private String intakelastupdatedDisp;;

	private int milk;;
	private int dairy;
	private int wholegrain;
	private int boxcereal;
	private int melon;
	private int oranges;
	private int fruits;
	private int OJ;
	private int cafortifiedjuice;
	private int tomato;
	private int darkgreen;
	private int veggies;
	private int legumes;
	private int redmeat;
	private int poultry;
	private int eggs;
	private int coldfish;
	private int UV;;
	
	public Diet() {
		//intentionally empty
	}

	public String getIntakelastupdatedDisp() {
		return intakelastupdatedDisp;
	}

	public void setIntakelastupdatedDisp(String intakelastupdatedDisp) {
		this.intakelastupdatedDisp = intakelastupdatedDisp;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getDairy() {
		return dairy;
	}

	public void setDairy(int dairy) {
		this.dairy = dairy;
	}

	public int getWholegrain() {
		return wholegrain;
	}

	public void setWholegrain(int wholegrain) {
		this.wholegrain = wholegrain;
	}

	public int getBoxcereal() {
		return boxcereal;
	}

	public void setBoxcereal(int boxcereal) {
		this.boxcereal = boxcereal;
	}

	public int getMelon() {
		return melon;
	}

	public void setMelon(int melon) {
		this.melon = melon;
	}

	public int getOranges() {
		return oranges;
	}

	public void setOranges(int oranges) {
		this.oranges = oranges;
	}

	public int getFruits() {
		return fruits;
	}

	public void setFruits(int fruits) {
		this.fruits = fruits;
	}

	public int getOJ() {
		return OJ;
	}

	public void setOJ(int oJ) {
		OJ = oJ;
	}

	public int getCafortifiedjuice() {
		return cafortifiedjuice;
	}

	public void setCafortifiedjuice(int cafortifiedjuice) {
		this.cafortifiedjuice = cafortifiedjuice;
	}

	public int getTomato() {
		return tomato;
	}

	public void setTomato(int tomato) {
		this.tomato = tomato;
	}

	public int getDarkgreen() {
		return darkgreen;
	}

	public void setDarkgreen(int darkgreen) {
		this.darkgreen = darkgreen;
	}

	public int getVeggies() {
		return veggies;
	}

	public void setVeggies(int veggies) {
		this.veggies = veggies;
	}

	public int getLegumes() {
		return legumes;
	}

	public void setLegumes(int legumes) {
		this.legumes = legumes;
	}

	public int getRedmeat() {
		return redmeat;
	}

	public void setRedmeat(int redmeat) {
		this.redmeat = redmeat;
	}

	public int getPoultry() {
		return poultry;
	}

	public void setPoultry(int poultry) {
		this.poultry = poultry;
	}

	public int getEggs() {
		return eggs;
	}

	public void setEggs(int eggs) {
		this.eggs = eggs;
	}

	public int getColdfish() {
		return coldfish;
	}

	public void setColdfish(int coldfish) {
		this.coldfish = coldfish;
	}

	public int getUV() {
		return UV;
	}

	public void setUV(int uV) {
		UV = uV;
	}

	@Override
	public String toString() {
		return "Diet [intakelastupdatedDisp=" + intakelastupdatedDisp
				+ ", milk=" + milk + ", dairy=" + dairy + ", wholegrain="
				+ wholegrain + ", boxcereal=" + boxcereal + ", melon=" + melon
				+ ", oranges=" + oranges + ", fruits=" + fruits + ", OJ=" + OJ
				+ ", cafortifiedjuice=" + cafortifiedjuice + ", tomato="
				+ tomato + ", darkgreen=" + darkgreen + ", veggies=" + veggies
				+ ", legumes=" + legumes + ", redmeat=" + redmeat
				+ ", poultry=" + poultry + ", eggs=" + eggs + ", coldfish="
				+ coldfish + ", UV=" + UV + "]";
	}

}
