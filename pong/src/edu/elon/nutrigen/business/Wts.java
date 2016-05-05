package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Stores wts data from DB testwts.
 * 
 * TODO - I am keeping all of the temporary variables that only need a short life span. These should
 * be moved as local variables inside of the Static method inside of WtsDB. The key reason to move is to
 * not set all of these values in Session state
 * @author dpowell2
 *
 */
public class Wts implements Serializable {
	private double maxdiff1;
	private double maxdiff2;
	private double maxdiff3;
	private double enlowMult;
	private double enhighMult;
	private double enlowt;
	private double enhiwt;

	private double nut0lowt;
	private double nut0hiwt;
	private double nut1lowt;
	private double nut1hiwt;
	private double nut2lowt;
	private double nut2hiwt;
	private double nut3lowt;
	private double nut3hiwt;
	private double nut4lowt;
	private double nut4hiwt;
	private double nut5lowt;
	private double nut5hiwt;
	private double nut6lowt;
	private double nut6hiwt;
	private double nut7lowt;
	private double nut7hiwt;
	private double nut8lowt;
	private double nut8hiwt;
	private double nut9lowt;
	private double nut9hiwt;
	private double nutalowt;
	private double nutahiwt;
	private double nutblowt;
	private double nutbhiwt;
	private double nutclowt;
	private double nutchiwt;
	private double nutdlowt;
	private double nutdhiwt;
	private double nutelowt;
	private double nutehiwt;

	// temporary variables just needed to hold for setting permanent variables.
	//TODO - These have only a brief life span. We can change access to package and eliminate getters/setters or
	//hold only in static method for duration of call.
	private Timestamp wtsTime;
	private double meatlowt;
	private double meathiwt;
	private double redmeatlowt;
	private double redmeathiwt;
	private double veglowt;
	private double veghiwt;
	private double brasslowt;
	private double brasshiwt;
	private double fruitlowt;
	private double fruithiwt;
	private double fruitveglowt;
	private double fruitveghiwt;
	private double fishlowt;
	private double fishhiwt;

	private double alclowt;
	private double alchiwt;
	private double prlowt;
	private double prhiwt;
	private double fatlowt;
	private double fathiwt;
	private double satlowt;
	private double sathiwt;
	private double translowt;
	private double transhiwt;
	private double solowt;
	private double sohiwt;
	private double potlowt;
	private double pothiwt;
	private double chollowt;
	private double cholhiwt;
	private double omega6lowt;
	private double omega6hiwt;
	private double omega3lowt;
	private double omega3hiwt;
	private double alalowt;
	private double alahiwt;
	private double dhalowt;
	private double dhahiwt;
	private double epalowt;
	private double epahiwt;
	private double carblowt;
	private double carbhiwt;
	private double sugarlowt;
	private double sugarhiwt;
	private double fiberlowt;
	private double fiberhiwt;
	private double solfiblowt;
	private double solfibhiwt;
	private double insolfiblowt;
	private double insolfibhiwt;
	private double b1lowt;
	private double b1hiwt;
	private double b2lowt;
	private double b2hiwt;
	private double nialowt;
	private double niahiwt;
	private double b6lowt;
	private double b6hiwt;
	private double b12lowt;
	private double b12hiwt;
	private double freeb12lowt;
	private double freeb12hiwt;
	private double folowt;
	private double fohiwt;
	private double cholinelowt;
	private double cholinehiwt;
	private double betlowt;
	private double bethiwt;
	private double freefolowt;
	private double freefohiwt;
	private double vclowt;
	private double vchiwt;
	private double valowt;
	private double vahiwt;
	private double retlowt;
	private double rethiwt;
	private double bclowt;
	private double bchiwt;
	private double vdlowt;
	private double vdhiwt;
	private double velowt;
	private double vehiwt;
	private double vklowt;
	private double vkhiwt;
	private double calowt;
	private double cahiwt;
	private double mglowt;
	private double mghiwt;
	private double phoslowt;
	private double phoshiwt;
	private double felowt;
	private double fehiwt;
	private double znlowt;
	private double znhiwt;
	private double culowt;
	private double cuhiwt;
	private double mnlowt;
	private double mnhiwt;
	private double selowt;
	private double sehiwt;
	private double iodlowt;
	private double iodhiwt;
	private double lycolowt;
	private double lycohiwt;
	private double luteinlowt;
	private double luteinhiwt;
	private double iflavlowt;
	private double iflavhiwt;
	private double cafflowt;
	private double caffhiwt;

	private double[] lowtArray;
	private double[] hiwtArray;

	public Wts() {
		lowtArray = new double[59];
		hiwtArray = new double[59];
		maxdiff1 = 50;			
		maxdiff2 = 200;
		maxdiff3 = 999999;
		enlowMult = 10;			
		enhighMult = 130;
		enlowt = 1;
		enhiwt = 1;
	}

	public double getMaxdiff1() {
		return maxdiff1;
	}

	public void setMaxdiff1(double maxdiff1) {
		this.maxdiff1 = maxdiff1;
	}

	public double getMaxdiff2() {
		return maxdiff2;
	}

	public void setMaxdiff2(double maxdiff2) {
		this.maxdiff2 = maxdiff2;
	}

	public double getMaxdiff3() {
		return maxdiff3;
	}

	public void setMaxdiff3(double maxdiff3) {
		this.maxdiff3 = maxdiff3;
	}

