package edu.elon.nutrigen.business;

import java.io.Serializable;

public class State implements Serializable {
	private boolean updatepersonal;
	private boolean exupdateComplete;
	private boolean initialfill;
	private String replaceitemtext;
	private boolean afterloginVisible = true;
	private String currentState = "startpage";
	private int currentTab = 0;
	private int currentitemRow = 0;
	
	public State() {
		updatepersonal = false;
		exupdateComplete = true;
		initialfill = false;
	}

	public boolean isUpdatepersonal() {
		return updatepersonal;
	}

	public void setUpdatepersonal(boolean updatepersonal) {
		this.updatepersonal = updatepersonal;
	}

	public boolean isExupdateComplete() {
		return exupdateComplete;
	}

	public void setExupdateComplete(boolean exupdateComplete) {
		this.exupdateComplete = exupdateComplete;
	}

	public boolean isInitialfill() {
		return initialfill;
	}

	public void setInitialfill(boolean initialfill) {
		this.initialfill = initialfill;
	}

	public String getReplaceitemtext() {
		return replaceitemtext;
	}

	public void setReplaceitemtext(String replaceitemtext) {
		this.replaceitemtext = replaceitemtext;
	}

	public boolean isAfterloginVisible() {
		return afterloginVisible;
	}

	public void setAfterloginVisible(boolean afterloginVisible) {
		this.afterloginVisible = afterloginVisible;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public int getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(int currentTab) {
		this.currentTab = currentTab;
	}

	public int getCurrentitemRow() {
		return currentitemRow;
	}

	public void setCurrentitemRow(int currentitemRow) {
		this.currentitemRow = currentitemRow;
	}

}
