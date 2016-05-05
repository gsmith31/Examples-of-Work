package edu.elon.nutrigen.business;

import java.io.Serializable;

public class MealComboCompare extends MealComboLabel implements Comparable, Serializable {
	private int rating;
	private int nr;
	private double en;
	private double nut0;
	private double nut1;
	private double nut2;
	private double nut3;
	private double nut4;
	private double nut5;
	private double nut6;
	private double nut7;
	private double nut8;
	private double nut9;
	private double nuta;
	private double nutb;
	private double nutc;
	private double nutd;
	private double nute;
	
	private double dlt;  //field that sort is done on
	private String val;
	private double dltmax;
	private boolean typefits;
	
	public MealComboCompare() {
		//intentionally empty
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public double getEn() {
		return en;
	}

	public void setEn(double en) {
		this.en = en;
	}

	public double getNut0() {
		return nut0;
	}

	public void setNut0(double nut0) {
		this.nut0 = nut0;
	}

	public double getNut1() {
		return nut1;
	}

	public void setNut1(double nut1) {
		this.nut1 = nut1;
	}

	public double getNut2() {
		return nut2;
	}

	public void setNut2(double nut2) {
		this.nut2 = nut2;
	}

	public double getNut3() {
		return nut3;
	}

	public void setNut3(double nut3) {
		this.nut3 = nut3;
	}

	public double getNut4() {
		return nut4;
	}

	public void setNut4(double nut4) {
		this.nut4 = nut4;
	}

	public double getNut5() {
		return nut5;
	}

	public void setNut5(double nut5) {
		this.nut5 = nut5;
	}

	public double getNut6() {
		return nut6;
	}

	public void setNut6(double nut6) {
		this.nut6 = nut6;
	}

	public double getNut7() {
		return nut7;
	}

	public void setNut7(double nut7) {
		this.nut7 = nut7;
	}

	public double getNut8() {
		return nut8;
	}

	public void setNut8(double nut8) {
		this.nut8 = nut8;
	}

	public double getNut9() {
		return nut9;
	}

	public void setNut9(double nut9) {
		this.nut9 = nut9;
	}

	public double getNuta() {
		return nuta;
	}

	public void setNuta(double nuta) {
		this.nuta = nuta;
	}

	public double getNutb() {
		return nutb;
	}

	public void setNutb(double nutb) {
		this.nutb = nutb;
	}

	public double getNutc() {
		return nutc;
	}

	public void setNutc(double nutc) {
		this.nutc = nutc;
	}

	public double getNutd() {
		return nutd;
	}

	public void setNutd(double nutd) {
		this.nutd = nutd;
	}

	public double getNute() {
		return nute;
	}

	public void setNute(double nute) {
		this.nute = nute;
	}

	public double getDlt() {
		return dlt;
	}

	public void setDlt(double dlt) {
		this.dlt = dlt;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public double getDltmax() {
		return dltmax;
	}

	public void setDltmax(double dltmax) {
		this.dltmax = dltmax;
	}

	public boolean isTypefits() {
		return typefits;
	}

	public void setTypefits(boolean typefits) {
		this.typefits = typefits;
	}

	@Override
	public String toString() {
		return "MealComboCompare [rating=" + rating + ", nr=" + nr + ", en="
				+ en + ", nut0=" + nut0 + ", nut1=" + nut1 + ", nut2=" + nut2
				+ ", nut3=" + nut3 + ", nut4=" + nut4 + ", nut5=" + nut5
				+ ", nut6=" + nut6 + ", nut7=" + nut7 + ", nut8=" + nut8
				+ ", nut9=" + nut9 + ", nuta=" + nuta + ", nutb=" + nutb
				+ ", nutc=" + nutc + ", nutd=" + nutd + ", nute=" + nute
				+ ", dlt=" + dlt + ", val=" + val + ", dltmax=" + dltmax
				+ ", typefits=" + typefits + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int compareTo(Object obj) {
		MealComboCompare comboObject = (MealComboCompare) obj;
		Double thisDlt = dlt;
		Double objDlt = comboObject.dlt;
		// TODO Auto-generated method stub
		return thisDlt.compareTo(objDlt);
	}
	
	
	

}