	public double getEnlowMult() {
		return enlowMult;
	}

	public void setEnlowMult(double enlowMult) {
		this.enlowMult = enlowMult;
	}

	public double getEnhighMult() {
		return enhighMult;
	}

	public void setEnhighMult(double enhighMult) {
		this.enhighMult = enhighMult;
	}

	public double getEnlowt() {
		return enlowt;
	}

	public void setEnlowt(double enlowt) {
		this.enlowt = enlowt;
	}

	public double getEnhiwt() {
		return enhiwt;
	}

	public void setEnhiwt(double enhiwt) {
		this.enhiwt = enhiwt;
	}

	public double getNut0lowt() {
		return nut0lowt;
	}

	public void setNut0lowt(double nut0lowt) {
		this.nut0lowt = nut0lowt;
	}

	public double getNut0hiwt() {
		return nut0hiwt;
	}

	public void setNut0hiwt(double nut0hiwt) {
		this.nut0hiwt = nut0hiwt;
	}

	public double getNut1lowt() {
		return nut1lowt;
	}

	public void setNut1lowt(double nut1lowt) {
		this.nut1lowt = nut1lowt;
	}

	public double getNut1hiwt() {
		return nut1hiwt;
	}

	public void setNut1hiwt(double nut1hiwt) {
		this.nut1hiwt = nut1hiwt;
	}

	public double getNut2lowt() {
		return nut2lowt;
	}

	public void setNut2lowt(double nut2lowt) {
		this.nut2lowt = nut2lowt;
	}

	public double getNut2hiwt() {
		return nut2hiwt;
	}

	public void setNut2hiwt(double nut2hiwt) {
		this.nut2hiwt = nut2hiwt;
	}

	public double getNut3lowt() {
		return nut3lowt;
	}

	public void setNut3lowt(double nut3lowt) {
		this.nut3lowt = nut3lowt;
	}

	public double getNut3hiwt() {
		return nut3hiwt;
	}

	public void setNut3hiwt(double nut3hiwt) {
		this.nut3hiwt = nut3hiwt;
	}

	public double getNut4lowt() {
		return nut4lowt;
	}

	public void setNut4lowt(double nut4lowt) {
		this.nut4lowt = nut4lowt;
	}

	public double getNut4hiwt() {
		return nut4hiwt;
	}

	public void setNut4hiwt(double nut4hiwt) {
		this.nut4hiwt = nut4hiwt;
	}

	public double getNut5lowt() {
		return nut5lowt;
	}

	public void setNut5lowt(double nut5lowt) {
		this.nut5lowt = nut5lowt;
	}

	public double getNut5hiwt() {
		return nut5hiwt;
	}

	public void setNut5hiwt(double nut5hiwt) {
		this.nut5hiwt = nut5hiwt;
	}

	public double getNut6lowt() {
		return nut6lowt;
	}

	public void setNut6lowt(double nut6lowt) {
		this.nut6lowt = nut6lowt;
	}

	public double getNut6hiwt() {
		return nut6hiwt;
	}

	public void setNut6hiwt(double nut6hiwt) {
		this.nut6hiwt = nut6hiwt;
	}

	public double getNut7lowt() {
		return nut7lowt;
	}

	public void setNut7lowt(double nut7lowt) {
		this.nut7lowt = nut7lowt;
	}

	public double getNut7hiwt() {
		return nut7hiwt;
	}

	public void setNut7hiwt(double nut7hiwt) {
		this.nut7hiwt = nut7hiwt;
	}

	public double getNut8lowt() {
		return nut8lowt;
	}

	public void setNut8lowt(double nut8lowt) {
		this.nut8lowt = nut8lowt;
	}

	public double getNut8hiwt() {
		return nut8hiwt;
	}

	public void setNut8hiwt(double nut8hiwt) {
		this.nut8hiwt = nut8hiwt;
	}

	public double getNut9lowt() {
		return nut9lowt;
	}

	public void setNut9lowt(double nut9lowt) {
		this.nut9lowt = nut9lowt;
	}

	public double getNut9hiwt() {
		return nut9hiwt;
	}

	public void setNut9hiwt(double nut9hiwt) {
		this.nut9hiwt = nut9hiwt;
	}

	public double getNutalowt() {
		return nutalowt;
	}

	public void setNutalowt(double nutalowt) {
		this.nutalowt = nutalowt;
	}

	public double getNutahiwt() {
		return nutahiwt;
	}

	public void setNutahiwt(double nutahiwt) {
		this.nutahiwt = nutahiwt;
	}

	public double getNutblowt() {
		return nutblowt;
	}

	public void setNutblowt(double nutblowt) {
		this.nutblowt = nutblowt;
	}

	public double getNutbhiwt() {
		return nutbhiwt;
	}

	public void setNutbhiwt(double nutbhiwt) {
		this.nutbhiwt = nutbhiwt;
	}

	public double getNutclowt() {
		return nutclowt;
	}

	public void setNutclowt(double nutclowt) {
		this.nutclowt = nutclowt;
	}

	public double getNutchiwt() {
		return nutchiwt;
	}

	public void setNutchiwt(double nutchiwt) {
		this.nutchiwt = nutchiwt;
	}

	public double getNutdlowt() {
		return nutdlowt;
	}

