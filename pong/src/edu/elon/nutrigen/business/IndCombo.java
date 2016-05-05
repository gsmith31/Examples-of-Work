package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class IndCombo implements Serializable {
	
	public class TempPref {
		private int nrFC;
		private int comboRating;
		public TempPref(int nrFC, int comborating) {
			this.nrFC = nrFC;
			this.comboRating = comborating;
		}
		public int getNrFC() {
			return nrFC;
		}
		public int getComborating() {
			return comboRating;
		}
	}
	
	int [] prefArray;
	ArrayList<TempPref> preferences;
	
	public IndCombo() {
		//intentionally empty
		preferences = new ArrayList<TempPref>();
	}

	public int[] getPrefArray() {
		return prefArray;
	}

	public void setPrefArray(int[] prefArray) {
		this.prefArray = prefArray;
	}
	
	public void addPreference(int nrFC, int comborating) {
		preferences.add(new TempPref(nrFC, comborating));
	}
	
	private int getMaxNrFC() {
		int max = 0;
		for (TempPref pref: preferences) {
			if (pref.getNrFC() > max) {
				max = pref.getNrFC();
			}
		}
		return max;
	}

	/**
	 * Need to find out max nrFC to allocate array of Preferences that are indexed by nrFC.
	 * After allocation, fill array indexes based on nrFC and comboRating.
	 */
	public void additionalProcessing() {
		//allocate Array of proper size and then fill the array indexes from Collection. Need to add 1 as 0 indexing.
		prefArray = new int[getMaxNrFC() + 1];
		for (int i = 0; i < preferences.size(); i++) {
			int index = preferences.get(i).nrFC;
			int rating = preferences.get(i).comboRating;
			prefArray[index] = rating;
		}
		//clean up and get rid of preferences collection
		preferences.clear();
	}

	@Override
	public String toString() {
		return "IndCombo [prefArray=" + Arrays.toString(prefArray)
				+ ", preferences=" + preferences + "]";
	}
	

}
