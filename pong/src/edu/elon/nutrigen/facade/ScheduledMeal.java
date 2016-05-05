package edu.elon.nutrigen.facade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class ScheduledMeal  implements Serializable {

	private boolean exists;
	private int rating;
	private Date date;
	private int mealNumber;
	private int referenceDay;
	private String icon;
	private double dlt;

	public double getDlt() {
		return dlt;
	}

	public void setDlt(double dlt) {
		this.dlt = dlt;
	}

	public ScheduledMeal() {

	}

	public ScheduledMeal(boolean exists, int rating, Date date, int mealNumber,
			int referenceDay, String icon, int dayOfMonth) {
		super();
		this.exists = exists;
		this.rating = rating;
		this.date = date;
		this.mealNumber = mealNumber;
		this.referenceDay = referenceDay;
		this.icon = icon;
	}


	public int getReferenceDay() {
		return referenceDay;
	}

	public void setReferenceDay(int referenceDay) {
		this.referenceDay = referenceDay;
	}

	@Override
	public String toString() {
		return "ScheduledMeal [exists=" + exists + ", rating=" + rating + ", dlt=" + dlt
				+ ", date=" + date + ", mealNumber=" + mealNumber + "]";
	}

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMealNumber() {
		return mealNumber;
	}

	public void setMealNumber(int mealNumber) {
		this.mealNumber = mealNumber;
	}
	
	public void setIcon(String aIcon){
		icon = aIcon;
	}
	


	public String getIcon(){
		if(exists){
			if(dlt < 35){
				return "glyphicon glyphicon-apple glyph-green";
			}
			if(dlt >= 35 && dlt < 75){
				return "glyphicon glyphicon-apple glyph-yellow";
			}
			if(dlt > 75){
				return "glyphicon glyphicon-apple glyph-red";
			}
		}else{
			return "glyphicon glyphicon-plus-sign";
		}
		return "glyphicon glyphicon-flash";
	}

}