	public void setNutdlowt(double nutdlowt) {
		this.nutdlowt = nutdlowt;
	}

	public double getNutdhiwt() {
		return nutdhiwt;
	}

	public void setNutdhiwt(double nutdhiwt) {
		this.nutdhiwt = nutdhiwt;
	}

	public double getNutelowt() {
		return nutelowt;
	}

	public void setNutelowt(double nutelowt) {
		this.nutelowt = nutelowt;
	}

	public double getNutehiwt() {
		return nutehiwt;
	}

	public void setNutehiwt(double nutehiwt) {
		this.nutehiwt = nutehiwt;
	}

	public Timestamp getWtsTime() {
		return wtsTime;
	}

	public void setWtsTime(Timestamp wts_time) {
		this.wtsTime = wts_time;
	}

	public double getMeatlowt() {
		return meatlowt;
	}

	public void setMeatlowt(double meatlowt) {
		this.meatlowt = meatlowt;
	}

	public double getMeathiwt() {
		return meathiwt;
	}

	public void setMeathiwt(double meathiwt) {
		this.meathiwt = meathiwt;
	}

	public double getRedmeatlowt() {
		return redmeatlowt;
	}

	public void setRedmeatlowt(double redmeatlowt) {
		this.redmeatlowt = redmeatlowt;
	}

	public double getVeglowt() {
		return veglowt;
	}

	public void setVeglowt(double veglowt) {
		this.veglowt = veglowt;
	}

	public double getVeghiwt() {
		return veghiwt;
	}

	public void setVeghiwt(double veghiwt) {
		this.veghiwt = veghiwt;
	}

	public double getBrasslowt() {
		return brasslowt;
	}

	public void setBrasslowt(double brasslowt) {
		this.brasslowt = brasslowt;
	}

	public double getBrasshiwt() {
		return brasshiwt;
	}

	public void setBrasshiwt(double brasshiwt) {
		this.brasshiwt = brasshiwt;
	}

	public double getFruitlowt() {
		return fruitlowt;
	}

	public void setFruitlowt(double fruitlowt) {
		this.fruitlowt = fruitlowt;
	}

	public double getFruithiwt() {
		return fruithiwt;
	}

	public void setFruithiwt(double fruithiwt) {
		this.fruithiwt = fruithiwt;
	}

	public double getFruitveglowt() {
		return fruitveglowt;
	}

	public void setFruitveglowt(double fruitveglowt) {
		this.fruitveglowt = fruitveglowt;
	}

	public double getFruitveghiwt() {
		return fruitveghiwt;
	}

	public void setFruitveghiwt(double fruitveghiwt) {
		this.fruitveghiwt = fruitveghiwt;
	}

	public double getFishlowt() {
		return fishlowt;
	}

	public void setFishlowt(double fishlowt) {
		this.fishlowt = fishlowt;
	}

	public double getFishhiwt() {
		return fishhiwt;
	}

	public void setFishhiwt(double fishhiwt) {
		this.fishhiwt = fishhiwt;
	}

	public double getAlclowt() {
		return alclowt;
	}

	public void setAlclowt(double alclowt) {
		this.alclowt = alclowt;
	}

	public double getAlchiwt() {
		return alchiwt;
	}

	public void setAlchiwt(double alchiwt) {
		this.alchiwt = alchiwt;
	}

	public double getPrlowt() {
		return prlowt;
	}

	public void setPrlowt(double prlowt) {
		this.prlowt = prlowt;
	}

	public double getPrhiwt() {
		return prhiwt;
	}

	public void setPrhiwt(double prhiwt) {
		this.prhiwt = prhiwt;
	}

	public double getFatlowt() {
		return fatlowt;
	}

	public void setFatlowt(double fatlowt) {
		this.fatlowt = fatlowt;
	}

	public double getFathiwt() {
		return fathiwt;
	}

	public void setFathiwt(double fathiwt) {
		this.fathiwt = fathiwt;
	}

	public double getSatlowt() {
		return satlowt;
	}

	public void setSatlowt(double satlowt) {
		this.satlowt = satlowt;
	}

	public double getSathiwt() {
		return sathiwt;
	}

	public void setSathiwt(double sathiwt) {
		this.sathiwt = sathiwt;
	}

	public double getTranslowt() {
		return translowt;
	}

	public void setTranslowt(double translowt) {
		this.translowt = translowt;
	}

	public double getTranshiwt() {
		return transhiwt;
	}

	public void setTranshiwt(double transhiwt) {
		this.transhiwt = transhiwt;
	}

	public double getSolowt() {
		return solowt;
	}

	public void setSolowt(double solowt) {
		this.solowt = solowt;
	}

	public double getSohiwt() {
		return sohiwt;
	}

	public void setSohiwt(double sohiwt) {
		this.sohiwt = sohiwt;
	}

	public double getPotlowt() {
		return potlowt;
	}

	public void setPotlowt(double potlowt) {
		this.potlowt = potlowt;
	}

	public double getPothiwt() {
		return pothiwt;
	}

	public void setPothiwt(double pothiwt) {
		this.pothiwt = pothiwt;
	}

	public double getChollowt() {
		return chollowt;
	}

	public void setChollowt(double chollowt) {
		this.chollowt = chollowt;
	}

	public double getCholhiwt() {
		return cholhiwt;
	}

	public void setCholhiwt(double cholhiwt) {
		this.cholhiwt = cholhiwt;
	}

