package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Loads a large table of data from foodinfo database. This is the most time consuming
 * part of application as it is loading a lot of array data. 
 * 
 * Note: I originally used arraylists as I did not think to ask the result set from foodinfo
 * for the size of array to allocate. Once I did use result set size then I changed over to
 * array implementations for anticipated speed up. I commented out the araylist code in case
 * I decide to go back.
 * 
 * @author dpowell2
 *
 */
public class FoodInfo implements Serializable {

	private static final int INVARS_SIZE = 59;
	private int nrF;
	private int NDBnumber;
	private String label;
	private int ovolacto;
	private int lacfree;
	private int kosher;
	private int amount;
	private int less;
	private int more;
	private int redmeatF;
	private int vegF;
	private int brassF;
	private int fruitF;
	private int fruitvegF;
	private int fishF;
	private int type;
	private int type2;
	private int type3;
	private int type4;
	private int type5;
	private int enF;

	private double prF;
	private double fatF;
	private double satF;
	private int soF;
	private double potF;
	private int cholF;
	private double carbF;
	private double sugarF;

	private double fiberF;
	private int foF;
	private int freefoF;
	private int vcF;
	private int vaF;
	private int retF;
	private int bcF;
	private int caF;
	private int mgF;
	private int phosF;
	private double feF;

	private double[] invars; // array to hold values for inserting
	private int arraySize; //size of array used.
	private int currentIndex;

	// arrays that have values pushed on them. I will use ArrayLists and convert
	// to Arrays if needed. I clear all of these before exiting.
//	private ArrayList<Integer> nrArray;
//	private ArrayList<Integer> amtArray;
//	private ArrayList<Integer> lessArray;
//	private ArrayList<Integer> moreArray;
//	private ArrayList<Integer> NDBArray;
//	private ArrayList<String> labelArray;
//	private ArrayList<Integer> excludeArray;
//
//	private ArrayList<Integer> enArray;
//	private ArrayList<Double> nut0Array;
//	private ArrayList<Double> nut1Array;
//	private ArrayList<Double> nut2Array;
//	private ArrayList<Double> nut3Array;
//	private ArrayList<Double> nut4Array;
//	private ArrayList<Double> nut5Array;
//	private ArrayList<Double> nut6Array;
//	private ArrayList<Double> nut7Array;
//	private ArrayList<Double> nut8Array;
//	private ArrayList<Double> nut9Array;
//	private ArrayList<Double> nutaArray;
//	private ArrayList<Double> nutbArray;
//	private ArrayList<Double> nutcArray;
//	private ArrayList<Double> nutdArray;
//	private ArrayList<Double> nuteArray;
//	private ArrayList<Integer> typeArray;
//	private ArrayList<Integer> type2Array;
//	private ArrayList<Integer> type3Array;
//	private ArrayList<Integer> type4Array;
//	private ArrayList<Integer> type5Array;
	
	
	//change over from ArrayList to ArrayImplementation
	private int [] nrArrayI;
	private int [] amtArrayI;
	private int [] lessArrayI;
	private int [] moreArrayI;
	private int [] NDBArrayI;
	private String [] labelArrayS;
	private int [] excludeArrayI;
	
	private int [] enArrayI;
	private double [] nut0ArrayD;
	private double [] nut1ArrayD;
	private double [] nut2ArrayD;
	private double [] nut3ArrayD;
	private double [] nut4ArrayD;
	private double [] nut5ArrayD;
	private double [] nut6ArrayD;
	private double [] nut7ArrayD;
	private double [] nut8ArrayD;
	private double [] nut9ArrayD;
	private double [] nutaArrayD;
	private double [] nutbArrayD;
	private double [] nutcArrayD;
	private double [] nutdArrayD;
	private double [] nuteArrayD;
	private int [] typeArrayI;
	private int [] type2ArrayI;
	private int [] type3ArrayI;
	private int [] type4ArrayI;
	private int [] type5ArrayI;

	private transient OptInfo optInfo;
	private transient Allpass foods;
	
	//TODO
	//declare, instantiate and initialize Onepass, Alterpass, Mealpass, Shoppass, Daypass

//	public FoodInfo(OptInfo optInfo, Allpass foods) {
//		this.optInfo = optInfo;
//		this.foods = foods;
//		invars = new double[INVARS_SIZE];
//		initializeArrayLists();
//	}
	
