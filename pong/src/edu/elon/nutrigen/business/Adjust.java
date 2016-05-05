package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class initialized from table Testadjust
 * Class has one call that is dependent on OptInfo data
 * for array indexing with sel variables.
 * 
 * 
 * 
 * @author dpowell2
 *
 */
public class Adjust implements Serializable {
	
	//TODO These are all temporary variables used as placeholders that I can possibly 
	//move into a local method to save memory
	private Timestamp adjTime;
	private double adjMeat;
	private double adjRedmeat;
	private double adjVeg;
	private double adjBrass;
	private double adjFruit;
	private double adjFruitveg;
	private double adjFish;
	private double adjEn;
	private double adjAlc;
	private double adjPr;
	private double adjFat;
	private double adjSat;
	private double adjTrans;
	private double adjSo;
	private double adjPot;
	private double adjChol;
	private double adjOmega6;
	private double adjOmega3;
	private double adjAla;
	private double adjDha;
	private double adjEpa;
	private double adjCarb;
	private double adjSugar;
	private double adjFiber;
	private double adjSolfib;
	private double adjInsolfib;
	private double adjB1;
	private double adjB2;
	private double adjNia;
	private double adjB6;
	private double adjB12;
	private double adjFreeb12;
	private double adjFo;
	private double adjCholine;
	private double adjBet;
	private double adjFreefo;
	private double adjVc;
	private double adjVa;
	private double adjRet;
	private double adjBc;
	private double adjVd;
	private double adjVe;
	private double adjVk;
	private double adjCa;
	private double adjMg;
	private double adjPhos;
	private double adjFe;
	private double adjZn;
	private double adjCu;
	private double adjMn;
	private double adjSe;
	private double adjIod;
	private double adjLyco;
	private double adjLutein3;
	private double adjIflav;
	private double adjCaff; 
	
	//These are not local variables
	private double enadj;
    private double nut0adj;
    private double nut1adj;
    private double nut2adj;
    private double nut3adj;
    private double nut4adj;
    private double nut5adj;
    private double nut6adj;
    private double nut7adj;
    private double nut8adj;
    private double nut9adj;
    private double nutaadj;
    private double nutbadj;
    private double nutcadj;
    private double nutdadj;
    private double nuteadj;
	
	public Adjust() {
		enadj = 1;
	
	}

	public Timestamp getAdjTime() {
		return adjTime;
	}

	public void setAdjTime(Timestamp adjTime) {
		this.adjTime = adjTime;
	}

	public double getAdjMeat() {
		return adjMeat;
	}

	public void setAdjMeat(double adjMeat) {
		this.adjMeat = adjMeat;
	}

	public double getAdjRedmeat() {
		return adjRedmeat;
	}

	public void setAdjRedmeat(double adjRedmeat) {
		this.adjRedmeat = adjRedmeat;
	}

	public double getAdjVeg() {
		return adjVeg;
	}

	public void setAdjVeg(double adjVeg) {
		this.adjVeg = adjVeg;
	}

	public double getAdjBrass() {
		return adjBrass;
	}

	public void setAdjBrass(double adjBrass) {
		this.adjBrass = adjBrass;
	}

	public double getAdjFruit() {
		return adjFruit;
	}

	public void setAdjFruit(double adjFruit) {
		this.adjFruit = adjFruit;
	}

	public double getAdjFruitveg() {
		return adjFruitveg;
	}

	public void setAdjFruitveg(double adjFruitveg) {
		this.adjFruitveg = adjFruitveg;
	}

	public double getAdjFish() {
		return adjFish;
	}

	public void setAdjFish(double adjFish) {
		this.adjFish = adjFish;
	}

	public double getAdjEn() {
		return adjEn;
	}

	public void setAdjEn(double adjEn) {
		this.adjEn = adjEn;
	}

	public double getAdjAlc() {
		return adjAlc;
	}

	public void setAdjAlc(double adjAlc) {
		this.adjAlc = adjAlc;
	}

	public double getAdjPr() {
		return adjPr;
	}