	public double getOmega6lowt() {
		return omega6lowt;
	}

	public void setOmega6lowt(double omega6lowt) {
		this.omega6lowt = omega6lowt;
	}

	public double getOmega6hiwt() {
		return omega6hiwt;
	}

	public void setOmega6hiwt(double omega6hiwt) {
		this.omega6hiwt = omega6hiwt;
	}

	public double getOmega3lowt() {
		return omega3lowt;
	}

	public void setOmega3lowt(double omega3lowt) {
		this.omega3lowt = omega3lowt;
	}

	public double getOmega3hiwt() {
		return omega3hiwt;
	}

	public void setOmega3hiwt(double omega3hiwt) {
		this.omega3hiwt = omega3hiwt;
	}

	public double getAlalowt() {
		return alalowt;
	}

	public void setAlalowt(double alalowt) {
		this.alalowt = alalowt;
	}

	public double getAlahiwt() {
		return alahiwt;
	}

	public void setAlahiwt(double alahiwt) {
		this.alahiwt = alahiwt;
	}

	public double getDhalowt() {
		return dhalowt;
	}

	public void setDhalowt(double dhalowt) {
		this.dhalowt = dhalowt;
	}

	public double getDhahiwt() {
		return dhahiwt;
	}

	public void setDhahiwt(double dhahiwt) {
		this.dhahiwt = dhahiwt;
	}

	public double getEpalowt() {
		return epalowt;
	}

	public void setEpalowt(double epalowt) {
		this.epalowt = epalowt;
	}

	public double getEpahiwt() {
		return epahiwt;
	}

	public void setEpahiwt(double epahiwt) {
		this.epahiwt = epahiwt;
	}

	public double getCarblowt() {
		return carblowt;
	}

	public void setCarblowt(double carblowt) {
		this.carblowt = carblowt;
	}

	public double getCarbhiwt() {
		return carbhiwt;
	}

	public void setCarbhiwt(double carbhiwt) {
		this.carbhiwt = carbhiwt;
	}

	public double getSugarlowt() {
		return sugarlowt;
	}

	public void setSugarlowt(double sugarlowt) {
		this.sugarlowt = sugarlowt;
	}

	public double getSugarhiwt() {
		return sugarhiwt;
	}

	public void setSugarhiwt(double sugarhiwt) {
		this.sugarhiwt = sugarhiwt;
	}

	public double getFiberlowt() {
		return fiberlowt;
	}

	public void setFiberlowt(double fiberlowt) {
		this.fiberlowt = fiberlowt;
	}

	public double getFiberhiwt() {
		return fiberhiwt;
	}

	public void setFiberhiwt(double fiberhiwt) {
		this.fiberhiwt = fiberhiwt;
	}

	public double getSolfiblowt() {
		return solfiblowt;
	}

	public void setSolfiblowt(double solfiblowt) {
		this.solfiblowt = solfiblowt;
	}

	public double getSolfibhiwt() {
		return solfibhiwt;
	}

	public void setSolfibhiwt(double solfibhiwt) {
		this.solfibhiwt = solfibhiwt;
	}

	public double getInsolfiblowt() {
		return insolfiblowt;
	}

	public void setInsolfiblowt(double insolfiblowt) {
		this.insolfiblowt = insolfiblowt;
	}

	public double getInsolfibhiwt() {
		return insolfibhiwt;
	}

	public void setInsolfibhiwt(double insolfibhiwt) {
		this.insolfibhiwt = insolfibhiwt;
	}

	public double getB1lowt() {
		return b1lowt;
	}

	public void setB1lowt(double b1lowt) {
		this.b1lowt = b1lowt;
	}

	public double getB1hiwt() {
		return b1hiwt;
	}

	public void setB1hiwt(double b1hiwt) {
		this.b1hiwt = b1hiwt;
	}

	public double getB2lowt() {
		return b2lowt;
	}

	public void setB2lowt(double b2lowt) {
		this.b2lowt = b2lowt;
	}

	public double getB2hiwt() {
		return b2hiwt;
	}

	public void setB2hiwt(double b2hiwt) {
		this.b2hiwt = b2hiwt;
	}

	public double getNialowt() {
		return nialowt;
	}

	public void setNialowt(double nialowt) {
		this.nialowt = nialowt;
	}

	public double getNiahiwt() {
		return niahiwt;
	}

	public void setNiahiwt(double niahiwt) {
		this.niahiwt = niahiwt;
	}

	public double getB6lowt() {
		return b6lowt;
	}

	public void setB6lowt(double b6lowt) {
		this.b6lowt = b6lowt;
	}

	public double getB6hiwt() {
		return b6hiwt;
	}

	public void setB6hiwt(double b6hiwt) {
		this.b6hiwt = b6hiwt;
	}

	public double getB12lowt() {
		return b12lowt;
	}

	public void setB12lowt(double b12lowt) {
		this.b12lowt = b12lowt;
	}

	public double getB12hiwt() {
		return b12hiwt;
	}

	public void setB12hiwt(double b12hiwt) {
		this.b12hiwt = b12hiwt;
	}

	public double getFreeb12lowt() {
		return freeb12lowt;
	}

	public void setFreeb12lowt(double freeb12lowt) {
		this.freeb12lowt = freeb12lowt;
	}

