package edu.elon.nutrigen.facade;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Holds a Meal item with descriptive information to include a URL if one
 * is specified for the food item
 * 
 * @author dpowell
 * @author gsmith
 */
public class MealItem implements Serializable {
	
	private ArrayList<NutritionalItem> itemInfo;
	private String item;
	private int itemNumber;
	private String url;
	
	public MealItem(String item){
		this.item = item;
		itemInfo = new ArrayList<NutritionalItem>();
	}
	
	public MealItem(String item, int itemNumber) {
		super();
		this.item = item;
		this.itemNumber = itemNumber;
	}
	
	public MealItem(String item, int itemNumber, String url) {
		super();
		this.item = item;
		this.itemNumber = itemNumber;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public ArrayList<NutritionalItem> getItemInfo() {
		return itemInfo;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String aItem){
		item = aItem;
	}
	
	/**
	 * The item information on each item can be expensive to compute. The intent is to only compute the
	 * meal nutritional information when explicitly asked for it.
	 * 
	 * @param items
	 */
	public void setItemInfo(ArrayList<NutritionalItem> items){
		itemInfo = items;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	@Override
	public String toString() {
		return "MealItem [itemInfo=" + itemInfo + ", item=" + item
				+ ", itemNumber=" + itemNumber + ", url=" + url + "]";
	}

}