	public void setAdjPr(double adjPr) {
		this.adjPr = adjPr;
	}

	public double getAdjFat() {
		return adjFat;
	}

	public void setAdjFat(double adjFat) {
		this.adjFat = adjFat;
	}

	public double getAdjSat() {
		return adjSat;
	}

	public void setAdjSat(double adjSat) {
		this.adjSat = adjSat;
	}

	public double getAdjTrans() {
		return adjTrans;
	}

	public void setAdjTrans(double adjTrans) {
		this.adjTrans = adjTrans;
	}

	public double getAdjSo() {
		return adjSo;
	}

	public void setAdjSo(double adjSo) {
		this.adjSo = adjSo;
	}

	public double getAdjPot() {
		return adjPot;
	}

	public void setAdjPot(double adjPot) {
		this.adjPot = adjPot;
	}

	public double getAdjChol() {
		return adjChol;
	}

	public void setAdjChol(double adjChol) {
		this.adjChol = adjChol;
	}

	public double getAdjOmega6() {
		return adjOmega6;
	}

	public void setAdjOmega6(double adjOmega6) {
		this.adjOmega6 = adjOmega6;
	}

	public double getAdjOmega3() {
		return adjOmega3;
	}

	public void setAdjOmega3(double adjOmega3) {
		this.adjOmega3 = adjOmega3;
	}

	public double getAdjAla() {
		return adjAla;
	}

	public void setAdjAla(double adjAla) {
		this.adjAla = adjAla;
	}

	public double getAdjDha() {
		return adjDha;
	}

	public void setAdjDha(double adjDha) {
		this.adjDha = adjDha;
	}

	public double getAdjEpa() {
		return adjEpa;
	}

	public void setAdjEpa(double adjEpa) {
		this.adjEpa = adjEpa;
	}

	public double getAdjCarb() {
		return adjCarb;
	}

	public void setAdjCarb(double adjCarb) {
		this.adjCarb = adjCarb;
	}

	public double getAdjSugar() {
		return adjSugar;
	}

	public void setAdjSugar(double adjSugar) {
		this.adjSugar = adjSugar;
	}

	public double getAdjFiber() {
		return adjFiber;
	}

	public void setAdjFiber(double adjFiber) {
		this.adjFiber = adjFiber;
	}

	public double getAdjSolfib() {
		return adjSolfib;
	}

	public void setAdjSolfib(double adjSolfib) {
		this.adjSolfib = adjSolfib;
	}

	public double getAdjInsolfib() {
		return adjInsolfib;
	}

	public void setAdjInsolfib(double adjInsolfib) {
		this.adjInsolfib = adjInsolfib;
	}

	public double getAdjB1() {
		return adjB1;
	}

	public void setAdjB1(double adjB1) {
		this.adjB1 = adjB1;
	}

	public double getAdjB2() {
		return adjB2;
	}

	public void setAdjB2(double adjB2) {
		this.adjB2 = adjB2;
	}

	public double getAdjNia() {
		return adjNia;
	}

	public void setAdjNia(double adjNia) {
		this.adjNia = adjNia;
	}

	public double getAdjB6() {
		return adjB6;
	}

	public void setAdjB6(double adjB6) {
		this.adjB6 = adjB6;
	}

	public double getAdjB12() {
		return adjB12;
	}

	public void setAdjB12(double adjB12) {
		this.adjB12 = adjB12;
	}

	public double getAdjFreeb12() {
		return adjFreeb12;
	}

	public void setAdjFreeb12(double adjFreeb12) {
		this.adjFreeb12 = adjFreeb12;
	}

	public double getAdjFo() {
		return adjFo;
	}

	public void setAdjFo(double adjFo) {
		this.adjFo = adjFo;
	}

	public double getAdjCholine() {
		return adjCholine;
	}

	public void setAdjCholine(double adjCholine) {
		this.adjCholine = adjCholine;
	}

	public double getAdjBet() {
		return adjBet;
	}

	public void setAdjBet(double adjBet) {
		this.adjBet = adjBet;
	}