	public double getFreeb12hiwt() {
		return freeb12hiwt;
	}

	public void setFreeb12hiwt(double freeb12hiwt) {
		this.freeb12hiwt = freeb12hiwt;
	}

	public double getFolowt() {
		return folowt;
	}

	public void setFolowt(double folowt) {
		this.folowt = folowt;
	}

	public double getFohiwt() {
		return fohiwt;
	}

	public void setFohiwt(double fohiwt) {
		this.fohiwt = fohiwt;
	}

	public double getCholinelowt() {
		return cholinelowt;
	}

	public void setCholinelowt(double cholinelowt) {
		this.cholinelowt = cholinelowt;
	}

	public double getCholinehiwt() {
		return cholinehiwt;
	}

	public void setCholinehiwt(double cholinehiwt) {
		this.cholinehiwt = cholinehiwt;
	}

	public double getBetlowt() {
		return betlowt;
	}

	public void setBetlowt(double betlowt) {
		this.betlowt = betlowt;
	}

	public double getBethiwt() {
		return bethiwt;
	}

	public void setBethiwt(double bethiwt) {
		this.bethiwt = bethiwt;
	}

	public double getFreefolowt() {
		return freefolowt;
	}

	public void setFreefolowt(double freefolowt) {
		this.freefolowt = freefolowt;
	}

	public double getFreefohiwt() {
		return freefohiwt;
	}

	public void setFreefohiwt(double freefohiwt) {
		this.freefohiwt = freefohiwt;
	}

	public double getVclowt() {
		return vclowt;
	}

	public void setVclowt(double vclowt) {
		this.vclowt = vclowt;
	}

	public double getVchiwt() {
		return vchiwt;
	}

	public void setVchiwt(double vchiwt) {
		this.vchiwt = vchiwt;
	}

	public double getValowt() {
		return valowt;
	}

	public void setValowt(double valowt) {
		this.valowt = valowt;
	}

	public double getVahiwt() {
		return vahiwt;
	}

	public void setVahiwt(double vahiwt) {
		this.vahiwt = vahiwt;
	}

	public double getRetlowt() {
		return retlowt;
	}

	public void setRetlowt(double retlowt) {
		this.retlowt = retlowt;
	}

	public double getRethiwt() {
		return rethiwt;
	}

	public void setRethiwt(double rethiwt) {
		this.rethiwt = rethiwt;
	}

	public double getBclowt() {
		return bclowt;
	}

	public void setBclowt(double bclowt) {
		this.bclowt = bclowt;
	}

	public double getBchiwt() {
		return bchiwt;
	}

	public void setBchiwt(double bchiwt) {
		this.bchiwt = bchiwt;
	}

	public double getVdlowt() {
		return vdlowt;
	}

	public void setVdlowt(double vdlowt) {
		this.vdlowt = vdlowt;
	}

	public double getVdhiwt() {
		return vdhiwt;
	}

	public void setVdhiwt(double vdhiwt) {
		this.vdhiwt = vdhiwt;
	}

	public double getVelowt() {
		return velowt;
	}

	public void setVelowt(double velowt) {
		this.velowt = velowt;
	}

	public double getVehiwt() {
		return vehiwt;
	}

	public void setVehiwt(double vehiwt) {
		this.vehiwt = vehiwt;
	}

	public double getVklowt() {
		return vklowt;
	}

	public void setVklowt(double vklowt) {
		this.vklowt = vklowt;
	}

	public double getVkhiwt() {
		return vkhiwt;
	}

	public void setVkhiwt(double vkhiwt) {
		this.vkhiwt = vkhiwt;
	}

	public double getCalowt() {
		return calowt;
	}

	public void setCalowt(double calowt) {
		this.calowt = calowt;
	}

	public double getCahiwt() {
		return cahiwt;
	}

	public void setCahiwt(double cahiwt) {
		this.cahiwt = cahiwt;
	}

	public double getMglowt() {
		return mglowt;
	}

	public void setMglowt(double mglowt) {
		this.mglowt = mglowt;
	}

	public double getMghiwt() {
		return mghiwt;
	}

	public void setMghiwt(double mghiwt) {
		this.mghiwt = mghiwt;
	}

	public double getPhoslowt() {
		return phoslowt;
	}

	public void setPhoslowt(double phoslowt) {
		this.phoslowt = phoslowt;
	}

	public double getPhoshiwt() {
		return phoshiwt;
	}

	public void setPhoshiwt(double phoshiwt) {
		this.phoshiwt = phoshiwt;
	}

	public double getFelowt() {
		return felowt;
	}

	public void setFelowt(double felowt) {
		this.felowt = felowt;
	}

	public double getFehiwt() {
		return fehiwt;
	}

	public void setFehiwt(double fehiwt) {
		this.fehiwt = fehiwt;
	}

	public double getZnlowt() {
		return znlowt;
	}

	public void setZnlowt(double znlowt) {
		this.znlowt = znlowt;
	}

	public double getZnhiwt() {
		return znhiwt;
	}

	public void setZnhiwt(double znhiwt) {
		this.znhiwt = znhiwt;
	}

	public double getCulowt() {
		return culowt;
	}

	public void setCulowt(double culowt) {
		this.culowt = culowt;
	}

	public double getCuhiwt() {
		return cuhiwt;
	}

	public void setCuhiwt(double cuhiwt) {
		this.cuhiwt = cuhiwt;
	}