	public FoodInfo(OptInfo optInfo, Allpass foods, int theArraySize) {
		this.optInfo = optInfo;
		this.foods = foods;
		invars = new double[INVARS_SIZE];
		this.arraySize = theArraySize + 1; //code use an additional index for 0
		//initializeArrayLists();
		initializeArrayLists(this.arraySize);
		System.out.println("In Food Info Constructor Arrays Allocated to " + this.arraySize);
		currentIndex = 1;
	}

	public void setInvarsElement(int index, double value) {
		invars[index] = value;
	}

//	private void initializeArrayLists() {
//		nrArray = new ArrayList<Integer>();
//		nrArray.add(0);
//		amtArray = new ArrayList<Integer>();
//		amtArray.add(0);
//		lessArray = new ArrayList<Integer>();
//		lessArray.add(0);
//		moreArray = new ArrayList<Integer>();
//		moreArray.add(0);
//		NDBArray = new ArrayList<Integer>();
//		NDBArray.add(0);
//		labelArray = new ArrayList<String>();
//		labelArray.add("0");
//		excludeArray = new ArrayList<Integer>();
//		excludeArray.add(0);
//		enArray = new ArrayList<Integer>();
//		enArray.add(0);
//		nut0Array = new ArrayList<Double>();
//		nut0Array.add(0.0);
//		nut1Array = new ArrayList<Double>();
//		nut1Array.add(0.0);
//		nut2Array = new ArrayList<Double>();
//		nut2Array.add(0.0);
//		nut3Array = new ArrayList<Double>();
//		nut3Array.add(0.0);
//		nut4Array = new ArrayList<Double>();
//		nut4Array.add(0.0);
//		nut5Array = new ArrayList<Double>();
//		nut5Array.add(0.0);
//		nut6Array = new ArrayList<Double>();
//		nut6Array.add(0.0);
//		nut7Array = new ArrayList<Double>();
//		nut7Array.add(0.0);
//		nut8Array = new ArrayList<Double>();
//		nut8Array.add(0.0);
//		nut9Array = new ArrayList<Double>();
//		nut9Array.add(0.0);
//		nutaArray = new ArrayList<Double>();
//		nutaArray.add(0.0);
//		nutbArray = new ArrayList<Double>();
//		nutbArray.add(0.0);
//		nutcArray = new ArrayList<Double>();
//		nutcArray.add(0.0);
//		nutdArray = new ArrayList<Double>();
//		nutdArray.add(0.0);
//		nuteArray = new ArrayList<Double>();
//		nuteArray.add(0.0);
//		typeArray = new ArrayList<Integer>();
//		typeArray.add(0);
//		type2Array = new ArrayList<Integer>();
//		type2Array.add(0);
//		type3Array = new ArrayList<Integer>();
//		type3Array.add(0);
//		type4Array = new ArrayList<Integer>();
//		type4Array.add(0);
//		type5Array = new ArrayList<Integer>();
//		type5Array.add(0);
//
//	}
	
	private void initializeArrayLists(int aSize) {
		nrArrayI = new int[aSize];
		amtArrayI = new int[aSize];
		lessArrayI = new int[aSize];
		moreArrayI = new int[aSize];
		NDBArrayI = new int[aSize];
		labelArrayS = new String[aSize];
		labelArrayS[0]="0";
		excludeArrayI = new int[aSize];
		enArrayI = new int[aSize];
		 
		nut0ArrayD = new double[aSize];
		nut1ArrayD = new double[aSize];
		nut2ArrayD = new double[aSize];
		nut3ArrayD = new double[aSize];
		nut4ArrayD = new double[aSize];
		nut5ArrayD = new double[aSize];
		nut6ArrayD = new double[aSize];
		nut7ArrayD = new double[aSize];
		nut8ArrayD = new double[aSize];
		nut9ArrayD = new double[aSize];
		nutaArrayD = new double[aSize];
		nutbArrayD = new double[aSize];
		nutcArrayD = new double[aSize];
		nutdArrayD = new double[aSize];
		nuteArrayD = new double[aSize];
		typeArrayI = new int[aSize];
		type2ArrayI = new int[aSize];
		type3ArrayI = new int[aSize];
		type4ArrayI = new int[aSize];
		type5ArrayI = new int[aSize];
		currentIndex = 1; //start putting values in 1
	}

	public int getNrF() {
		return nrF;
	}

	public void setNrF(int nrF) {
		this.nrF = nrF;
	}