	public double getAdjFreefo() {
		return adjFreefo;
	}

	public void setAdjFreefo(double adjFreefo) {
		this.adjFreefo = adjFreefo;
	}

	public double getAdjVc() {
		return adjVc;
	}

	public void setAdjVc(double adjVc) {
		this.adjVc = adjVc;
	}

	public double getAdjVa() {
		return adjVa;
	}

	public void setAdjVa(double adjVa) {
		this.adjVa = adjVa;
	}

	public double getAdjRet() {
		return adjRet;
	}

	public void setAdjRet(double adjRet) {
		this.adjRet = adjRet;
	}

	public double getAdjBc() {
		return adjBc;
	}

	public void setAdjBc(double adjBc) {
		this.adjBc = adjBc;
	}

	public double getAdjVd() {
		return adjVd;
	}

	public void setAdjVd(double adjVd) {
		this.adjVd = adjVd;
	}

	public double getAdjVe() {
		return adjVe;
	}

	public void setAdjVe(double adjVe) {
		this.adjVe = adjVe;
	}

	public double getAdjVk() {
		return adjVk;
	}

	public void setAdjVk(double adjVk) {
		this.adjVk = adjVk;
	}

	public double getAdjCa() {
		return adjCa;
	}

	public void setAdjCa(double adjCa) {
		this.adjCa = adjCa;
	}

	public double getAdjMg() {
		return adjMg;
	}

	public void setAdjMg(double adjMg) {
		this.adjMg = adjMg;
	}

	public double getAdjPhos() {
		return adjPhos;
	}

	public void setAdjPhos(double adjPhos) {
		this.adjPhos = adjPhos;
	}

	public double getAdjFe() {
		return adjFe;
	}

	public void setAdjFe(double adjFe) {
		this.adjFe = adjFe;
	}

	public double getAdjZn() {
		return adjZn;
	}

	public void setAdjZn(double adjZn) {
		this.adjZn = adjZn;
	}

	public double getAdjCu() {
		return adjCu;
	}

	public void setAdjCu(double adjCu) {
		this.adjCu = adjCu;
	}

	public double getAdjMn() {
		return adjMn;
	}

	public void setAdjMn(double adjMn) {
		this.adjMn = adjMn;
	}

	public double getAdjSe() {
		return adjSe;
	}

	public void setAdjSe(double adjSe) {
		this.adjSe = adjSe;
	}

	public double getAdjIod() {
		return adjIod;
	}

	public void setAdjIod(double adjIod) {
		this.adjIod = adjIod;
	}

	public double getAdjLyco() {
		return adjLyco;
	}

	public void setAdjLyco(double adjLyco) {
		this.adjLyco = adjLyco;
	}

	public double getAdjLutein3() {
		return adjLutein3;
	}

	public void setAdjLutein3(double adjLutein3) {
		this.adjLutein3 = adjLutein3;
	}

	public double getAdjIflav() {
		return adjIflav;
	}

	public void setAdjIflav(double adjIflav) {
		this.adjIflav = adjIflav;
	}

	public double getAdjCaff() {
		return adjCaff;
	}

	public void setAdjCaff(double adjCaff) {
		this.adjCaff = adjCaff;
	}

	public double getEnadj() {
		return enadj;
	}

	public void setEnadj(double enadj) {
		this.enadj = enadj;
	}

	public double getNut0adj() {
		return nut0adj;
	}

	public void setNut0adj(double nut0adj) {
		this.nut0adj = nut0adj;
	}

	public double getNut1adj() {
		return nut1adj;
	}

	public void setNut1adj(double nut1adj) {
		this.nut1adj = nut1adj;
	}

	public double getNut2adj() {
		return nut2adj;
	}

	public void setNut2adj(double nut2adj) {
		this.nut2adj = nut2adj;
	}

	public double getNut3adj() {
		return nut3adj;
	}

	public void setNut3adj(double nut3adj) {
		this.nut3adj = nut3adj;
	}

	public double getNut4adj() {
		return nut4adj;
	}