	public double getMnlowt() {
		return mnlowt;
	}

	public void setMnlowt(double mnlowt) {
		this.mnlowt = mnlowt;
	}

	public double getMnhiwt() {
		return mnhiwt;
	}

	public void setMnhiwt(double mnhiwt) {
		this.mnhiwt = mnhiwt;
	}

	public double getSelowt() {
		return selowt;
	}

	public void setSelowt(double selowt) {
		this.selowt = selowt;
	}

	public double getSehiwt() {
		return sehiwt;
	}

	public void setSehiwt(double sehiwt) {
		this.sehiwt = sehiwt;
	}

	public double getIodlowt() {
		return iodlowt;
	}

	public void setIodlowt(double iodlowt) {
		this.iodlowt = iodlowt;
	}

	public double getIodhiwt() {
		return iodhiwt;
	}

	public void setIodhiwt(double iodhiwt) {
		this.iodhiwt = iodhiwt;
	}

	public double getLycolowt() {
		return lycolowt;
	}

	public void setLycolowt(double lycolowt) {
		this.lycolowt = lycolowt;
	}

	public double getLycohiwt() {
		return lycohiwt;
	}

	public void setLycohiwt(double lycohiwt) {
		this.lycohiwt = lycohiwt;
	}

	public double getLuteinlowt() {
		return luteinlowt;
	}

	public void setLuteinlowt(double luteinlowt) {
		this.luteinlowt = luteinlowt;
	}

	public double getLuteinhiwt() {
		return luteinhiwt;
	}

	public void setLuteinhiwt(double luteinhiwt) {
		this.luteinhiwt = luteinhiwt;
	}

	public double getIflavlowt() {
		return iflavlowt;
	}

	public void setIflavlowt(double iflavlowt) {
		this.iflavlowt = iflavlowt;
	}

	public double getIflavhiwt() {
		return iflavhiwt;
	}

	public void setIflavhiwt(double iflavhiwt) {
		this.iflavhiwt = iflavhiwt;
	}

	public double getCafflowt() {
		return cafflowt;
	}

	public void setCafflowt(double cafflowt) {
		this.cafflowt = cafflowt;
	}

	public double getCaffhiwt() {
		return caffhiwt;
	}

	public void setCaffhiwt(double caffhiwt) {
		this.caffhiwt = caffhiwt;
	}

	public double[] getLowtArray() {
		return lowtArray;
	}

	public void setLowtArray(double[] lowtArray) {
		this.lowtArray = lowtArray;
	}

	public double[] getHiwtArray() {
		return hiwtArray;
	}

	public void setHiwtArray(double[] hiwtArray) {
		this.hiwtArray = hiwtArray;
	}

	public double getRedmeathiwt() {
		return redmeathiwt;
	}

	public void setRedmeathiwt(double redmeathiwt) {
		this.redmeathiwt = redmeathiwt;
	}