	public int getNDBnumber() {
		return NDBnumber;
	}

	public void setNDBnumber(int nDBnumber) {
		NDBnumber = nDBnumber;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getOvolacto() {
		return ovolacto;
	}

	public void setOvolacto(int ovolacto) {
		this.ovolacto = ovolacto;
	}

	public int getLacfree() {
		return lacfree;
	}

	public void setLacfree(int lacfree) {
		this.lacfree = lacfree;
	}

	public int getKosher() {
		return kosher;
	}

	public void setKosher(int kosher) {
		this.kosher = kosher;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLess() {
		return less;
	}

	public void setLess(int less) {
		this.less = less;
	}

	public int getMore() {
		return more;
	}

	public void setMore(int more) {
		this.more = more;
	}

	public int getRedmeatF() {
		return redmeatF;
	}

	public void setRedmeatF(int redmeatF) {
		this.redmeatF = redmeatF;
	}

	public int getVegF() {
		return vegF;
	}

	public void setVegF(int vegF) {
		this.vegF = vegF;
	}

	public int getBrassF() {
		return brassF;
	}

	public void setBrassF(int brassF) {
		this.brassF = brassF;
	}

	public int getFruitF() {
		return fruitF;
	}

	public void setFruitF(int fruitF) {
		this.fruitF = fruitF;
	}

	public int getFruitvegF() {
		return fruitvegF;
	}

	public void setFruitvegF(int fruitvegF) {
		this.fruitvegF = fruitvegF;
	}

	public int getFishF() {
		return fishF;
	}

	public void setFishF(int fishF) {
		this.fishF = fishF;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType2() {
		return type2;
	}

	public void setType2(int type2) {
		this.type2 = type2;
	}

	public int getType3() {
		return type3;
	}

	public void setType3(int type3) {
		this.type3 = type3;
	}

	public int getType4() {
		return type4;
	}

	public void setType4(int type4) {
		this.type4 = type4;
	}

	public int getType5() {
		return type5;
	}

	public void setType5(int type5) {
		this.type5 = type5;
	}

	public int getEnF() {
		return enF;
	}

	public void setEnF(int enF) {
		this.enF = enF;
	}

	public double getPrF() {
		return prF;
	}

	public void setPrF(double prF) {
		this.prF = prF;
	}

	public double getFatF() {
		return fatF;
	}

	public void setFatF(double fatF) {
		this.fatF = fatF;
	}

	public double getSatF() {
		return satF;
	}

	public void setSatF(double satF) {
		this.satF = satF;
	}

	public int getSoF() {
		return soF;
	}

	public void setSoF(int soF) {
		this.soF = soF;
	}

	public double getPotF() {
		return potF;
	}

	public void setPotF(double potF) {
		this.potF = potF;
	}

	public int getCholF() {
		return cholF;
	}

	public void setCholF(int cholF) {
		this.cholF = cholF;
	}

	public double getCarbF() {
		return carbF;
	}

	public void setCarbF(double carbF) {
		this.carbF = carbF;
	}

	public double getSugarF() {
		return sugarF;
	}

	public void setSugarF(double sugarF) {
		this.sugarF = sugarF;
	}

	public double getFiberF() {
		return fiberF;
	}

	public void setFiberF(double fiberF) {
		this.fiberF = fiberF;
	}

	public int getFoF() {
		return foF;
	}

	public void setFoF(int foF) {
		this.foF = foF;
	}

	public int getFreefoF() {
		return freefoF;
	}

	public void setFreefoF(int freefoF) {
		this.freefoF = freefoF;
	}

	public int getVcF() {
		return vcF;
	}

	public void setVcF(int vcF) {
		this.vcF = vcF;
	}

	public int getVaF() {
		return vaF;
	}

	public void setVaF(int vaF) {
		this.vaF = vaF;
	}

	public int getRetF() {
		return retF;
	}

	public void setRetF(int retF) {
		this.retF = retF;
	}

	public int getBcF() {
		return bcF;
	}

	public void setBcF(int bcF) {
		this.bcF = bcF;
	}

	public int getCaF() {
		return caF;
	}

	public void setCaF(int caF) {
		this.caF = caF;
	}

	public int getMgF() {
		return mgF;
	}

	public void setMgF(int mgF) {
		this.mgF = mgF;
	}

	public int getPhosF() {
		return phosF;
	}

	public void setPhosF(int phosF) {
		this.phosF = phosF;
	}

	public double getFeF() {
		return feF;
	}

	public void setFeF(double feF) {
		this.feF = feF;
	}

//	public ArrayList<Integer> getAmtArray() {
//		return amtArray;
//	}
//
//	public void setAmtArray(ArrayList<Integer> amtArray) {
//		this.amtArray = amtArray;
//	}

//	public void addValuesToLists() {
//		nrArray.add(nrF);
//		amtArray.add(amount);
//		lessArray.add(less);
//		moreArray.add(more);
//		NDBArray.add(NDBnumber);
//		labelArray.add(label);
//		excludeArray.add(ovolacto);
//		enArray.add(enF);
//		nut0Array.add(invars[optInfo.getSel0()]);
//		nut1Array.add(invars[optInfo.getSel1()]);
//		nut2Array.add(invars[optInfo.getSel2()]);
//		nut3Array.add(invars[optInfo.getSel3()]);
//		nut4Array.add(invars[optInfo.getSel4()]);
//		nut5Array.add(invars[optInfo.getSel5()]);
//		nut6Array.add(invars[optInfo.getSel6()]);
//		nut7Array.add(invars[optInfo.getSel7()]);
//		nut8Array.add(invars[optInfo.getSel8()]);
//		nut9Array.add(invars[optInfo.getSel9()]);
//		nutaArray.add(invars[optInfo.getSela()]);
//		nutbArray.add(invars[optInfo.getSelb()]);
//		nutcArray.add(invars[optInfo.getSelc()]);
//		nutdArray.add(invars[optInfo.getSeld()]);
//		nuteArray.add(invars[optInfo.getSele()]);
//		typeArray.add(type);
//		type2Array.add(type2);
//		type3Array.add(type3);
//		type4Array.add(type4);
//		type5Array.add(type5);
//	}
	
	public void addValuesToArrays() {
		nrArrayI[currentIndex] = nrF;
		amtArrayI[currentIndex] = amount;
		lessArrayI[currentIndex] = less;
		moreArrayI[currentIndex] = more;
		NDBArrayI[currentIndex] = NDBnumber;
		labelArrayS[currentIndex] = label;
		excludeArrayI[currentIndex] = ovolacto;
		enArrayI[currentIndex] = enF;
		nut0ArrayD[currentIndex] = invars[optInfo.getSel0()];
		nut1ArrayD[currentIndex] = invars[optInfo.getSel1()];
		nut2ArrayD[currentIndex] = invars[optInfo.getSel2()];
		nut3ArrayD[currentIndex] = invars[optInfo.getSel3()];
		nut4ArrayD[currentIndex] = invars[optInfo.getSel4()];
		nut5ArrayD[currentIndex] = invars[optInfo.getSel5()];
		nut6ArrayD[currentIndex] = invars[optInfo.getSel6()];
		nut7ArrayD[currentIndex] = invars[optInfo.getSel7()];
		nut8ArrayD[currentIndex] = invars[optInfo.getSel8()];
		nut9ArrayD[currentIndex] = invars[optInfo.getSel9()];
		nutaArrayD[currentIndex] = invars[optInfo.getSela()];
		nutbArrayD[currentIndex] = invars[optInfo.getSelb()];
		nutcArrayD[currentIndex] = invars[optInfo.getSelc()];
		nutdArrayD[currentIndex] = invars[optInfo.getSeld()];
		nuteArrayD[currentIndex] = invars[optInfo.getSele()];
		typeArrayI[currentIndex] = type;
		type2ArrayI[currentIndex] = type2;
		type3ArrayI[currentIndex] = type3;
		type4ArrayI[currentIndex] = type4;
		type5ArrayI[currentIndex] = type5;
		currentIndex++;
	}

//	private int[] convertToIntArray(ArrayList<Integer> aList) {
//		int[] temp = new int[aList.size()];
//		for (int i = 0; i < aList.size(); i++) {
//			temp[i] = aList.get(i);
//		}
//		return temp;
//	}
//
//	private double[] convertToDoubleArray(ArrayList<Double> aList) {
//		double[] temp = new double[aList.size()];
//		for (int i = 0; i < aList.size(); i++) {
//			temp[i] = aList.get(i);
//		}
//		return temp;
//	}

//	public void addListsToFood() {
//		//System.out.println("DEBUG: Size of arraylists in Food Info is" + nut0Array.size());
//		foods.loadnrArray(convertToIntArray(nrArray));
//		foods.loadlabelArray(labelArray.toArray(new String[0]));
//		foods.loadexcludeArray(convertToIntArray(excludeArray));
//		foods.loadenArray(convertToIntArray(enArray));
//		foods.loadnut0Array(convertToDoubleArray(nut0Array));
//		foods.loadnut1Array(convertToDoubleArray(nut1Array));
//		foods.loadnut2Array(convertToDoubleArray(nut2Array));
//		foods.loadnut3Array(convertToDoubleArray(nut3Array));
//		foods.loadnut4Array(convertToDoubleArray(nut4Array));
//		foods.loadnut5Array(convertToDoubleArray(nut5Array));
//		foods.loadnut6Array(convertToDoubleArray(nut6Array));
//		foods.loadnut7Array(convertToDoubleArray(nut7Array));
//		foods.loadnut8Array(convertToDoubleArray(nut8Array));
//		foods.loadnut9Array(convertToDoubleArray(nut9Array));
//		foods.loadnutaArray(convertToDoubleArray(nutaArray));
//		foods.loadnutbArray(convertToDoubleArray(nutbArray));
//		foods.loadnutcArray(convertToDoubleArray(nutcArray));
//		foods.loadnutdArray(convertToDoubleArray(nutdArray));
//		foods.loadnuteArray(convertToDoubleArray(nuteArray));
//
//		foods.loadtypeArray(convertToIntArray(typeArray));
//		foods.loadtype2Array(convertToIntArray(type2Array));
//		foods.loadtype3Array(convertToIntArray(type3Array));
//		foods.loadtype4Array(convertToIntArray(type4Array));
//		foods.loadtype5Array(convertToIntArray(type5Array));
//		
//		//TODO
//		//initialize Onepass, Alterpass, Mealpass, Shoppass, Daypass
//
//	}
	
	public void addArraysToFood() {
		//System.out.println("DEBUG: Size of array in Food Info is" + nut0ArrayI.length);
		foods.loadnrArray(nrArrayI);
		foods.loadlabelArray(labelArrayS);
		foods.loadexcludeArray(excludeArrayI);
		foods.loadenArray(enArrayI);
		foods.loadnut0Array(nut0ArrayD);
		foods.loadnut1Array(nut1ArrayD);
		foods.loadnut2Array(nut2ArrayD);
		foods.loadnut3Array(nut3ArrayD);
		foods.loadnut4Array(nut4ArrayD);
		foods.loadnut5Array(nut5ArrayD);
		foods.loadnut6Array(nut6ArrayD);
		foods.loadnut7Array(nut7ArrayD);
		foods.loadnut8Array(nut8ArrayD);
		foods.loadnut9Array(nut9ArrayD);
		foods.loadnutaArray(nutaArrayD);
		foods.loadnutbArray(nutbArrayD);
		foods.loadnutcArray(nutcArrayD);
		foods.loadnutdArray(nutdArrayD);
		foods.loadnuteArray(nuteArrayD);

		foods.loadtypeArray(typeArrayI);
		foods.loadtype2Array(type2ArrayI);
		foods.loadtype3Array(type3ArrayI);
		foods.loadtype4Array(type4ArrayI);
		foods.loadtype5Array(type5ArrayI);
		
		//TODO
		//initialize Onepass, Alterpass, Mealpass, Shoppass, Daypass

	}

	@Override
	public String toString() {
		return "FoodInfo [nrArray size: " + nrArrayI.length 
				+ " nuteArray size: =" + nuteArrayD.length
				+ "]";
	}

//	public void clearLists() {
//		 
//		nrArray.clear();
//		amtArray.clear();
//		lessArray.clear();
//		moreArray.clear();
//		NDBArray.clear();
//		labelArray.clear();
//		excludeArray.clear();
//		enArray.clear();
//		nut0Array.clear();
//		nut1Array.clear();
//		nut2Array.clear();
//		nut3Array.clear();
//		nut4Array.clear();
//		nut5Array.clear();
//		nut6Array.clear(); 
//		nut7Array.clear();
//		nut8Array.clear();
//		nut9Array.clear();
//		nutaArray.clear();
//		nutbArray.clear();
//		nutcArray.clear();
//		nutdArray.clear();
//		nuteArray.clear();
//		typeArray.clear();
//		type2Array.clear();
//		type3Array.clear();
//		type4Array.clear();
//		type5Array.clear();
//	}

}