	public void setNut4adj(double nut4adj) {
		this.nut4adj = nut4adj;
	}

	public double getNut5adj() {
		return nut5adj;
	}

	public void setNut5adj(double nut5adj) {
		this.nut5adj = nut5adj;
	}

	public double getNut6adj() {
		return nut6adj;
	}

	public void setNut6adj(double nut6adj) {
		this.nut6adj = nut6adj;
	}

	public double getNut7adj() {
		return nut7adj;
	}

	public void setNut7adj(double nut7adj) {
		this.nut7adj = nut7adj;
	}

	public double getNut8adj() {
		return nut8adj;
	}

	public void setNut8adj(double nut8adj) {
		this.nut8adj = nut8adj;
	}

	public double getNut9adj() {
		return nut9adj;
	}

	public void setNut9adj(double nut9adj) {
		this.nut9adj = nut9adj;
	}

	public double getNutaadj() {
		return nutaadj;
	}

	public void setNutaadj(double nutaadj) {
		this.nutaadj = nutaadj;
	}

	public double getNutbadj() {
		return nutbadj;
	}

	public void setNutbadj(double nutbadj) {
		this.nutbadj = nutbadj;
	}

	public double getNutcadj() {
		return nutcadj;
	}

	public void setNutcadj(double nutcadj) {
		this.nutcadj = nutcadj;
	}

	public double getNutdadj() {
		return nutdadj;
	}

	public void setNutdadj(double nutdadj) {
		this.nutdadj = nutdadj;
	}

	public double getNuteadj() {
		return nuteadj;
	}

	public void setNuteadj(double nuteadj) {
		this.nuteadj = nuteadj;
	}

	public void additionalProcessing(OptInfo optInfo) {
		double [] adjArray = new double[59];
		adjArray[1] = adjMeat;
		adjArray[2] = adjRedmeat;
		adjArray[3] = adjVeg;
		adjArray[4] = adjBrass;
		adjArray[5] = adjFruit;
		adjArray[6] = adjFruitveg;
		adjArray[7] =  adjFish;
		adjArray[12] =  adjPr;
		adjArray[13] =  adjFat;
		adjArray[14] =  adjSat;
		adjArray[16] =  adjSo;
		adjArray[17] =  adjPot;
		adjArray[18] =  adjChol;
		adjArray[19] =  adjOmega6;
		adjArray[20] =  adjOmega3;
		adjArray[21] =  adjAla;
		adjArray[22] =  adjDha;
		adjArray[23] =  adjEpa;
		adjArray[24] =  adjCarb;
		adjArray[25] =  adjSugar;
		adjArray[26] =  adjFiber;
		adjArray[27] =  adjSolfib;
		adjArray[28] =  adjInsolfib;
		adjArray[29] =  adjB1;
		adjArray[30] =  adjB2;
		adjArray[31] =  adjNia;
		adjArray[32] =  adjB6;
		adjArray[33] =  adjB12;
		adjArray[34] =  adjFreeb12;
		adjArray[35] =  adjFo;
		adjArray[36] =  adjCholine;
		adjArray[37] =  adjBet; //Martin had Betain
		adjArray[38] =  adjFreefo;
		adjArray[39] =  adjVc;
		adjArray[40] =  adjVa;
		adjArray[41] =  adjRet;
		adjArray[42] =  adjBc;
		adjArray[43] =  adjVd;
		adjArray[44] =  adjVe;
		adjArray[45] =  adjVk;
		adjArray[46] = adjCa;
		adjArray[47] =  adjMg;
		adjArray[48] =  adjPhos; //Martin had phost
		adjArray[49] =  adjFe;
		adjArray[50] =  adjZn;
		adjArray[51] =  adjCu;
		adjArray[52] = adjMn;
		adjArray[53] =  adjSe;
		adjArray[54] =  adjIod;
		adjArray[55] =  adjLyco;
		adjArray[56] =  adjLutein3; //Martin had lutein
		adjArray[57] =  adjIflav;
		adjArray[58] =  adjZn;
		
		enadj = adjEn;
		nut0adj = adjArray[optInfo.getSel0()];
		nut1adj = adjArray[optInfo.getSel1()];
		nut2adj = adjArray[optInfo.getSel2()];
		nut3adj = adjArray[optInfo.getSel3()];
		nut4adj = adjArray[optInfo.getSel4()];
		nut5adj = adjArray[optInfo.getSel5()];
		nut6adj = adjArray[optInfo.getSel6()];
		nut7adj = adjArray[optInfo.getSel7()];
		nut8adj = adjArray[optInfo.getSel8()];
		nut9adj = adjArray[optInfo.getSel9()];
		nutaadj = adjArray[optInfo.getSela()];
		nutbadj = adjArray[optInfo.getSelb()];
		nutcadj = adjArray[optInfo.getSelc()];
		nutdadj = adjArray[optInfo.getSeld()];
		nuteadj = adjArray[optInfo.getSele()];
		
	}

