package edu.elon.nutrigen.facade;

import java.io.Serializable;

public class NutritionalItem implements Serializable {

	private String label;
	private double value;
	private String formattedValue;
	private String units;
	private double targetValue;
	private String bound;
	
	public NutritionalItem() {
		//intentionally empty - created to conform to bean specification
	}

	public NutritionalItem(String label, double value, String units) {
		this.label = label;
		this.value = value;
		this.units = units;
		this.bound = "=";
	}
	
	public NutritionalItem(String label, double value, String units,
			double targetValue, String bound) {
		super();
		this.label = label;
		this.value = value;
		this.units = units;
		this.targetValue = targetValue;
		this.bound = bound;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public double getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(double targetValue) {
		this.targetValue = targetValue;
	}

	public String getBound() {
		return bound;
	}

	public void setBound(String bound) {
		this.bound = bound;
	}

	@Override
	public String toString() {
		return "NutritionalItem [label=" + label + ", value=" + value
				+ ", units=" + units + ", targetValue=" + targetValue
				+ ", bound=" + bound + "]";
	}

	public String getFormattedValue() {
		formattedValue = String.format("%,.1f", getValue());
		return formattedValue;
	}

	public void setFormattedValue(String formattedValue) {
		this.formattedValue = formattedValue;
	}

	

}