	public void additionalProcessing(OptInfo optInfo) {
		enlowMult = enlowMult/100;
		enhighMult = enhighMult/100;

// Released structures for the time being		
		maxdiff3 = 999999;
		enlowMult = 0.1;
		enhighMult = 1.3;
		lowtArray[1] = redmeatlowt;
		hiwtArray[1] = redmeathiwt;
		lowtArray[2] = redmeatlowt;
		hiwtArray[2] = redmeathiwt;
		lowtArray[3] = veglowt;
		hiwtArray[3] = veghiwt;
		lowtArray[4] = brasslowt;
		hiwtArray[4] = brasshiwt;
		lowtArray[5] = fruitlowt;
		hiwtArray[5] = fruithiwt;
		lowtArray[6] = fruitveglowt;
		hiwtArray[6] = fruitveghiwt;
		lowtArray[7] = fishlowt;
		hiwtArray[7] = fishhiwt;
		lowtArray[11] = alclowt;
		hiwtArray[11] = alchiwt;
		lowtArray[12] = prlowt;
		hiwtArray[12] = prhiwt;
		lowtArray[13] = fatlowt;
		hiwtArray[13] = fathiwt;
		lowtArray[14] = satlowt;
		hiwtArray[14] = sathiwt;
		lowtArray[15] = translowt;
		hiwtArray[15] = transhiwt;
		lowtArray[16] = solowt;
		hiwtArray[16] = sohiwt;
		lowtArray[17] = potlowt;
		hiwtArray[17] = pothiwt;
		lowtArray[18] = chollowt;
		hiwtArray[18] = cholhiwt;
		lowtArray[19] = omega3lowt;
		hiwtArray[19] = omega3hiwt;
		lowtArray[24] = carblowt;
		hiwtArray[24] = carbhiwt;
		lowtArray[25] = sugarlowt;
		hiwtArray[25] = sugarhiwt;
		lowtArray[26] = fiberlowt;
		hiwtArray[26] = fiberhiwt;
		lowtArray[35] = folowt;
		hiwtArray[35] = fohiwt;
		lowtArray[36] = cholinelowt;
		hiwtArray[36] = cholinehiwt;
		lowtArray[37] = betlowt;
		hiwtArray[37] = bethiwt;
		lowtArray[38] = freefolowt;
		hiwtArray[38] = freefohiwt;
		lowtArray[39] = vclowt;
		hiwtArray[39] = vchiwt;
		lowtArray[40] = valowt;
		hiwtArray[40] = vahiwt;
		lowtArray[41] = retlowt;
		hiwtArray[41] = rethiwt;
		lowtArray[42] = bclowt;
		hiwtArray[42] = bchiwt;
		lowtArray[43] = vdlowt;
		hiwtArray[43] = vdhiwt;
		lowtArray[44] = velowt;
		hiwtArray[44] = vehiwt;
		lowtArray[45] = vklowt;
		hiwtArray[45] = vkhiwt;
		lowtArray[46] = calowt;
		hiwtArray[46] = cahiwt;
		lowtArray[47] = mglowt;
		hiwtArray[47] = mghiwt;
		lowtArray[48] = phoslowt;
		hiwtArray[48] = phoshiwt;
		lowtArray[49] = felowt;
		hiwtArray[49] = fehiwt;		
		lowtArray[50] = znlowt;
		hiwtArray[50] = znhiwt;		
		lowtArray[51] = culowt;
		hiwtArray[51] = cuhiwt;		
		lowtArray[52] = mnlowt;
		hiwtArray[52] = mnhiwt;		
		lowtArray[53] = selowt;
		hiwtArray[53] = sehiwt;		
		lowtArray[54] = iodlowt;
		hiwtArray[54] = iodhiwt;		
		lowtArray[55] = lycolowt;
		hiwtArray[55] = lycohiwt;		
		lowtArray[56] = luteinlowt;
		hiwtArray[56] = luteinhiwt;		
		lowtArray[57] = iflavlowt;
		hiwtArray[57] = iflavhiwt;		
		lowtArray[58] = cafflowt;
		hiwtArray[58] = caffhiwt;
		
		nut0lowt = lowtArray[optInfo.getSel0()];
		nut0hiwt = hiwtArray[optInfo.getSel0()];
		nut1lowt = lowtArray[optInfo.getSel1()];
		nut1hiwt = hiwtArray[optInfo.getSel1()];
		nut2lowt = lowtArray[optInfo.getSel2()];
		nut2hiwt = hiwtArray[optInfo.getSel2()];
		nut3lowt = lowtArray[optInfo.getSel3()];
		nut3hiwt = hiwtArray[optInfo.getSel3()];
		nut4lowt = lowtArray[optInfo.getSel4()];
		nut4hiwt = hiwtArray[optInfo.getSel4()];
		nut5lowt = lowtArray[optInfo.getSel5()];
		nut5hiwt = hiwtArray[optInfo.getSel5()];
		nut6lowt = lowtArray[optInfo.getSel6()];
		nut6hiwt = hiwtArray[optInfo.getSel6()];
		nut7lowt = lowtArray[optInfo.getSel7()];
		nut7hiwt = hiwtArray[optInfo.getSel7()];
		nut8lowt = lowtArray[optInfo.getSel8()];
		nut8hiwt = hiwtArray[optInfo.getSel8()];
		nut9lowt = lowtArray[optInfo.getSel9()];
		nut9hiwt = hiwtArray[optInfo.getSel9()];		
		nutalowt = lowtArray[optInfo.getSela()];
		nutahiwt = hiwtArray[optInfo.getSela()];		
		nutblowt = lowtArray[optInfo.getSelb()];
		nutbhiwt = hiwtArray[optInfo.getSelb()];		
		nutclowt = lowtArray[optInfo.getSelc()];
		nutchiwt = hiwtArray[optInfo.getSelc()];		
		nutdlowt = lowtArray[optInfo.getSeld()];
		nutdhiwt = hiwtArray[optInfo.getSeld()];		
		nutelowt = lowtArray[optInfo.getSele()];
		nutehiwt = hiwtArray[optInfo.getSele()];	
	}