	@Override
	public String toString() {
		return "Adjust [adjTime=" + adjTime + ", adjMeat=" + adjMeat
				+ ", adjRedmeat=" + adjRedmeat + ", adjVeg=" + adjVeg
				+ ", adjBrass=" + adjBrass + ", adjFruit=" + adjFruit
				+ ", adjFruitveg=" + adjFruitveg + ", adjFish=" + adjFish
				+ ", adjEn=" + adjEn + ", adjAlc=" + adjAlc + ", adjPr="
				+ adjPr + ", adjFat=" + adjFat + ", adjSat=" + adjSat
				+ ", adjTrans=" + adjTrans + ", adjSo=" + adjSo + ", adjPot="
				+ adjPot + ", adjChol=" + adjChol + ", adjOmega6=" + adjOmega6
				+ ", adjOmega3=" + adjOmega3 + ", adjAla=" + adjAla
				+ ", adjDha=" + adjDha + ", adjEpa=" + adjEpa + ", adjCarb="
				+ adjCarb + ", adjSugar=" + adjSugar + ", adjFiber=" + adjFiber
				+ ", adjSolfib=" + adjSolfib + ", adjInsolfib=" + adjInsolfib
				+ ", adjB1=" + adjB1 + ", adjB2=" + adjB2 + ", adjNia="
				+ adjNia + ", adjB6=" + adjB6 + ", adjB12=" + adjB12
				+ ", adjFreeb12=" + adjFreeb12 + ", adjFo=" + adjFo
				+ ", adjCholine=" + adjCholine + ", adjBet=" + adjBet
				+ ", adjFreefo=" + adjFreefo + ", adjVc=" + adjVc + ", adjVa="
				+ adjVa + ", adjRet=" + adjRet + ", adjBc=" + adjBc
				+ ", adjVd=" + adjVd + ", adjVe=" + adjVe + ", adjVk=" + adjVk
				+ ", adjCa=" + adjCa + ", adjMg=" + adjMg + ", adjPhos="
				+ adjPhos + ", adjFe=" + adjFe + ", adjZn=" + adjZn
				+ ", adjCu=" + adjCu + ", adjMn=" + adjMn + ", adjSe=" + adjSe
				+ ", adjIod=" + adjIod + ", adjLyco=" + adjLyco
				+ ", adjLutein3=" + adjLutein3 + ", adjIflav=" + adjIflav
				+ ", adjCaff=" + adjCaff + ", enadj=" + enadj + ", nut0adj="
				+ nut0adj + ", nut1adj=" + nut1adj + ", nut2adj=" + nut2adj
				+ ", nut3adj=" + nut3adj + ", nut4adj=" + nut4adj
				+ ", nut5adj=" + nut5adj + ", nut6adj=" + nut6adj
				+ ", nut7adj=" + nut7adj + ", nut8adj=" + nut8adj
				+ ", nut9adj=" + nut9adj + ", nutaadj=" + nutaadj
				+ ", nutbadj=" + nutbadj + ", nutcadj=" + nutcadj
				+ ", nutdadj=" + nutdadj + ", nuteadj=" + nuteadj + "]";
	}

	
	
}