	@Override
	public String toString() {
		return "Wts [maxdiff1=" + maxdiff1 + ", maxdiff2=" + maxdiff2
				+ ", maxdiff3=" + maxdiff3 + ", enlowMult=" + enlowMult
				+ ", enhighMult=" + enhighMult + ", enlowt=" + enlowt
				+ ", enhiwt=" + enhiwt + ", nut0lowt=" + nut0lowt
				+ ", nut0hiwt=" + nut0hiwt + ", nut1lowt=" + nut1lowt
				+ ", nut1hiwt=" + nut1hiwt + ", nut2lowt=" + nut2lowt
				+ ", nut2hiwt=" + nut2hiwt + ", nut3lowt=" + nut3lowt
				+ ", nut3hiwt=" + nut3hiwt + ", nut4lowt=" + nut4lowt
				+ ", nut4hiwt=" + nut4hiwt + ", nut5lowt=" + nut5lowt
				+ ", nut5hiwt=" + nut5hiwt + ", nut6lowt=" + nut6lowt
				+ ", nut6hiwt=" + nut6hiwt + ", nut7lowt=" + nut7lowt
				+ ", nut7hiwt=" + nut7hiwt + ", nut8lowt=" + nut8lowt
				+ ", nut8hiwt=" + nut8hiwt + ", nut9lowt=" + nut9lowt
				+ ", nut9hiwt=" + nut9hiwt + ", nutalowt=" + nutalowt
				+ ", nutahiwt=" + nutahiwt + ", nutblowt=" + nutblowt
				+ ", nutbhiwt=" + nutbhiwt + ", nutclowt=" + nutclowt
				+ ", nutchiwt=" + nutchiwt + ", nutdlowt=" + nutdlowt
				+ ", nutdhiwt=" + nutdhiwt + ", nutelowt=" + nutelowt
				+ ", nutehiwt=" + nutehiwt + ", wtsTime=" + wtsTime
				+ ", meatlowt=" + meatlowt + ", meathiwt=" + meathiwt
				+ ", redmeatlowt=" + redmeatlowt + ", redmeathiwt="
				+ redmeathiwt + ", veglowt=" + veglowt + ", veghiwt=" + veghiwt
				+ ", brasslowt=" + brasslowt + ", brasshiwt=" + brasshiwt
				+ ", fruitlowt=" + fruitlowt + ", fruithiwt=" + fruithiwt
				+ ", fruitveglowt=" + fruitveglowt + ", fruitveghiwt="
				+ fruitveghiwt + ", fishlowt=" + fishlowt + ", fishhiwt="
				+ fishhiwt + ", alclowt=" + alclowt + ", alchiwt=" + alchiwt
				+ ", prlowt=" + prlowt + ", prhiwt=" + prhiwt + ", fatlowt="
				+ fatlowt + ", fathiwt=" + fathiwt + ", satlowt=" + satlowt
				+ ", sathiwt=" + sathiwt + ", translowt=" + translowt
				+ ", transhiwt=" + transhiwt + ", solowt=" + solowt
				+ ", sohiwt=" + sohiwt + ", potlowt=" + potlowt + ", pothiwt="
				+ pothiwt + ", chollowt=" + chollowt + ", cholhiwt=" + cholhiwt
				+ ", omega6lowt=" + omega6lowt + ", omega6hiwt=" + omega6hiwt
				+ ", omega3lowt=" + omega3lowt + ", omega3hiwt=" + omega3hiwt
				+ ", alalowt=" + alalowt + ", alahiwt=" + alahiwt
				+ ", dhalowt=" + dhalowt + ", dhahiwt=" + dhahiwt
				+ ", epalowt=" + epalowt + ", epahiwt=" + epahiwt
				+ ", carblowt=" + carblowt + ", carbhiwt=" + carbhiwt
				+ ", sugarlowt=" + sugarlowt + ", sugarhiwt=" + sugarhiwt
				+ ", fiberlowt=" + fiberlowt + ", fiberhiwt=" + fiberhiwt
				+ ", solfiblowt=" + solfiblowt + ", solfibhiwt=" + solfibhiwt
				+ ", insolfiblowt=" + insolfiblowt + ", insolfibhiwt="
				+ insolfibhiwt + ", b1lowt=" + b1lowt + ", b1hiwt=" + b1hiwt
				+ ", b2lowt=" + b2lowt + ", b2hiwt=" + b2hiwt + ", nialowt="
				+ nialowt + ", niahiwt=" + niahiwt + ", b6lowt=" + b6lowt
				+ ", b6hiwt=" + b6hiwt + ", b12lowt=" + b12lowt + ", b12hiwt="
				+ b12hiwt + ", freeb12lowt=" + freeb12lowt + ", freeb12hiwt="
				+ freeb12hiwt + ", folowt=" + folowt + ", fohiwt=" + fohiwt
				+ ", cholinelowt=" + cholinelowt + ", cholinehiwt="
				+ cholinehiwt + ", betlowt=" + betlowt + ", bethiwt=" + bethiwt
				+ ", freefolowt=" + freefolowt + ", freefohiwt=" + freefohiwt
				+ ", vclowt=" + vclowt + ", vchiwt=" + vchiwt + ", valowt="
				+ valowt + ", vahiwt=" + vahiwt + ", retlowt=" + retlowt
				+ ", rethiwt=" + rethiwt + ", bclowt=" + bclowt + ", bchiwt="
				+ bchiwt + ", vdlowt=" + vdlowt + ", vdhiwt=" + vdhiwt
				+ ", velowt=" + velowt + ", vehiwt=" + vehiwt + ", vklowt="
				+ vklowt + ", vkhiwt=" + vkhiwt + ", calowt=" + calowt
				+ ", cahiwt=" + cahiwt + ", mglowt=" + mglowt + ", mghiwt="
				+ mghiwt + ", phoslowt=" + phoslowt + ", phoshiwt=" + phoshiwt
				+ ", felowt=" + felowt + ", fehiwt=" + fehiwt + ", znlowt="
				+ znlowt + ", znhiwt=" + znhiwt + ", culowt=" + culowt
				+ ", cuhiwt=" + cuhiwt + ", mnlowt=" + mnlowt + ", mnhiwt="
				+ mnhiwt + ", selowt=" + selowt + ", sehiwt=" + sehiwt
				+ ", iodlowt=" + iodlowt + ", iodhiwt=" + iodhiwt
				+ ", lycolowt=" + lycolowt + ", lycohiwt=" + lycohiwt
				+ ", luteinlowt=" + luteinlowt + ", luteinhiwt=" + luteinhiwt
				+ ", iflavlowt=" + iflavlowt + ", iflavhiwt=" + iflavhiwt
				+ ", cafflowt=" + cafflowt + ", caffhiwt=" + caffhiwt
				+ ", lowtArray=" + Arrays.toString(lowtArray) + ", hiwtArray="
				+ Arrays.toString(hiwtArray) + "]";
	}

}
