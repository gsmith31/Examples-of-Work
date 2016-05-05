package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.util.Arrays;

public class OptInfo implements Serializable {
	private int optenh;
	private int optenl;
	private int opt0h;
	private int opt0l;
	private int opt1h;
	private int opt1l;
	private int opt2h;  
	private int opt2l;
	private int opt3h;
	private int opt3l; 
	private int opt4h; 
	private int opt4l;
	private int opt5h; 
	private int opt5l; 
	private int opt6h;
	private int opt6l; 
	private int opt7h; 
	private int opt7l; 
	private int opt8h; 
	private int opt8l; 
	private int opt9h; 
	private int opt9l; 
	private int optah; 
	private int optal; 
	private int optbh; 
	private int optbl; 
	private int optch;
	private int optcl;
	private int optdh;
	private int optdl;
	private int opteh;
	private int optel;
	
	private double apt0h;  
	private double apt0l;
	private double apt1h;
	private double apt1l;
	private double apt2h;
	private double apt2l;
	private double apt3h;
	private double apt3l;
	private double apt4h;
	private double apt4l;
	private double apt5h;
	private double apt5l;
	private double apt6h;
	private double apt6l;
	private double apt7h;
	private double apt7l;
	private double apt8h;
	private double apt8l;
	private double apt9h;
	private double apt9l;
	private double aptah;
	private double aptal;
	private double aptbh;
	private double aptbl;
	private double aptch;
	private double aptcl;
	private double aptdh;
	private double aptdl;
	private double apteh;  
	private double aptel;  
	
	private int sel0;
	private int sel1;
	private int sel2;
	private int sel3;
	private int sel4;  
	private int sel5;
	private int sel6;  
	private int sel7;  
	private int sel8;  
	private int sel9;
	private int sela;  
	private int selb;  
	private int selc;  
	private int seld;  
	private int sele;
	
	private int link0;
	private int link1;
	private int link2;
	private int link3;
	private int link4;  
	private int link5;
	private int link6;  
	private int link7;  
	private int link8;  
	private int link9;
	private int linka;  
	private int linkb;  
	private int linkc;  
	private int linkd;  
	private int linke;
	
	private String nut0name;
	private String nut0unit;
	private String nut0linker;
	private String nut1name;
	private String nut1unit;;
	private String nut1linker;
	private String nut2name;
	private String nut2unit;
	private String nut2linker;
	private String nut3name;
	private String nut3unit;
	private String nut3linker;
	private String nut4name;
	private String nut4unit;
	private String nut4linker;
	private String nut5name;
	private String nut5unit;
	private String nut5linker;
	private String nut6name;
	private String nut6unit;
	private String nut6linker;
	private String nut7name;
	private String nut7unit;
	private String nut7linker; 
	private String nut8name ;
	private String nut8unit;
	private String nut8linker;
	private String nut9name;
	private String nut9unit;
	private String nut9linker;
	private String nutaname;
	private String nutaunit;
	private String nutalinker;
	private String nutbname;
	private String nutbunit; 
	private String nutblinker;
	private String nutcname;
	private String nutcunit;
	private String nutclinker;
	private String nutdname;
	private String nutdunit;
	private String nutdlinker;
	private String nutename;
	private String nuteunit;
	private String nutelinker;
	
	private String[] optvarname;
	private String[] optvarunit;
	private String[] linkers;
	
	public OptInfo() {
		//Martin's code is based on 1 index and not 0.
		optvarname = new String[59];
		optvarname[1] = "Meat";
		optvarname[2] = "Red Meat";
		optvarname[3] = "Vegetables";
		optvarname[4] = "Brassica";
		optvarname[5] = "Fruit";
		optvarname[6] = "Fruits/Veggies";
		optvarname[7] = "Fish";
		optvarname[11] = "Alcohol";
		optvarname[12] = "Protein";
		optvarname[13] = "Fat";
		optvarname[14] = "Saturated Fat";
		optvarname[15] = "Trans Fat";
		optvarname[16] = "Sodium";
		optvarname[17] = "Potassium";
		optvarname[18] = "Cholesterol";
		optvarname[19] = "Omega-6 Fats";
		optvarname[20] = "Omega-3 Fats";
		optvarname[24] = "Carbohydrates";
		optvarname[25] = "Sugar";
		optvarname[26] = "Dietary Fiber";
		optvarname[27] = "Soluble Fiber";
		optvarname[28] = "Insoluble Fiber";
		optvarname[35] = "Folate";
		optvarname[36] = "Choline";
		optvarname[37] = "Betaine";
		optvarname[38] = "Added Folate";
		optvarname[39] = "Vitamin C";
		optvarname[40] = "Vitamin A";
		optvarname[41] = "Preformed Vit.A";
		optvarname[42] = "Beta-Carotene";
		optvarname[43] = "Vitamin D";
		optvarname[44] = "Vitamin E";
		optvarname[45] = "Vitamin K";
		optvarname[46] = "Calcium";
		optvarname[47] = "Magnesium";
		optvarname[48] = "Phosphate";
		optvarname[49] = "Iron";
		optvarname[50] = "Zinc";
		optvarname[51] = "Copper";
		optvarname[52] = "Manganese";
		optvarname[53] = "Selenium";
		optvarname[54] = "Iodine";
		optvarname[55] = "Lycopene";
		optvarname[56] = "Lutein";
		optvarname[57] = "Isoflavones";
		optvarname[58] = "Caffeine";
		
		optvarunit = new String[59];
		optvarunit[1] = "g";
		optvarunit[2] = "g";
		optvarunit[3] = "g";
		optvarunit[4] = "g";
		optvarunit[5] = "g";
		optvarunit[6] = "g";
		optvarunit[7] = "g";
		optvarunit[11] = "g";
		optvarunit[12] = "g";
		optvarunit[13] = "g";
		optvarunit[14] = "g";
		optvarunit[15] = "g";
		optvarunit[16] = "mg";
		optvarunit[17] = "mg";
		optvarunit[18] = "mg";
		optvarunit[19] = "mg";
		optvarunit[20] = "mg";
		optvarunit[21] = "g";
		optvarunit[22] = "g";
		optvarunit[23] = "g";
		optvarunit[24] = "g";
		optvarunit[25] = "g";
		optvarunit[26] = "g";
		optvarunit[27] = "g";
		optvarunit[28] = "g";
		optvarunit[29] = "g";
		optvarunit[30] = "g";
		optvarunit[31] = "g";
		optvarunit[32] = "g";
		optvarunit[33] = "g";
		optvarunit[34] = "µg";
		optvarunit[35] = "µg";
		optvarunit[36] = "mg";
		optvarunit[37] = "mg";
		optvarunit[38] = "µg";
		optvarunit[39] = "mg";
		optvarunit[40] = "IU";
		optvarunit[41] = "IU";
		optvarunit[42] = "IU";
		optvarunit[43] = "IU";
		optvarunit[44] = "IU";
		optvarunit[45] = "µg";
		optvarunit[46] = "mg";
		optvarunit[47] = "mg";
		optvarunit[48] = "mg";
		optvarunit[49] = "mg";
		optvarunit[50] = "mg";
		optvarunit[51] = "mg";
		optvarunit[52] = "mg";
		optvarunit[53] = "µg";
		optvarunit[54] = "µg";
		optvarunit[55] = "mg";
		optvarunit[56] = "mg";
		optvarunit[57] = "mg";
		optvarunit[58] = "mg";
		
		linkers = new String[4];
		linkers[1] = "=";
		linkers[2] = "under";
		linkers[3] = "over";
		
		sel0 = 12;
		sel1 = 14;
		sel2 = 18;
		sel3 = 35;
		sel4 = 38;
		sel5 = 39;
		sel6 = 49;
		sel7 = 16;
		sel8 = 46;
		sel9 = 47;
		sela = 2;
		selb = 6;
		selc = 40;
		seld = 41;
		sele = 42;
		
		link0 = 1;				
		link1 = 2;				
		link2 = 2;				
		link3 = 1;				
		link4 = 2;				
		link5 = 1;				
		link6 = 1;				
		link7 = 2;				
		link8 = 1;				
		link9 = 3;				
		linka = 2;				
		linkb = 3;				
		linkc = 1;				
		linkd = 2;				
		linke = 3;
		
		optenl = 2;
		optenh = 2;
		 
	}

 

	public int getOptenh() {
		return optenh;
	}

	public void setOptenh(int optenh) {
		this.optenh = optenh;
	}

	public int getOptenl() {
		return optenl;
	}

	public void setOptenl(int optenl) {
		this.optenl = optenl;
	}

	public int getOpt0h() {
		return opt0h;
	}

	public void setOpt0h(int opt0h) {
		this.opt0h = opt0h;
	}

	public int getOpt0l() {
		return opt0l;
	}

	public void setOpt0l(int opt0l) {
		this.opt0l = opt0l;
	}

	public int getOpt1h() {
		return opt1h;
	}

	public void setOpt1h(int opt1h) {
		this.opt1h = opt1h;
	}

	public int getOpt1l() {
		return opt1l;
	}

	public void setOpt1l(int opt1l) {
		this.opt1l = opt1l;
	}

	public int getOpt2h() {
		return opt2h;
	}

	public void setOpt2h(int opt2h) {
		this.opt2h = opt2h;
	}

	public int getOpt2l() {
		return opt2l;
	}

	public void setOpt2l(int opt2l) {
		this.opt2l = opt2l;
	}

	public int getOpt3h() {
		return opt3h;
	}

	public void setOpt3h(int opt3h) {
		this.opt3h = opt3h;
	}

	public int getOpt3l() {
		return opt3l;
	}

	public void setOpt3l(int opt3l) {
		this.opt3l = opt3l;
	}

	public int getOpt4h() {
		return opt4h;
	}

	public void setOpt4h(int opt4h) {
		this.opt4h = opt4h;
	}

	public int getOpt5h() {
		return opt5h;
	}

	public void setOpt5h(int opt5h) {
		this.opt5h = opt5h;
	}

	public int getOpt5l() {
		return opt5l;
	}

	public void setOpt5l(int opt5l) {
		this.opt5l = opt5l;
	}

	public int getOpt6l() {
		return opt6l;
	}

	public void setOpt6l(int opt6l) {
		this.opt6l = opt6l;
	}

	public int getOpt7h() {
		return opt7h;
	}

	public void setOpt7h(int opt7h) {
		this.opt7h = opt7h;
	}

	public int getOpt7l() {
		return opt7l;
	}

	public void setOpt7l(int opt7l) {
		this.opt7l = opt7l;
	}

	public int getOpt8h() {
		return opt8h;
	}

	public void setOpt8h(int opt8h) {
		this.opt8h = opt8h;
	}

	public int getOpt8l() {
		return opt8l;
	}

	public void setOpt8l(int opt8l) {
		this.opt8l = opt8l;
	}

	public int getOpt9h() {
		return opt9h;
	}

	public void setOpt9h(int opt9h) {
		this.opt9h = opt9h;
	}

	public int getOpt9l() {
		return opt9l;
	}

	public void setOpt9l(int opt9l) {
		this.opt9l = opt9l;
	}

	public int getOptah() {
		return optah;
	}

	public void setOptah(int optah) {
		this.optah = optah;
	}

	public int getOptal() {
		return optal;
	}

	public void setOptal(int optal) {
		this.optal = optal;
	}

	public int getOptbh() {
		return optbh;
	}

	public void setOptbh(int optbh) {
		this.optbh = optbh;
	}

	public int getOptbl() {
		return optbl;
	}

	public void setOptbl(int optbl) {
		this.optbl = optbl;
	}

	public int getOptch() {
		return optch;
	}

	public void setOptch(int optch) {
		this.optch = optch;
	}

	public int getOptcl() {
		return optcl;
	}

	public void setOptcl(int optcl) {
		this.optcl = optcl;
	}

	public int getOptdh() {
		return optdh;
	}

	public void setOptdh(int optdh) {
		this.optdh = optdh;
	}

	public int getOptdl() {
		return optdl;
	}

	public void setOptdl(int optdl) {
		this.optdl = optdl;
	}

	public int getOpteh() {
		return opteh;
	}

	public void setOpteh(int opteh) {
		this.opteh = opteh;
	}

	public int getOptel() {
		return optel;
	}

	public void setOptel(int optel) {
		this.optel = optel;
	}

	
 
	public double getApt0h() {
		return apt0h;
	}

	public void setApt0h(double apt0h) {
		this.apt0h = apt0h;
	}

	public double getApt0l() {
		return apt0l;
	}

	public void setApt0l(double apt0l) {
		this.apt0l = apt0l;
	}

	public double getApt1h() {
		return apt1h;
	}

	public void setApt1h(double apt1h) {
		this.apt1h = apt1h;
	}

	public double getApt1l() {
		return apt1l;
	}

	public void setApt1l(double apt1l) {
		this.apt1l = apt1l;
	}

	public double getApt2h() {
		return apt2h;
	}

	public void setApt2h(double apt2h) {
		this.apt2h = apt2h;
	}

	public double getApt2l() {
		return apt2l;
	}

	public void setApt2l(double apt2l) {
		this.apt2l = apt2l;
	}

	public double getApt3h() {
		return apt3h;
	}

	public void setApt3h(double apt3h) {
		this.apt3h = apt3h;
	}

	public double getApt3l() {
		return apt3l;
	}

	public void setApt3l(double apt3l) {
		this.apt3l = apt3l;
	}

	public double getApt4h() {
		return apt4h;
	}

	public void setApt4h(double apt4h) {
		this.apt4h = apt4h;
	}

	public double getApt4l() {
		return apt4l;
	}

	public void setApt4l(double apt4l) {
		this.apt4l = apt4l;
	}

	public double getApt5h() {
		return apt5h;
	}

	public void setApt5h(double apt5h) {
		this.apt5h = apt5h;
	}

	public double getApt5l() {
		return apt5l;
	}

	public void setApt5l(double apt5l) {
		this.apt5l = apt5l;
	}

	public double getApt6h() {
		return apt6h;
	}

	public void setApt6h(double apt6h) {
		this.apt6h = apt6h;
	}

	public double getApt6l() {
		return apt6l;
	}

	public void setApt6l(double apt6l) {
		this.apt6l = apt6l;
	}

	public double getApt7h() {
		return apt7h;
	}

	public void setApt7h(double apt7h) {
		this.apt7h = apt7h;
	}

	public double getApt7l() {
		return apt7l;
	}

	public void setApt7l(double apt7l) {
		this.apt7l = apt7l;
	}

	public double getApt8h() {
		return apt8h;
	}

	public void setApt8h(double apt8h) {
		this.apt8h = apt8h;
	}

	public double getApt8l() {
		return apt8l;
	}

	public void setApt8l(double apt8l) {
		this.apt8l = apt8l;
	}

	public double getApt9h() {
		return apt9h;
	}

	public void setApt9h(double apt9h) {
		this.apt9h = apt9h;
	}

	public double getApt9l() {
		return apt9l;
	}

	public void setApt9l(double apt9l) {
		this.apt9l = apt9l;
	}

	public double getAptah() {
		return aptah;
	}

	public void setAptah(double aptah) {
		this.aptah = aptah;
	}

	public double getAptal() {
		return aptal;
	}

	public void setAptal(double aptal) {
		this.aptal = aptal;
	}

	public double getAptbh() {
		return aptbh;
	}

	public void setAptbh(double aptbh) {
		this.aptbh = aptbh;
	}

	public double getAptbl() {
		return aptbl;
	}

	public void setAptbl(double aptbl) {
		this.aptbl = aptbl;
	}

	public double getAptch() {
		return aptch;
	}

	public void setAptch(double aptch) {
		this.aptch = aptch;
	}

	public double getAptcl() {
		return aptcl;
	}

	public void setAptcl(double aptcl) {
		this.aptcl = aptcl;
	}

	public double getAptdh() {
		return aptdh;
	}

	public void setAptdh(double aptdh) {
		this.aptdh = aptdh;
	}

	public double getAptdl() {
		return aptdl;
	}

	public void setAptdl(double aptdl) {
		this.aptdl = aptdl;
	}

	public double getApteh() {
		return apteh;
	}

	public void setApteh(double apteh) {
		this.apteh = apteh;
	}

	public double getAptel() {
		return aptel;
	}

	public void setAptel(double aptel) {
		this.aptel = aptel;
	}

	public int getSel0() {
		return sel0;
	}

	public void setSel0(int sel0) {
		this.sel0 = sel0;
	}

	public int getSel1() {
		return sel1;
	}

	public void setSel1(int sel1) {
		this.sel1 = sel1;
	}

	public int getSel2() {
		return sel2;
	}

	public void setSel2(int sel2) {
		this.sel2 = sel2;
	}

	public int getSel3() {
		return sel3;
	}

	public void setSel3(int sel3) {
		this.sel3 = sel3;
	}

	public int getSel4() {
		return sel4;
	}

	public void setSel4(int sel4) {
		this.sel4 = sel4;
	}

	public int getSel5() {
		return sel5;
	}

	public void setSel5(int sel5) {
		this.sel5 = sel5;
	}

	public int getSel6() {
		return sel6;
	}

	public void setSel6(int sel6) {
		this.sel6 = sel6;
	}

	public int getSel7() {
		return sel7;
	}

	public void setSel7(int sel7) {
		this.sel7 = sel7;
	}

	public int getSel8() {
		return sel8;
	}

	public void setSel8(int sel8) {
		this.sel8 = sel8;
	}

	public int getSel9() {
		return sel9;
	}

	public void setSel9(int sel9) {
		this.sel9 = sel9;
	}

	public int getSela() {
		return sela;
	}

	public void setSela(int sela) {
		this.sela = sela;
	}

	public int getSelb() {
		return selb;
	}

	public void setSelb(int selb) {
		this.selb = selb;
	}

	public int getSelc() {
		return selc;
	}

	public void setSelc(int selc) {
		this.selc = selc;
	}

	public int getSeld() {
		return seld;
	}

	public void setSeld(int seld) {
		this.seld = seld;
	}

	public int getSele() {
		return sele;
	}

	public void setSele(int sele) {
		this.sele = sele;
	}

	public int getLink0() {
		return link0;
	}

	public void setLink0(int link0) {
		this.link0 = link0;
	}

	public int getLink1() {
		return link1;
	}

	public void setLink1(int link1) {
		this.link1 = link1;
	}

	public int getLink2() {
		return link2;
	}

	public void setLink2(int link2) {
		this.link2 = link2;
	}

	public int getLink3() {
		return link3;
	}

	public void setLink3(int link3) {
		this.link3 = link3;
	}

	public int getLink4() {
		return link4;
	}

	public void setLink4(int link4) {
		this.link4 = link4;
	}

	public int getLink5() {
		return link5;
	}

	public void setLink5(int link5) {
		this.link5 = link5;
	}

	public int getLink6() {
		return link6;
	}

	public void setLink6(int link6) {
		this.link6 = link6;
	}

	public int getLink7() {
		return link7;
	}

	public void setLink7(int link7) {
		this.link7 = link7;
	}

	public int getLink8() {
		return link8;
	}

	public void setLink8(int link8) {
		this.link8 = link8;
	}

	public int getLink9() {
		return link9;
	}

	public void setLink9(int link9) {
		this.link9 = link9;
	}

	public int getLinka() {
		return linka;
	}

	public void setLinka(int linka) {
		this.linka = linka;
	}

	public int getLinkb() {
		return linkb;
	}

	public void setLinkb(int linkb) {
		this.linkb = linkb;
	}

	public int getLinkc() {
		return linkc;
	}

	public void setLinkc(int linkc) {
		this.linkc = linkc;
	}

	public int getLinkd() {
		return linkd;
	}

	public void setLinkd(int linkd) {
		this.linkd = linkd;
	}

	public int getLinke() {
		return linke;
	}

	public void setLinke(int linke) {
		this.linke = linke;
	}

	public String getNut0name() {
		return nut0name;
	}

	public void setNut0name(String nut0name) {
		this.nut0name = nut0name;
	}

	public String getNut0unit() {
		return nut0unit;
	}

	public void setNut0unit(String nut0unit) {
		this.nut0unit = nut0unit;
	}

	public String getNut0linker() {
		return nut0linker;
	}

	public void setNut0linker(String nut0linker) {
		this.nut0linker = nut0linker;
	}

	public String getNut1name() {
		return nut1name;
	}

	public void setNut1name(String nut1name) {
		this.nut1name = nut1name;
	}

	public String getNut1unit() {
		return nut1unit;
	}

	public void setNut1unit(String nut1unit) {
		this.nut1unit = nut1unit;
	}

	public String getNut1linker() {
		return nut1linker;
	}

	public void setNut1linker(String nut1linker) {
		this.nut1linker = nut1linker;
	}

	public String getNut2name() {
		return nut2name;
	}

	public void setNut2name(String nut2name) {
		this.nut2name = nut2name;
	}

	public String getNut2unit() {
		return nut2unit;
	}

	public void setNut2unit(String nut2unit) {
		this.nut2unit = nut2unit;
	}

	public String getNut2linker() {
		return nut2linker;
	}

	public void setNut2linker(String nut2linker) {
		this.nut2linker = nut2linker;
	}

	public String getNut3name() {
		return nut3name;
	}

	public void setNut3name(String nut3name) {
		this.nut3name = nut3name;
	}

	public String getNut3unit() {
		return nut3unit;
	}

	public void setNut3unit(String nut3unit) {
		this.nut3unit = nut3unit;
	}

	public String getNut3linker() {
		return nut3linker;
	}

	public void setNut3linker(String nut3linker) {
		this.nut3linker = nut3linker;
	}

	public String getNut4name() {
		return nut4name;
	}

	public void setNut4name(String nut4name) {
		this.nut4name = nut4name;
	}

	public String getNut4unit() {
		return nut4unit;
	}

	public void setNut4unit(String nut4unit) {
		this.nut4unit = nut4unit;
	}

	public String getNut4linker() {
		return nut4linker;
	}

	public void setNut4linker(String nut4linker) {
		this.nut4linker = nut4linker;
	}

	public String getNut5name() {
		return nut5name;
	}

	public void setNut5name(String nut5name) {
		this.nut5name = nut5name;
	}

	public String getNut5unit() {
		return nut5unit;
	}

	public void setNut5unit(String nut5unit) {
		this.nut5unit = nut5unit;
	}

	public String getNut5linker() {
		return nut5linker;
	}

	public void setNut5linker(String nut5linker) {
		this.nut5linker = nut5linker;
	}

	public String getNut6name() {
		return nut6name;
	}

	public void setNut6name(String nut6name) {
		this.nut6name = nut6name;
	}

	public String getNut6unit() {
		return nut6unit;
	}

	public void setNut6unit(String nut6unit) {
		this.nut6unit = nut6unit;
	}

	public String getNut6linker() {
		return nut6linker;
	}

	public void setNut6linker(String nut6linker) {
		this.nut6linker = nut6linker;
	}

	public String getNut7name() {
		return nut7name;
	}

	public void setNut7name(String nut7name) {
		this.nut7name = nut7name;
	}

	public String getNut7unit() {
		return nut7unit;
	}

	public void setNut7unit(String nut7unit) {
		this.nut7unit = nut7unit;
	}

	public String getNut7linker() {
		return nut7linker;
	}

	public void setNut7linker(String nut7linker) {
		this.nut7linker = nut7linker;
	}

	public String getNut8name() {
		return nut8name;
	}

	public void setNut8name(String nut8name) {
		this.nut8name = nut8name;
	}

	public String getNut8unit() {
		return nut8unit;
	}

	public void setNut8unit(String nut8unit) {
		this.nut8unit = nut8unit;
	}

	public String getNut8linker() {
		return nut8linker;
	}

	public void setNut8linker(String nut8linker) {
		this.nut8linker = nut8linker;
	}

	public String getNut9name() {
		return nut9name;
	}

	public void setNut9name(String nut9name) {
		this.nut9name = nut9name;
	}

	public String getNut9unit() {
		return nut9unit;
	}

	public void setNut9unit(String nut9unit) {
		this.nut9unit = nut9unit;
	}

	public String getNut9linker() {
		return nut9linker;
	}

	public void setNut9linker(String nut9linker) {
		this.nut9linker = nut9linker;
	}

	public String getNutaname() {
		return nutaname;
	}

	public void setNutaname(String nutaname) {
		this.nutaname = nutaname;
	}

	public String getNutaunit() {
		return nutaunit;
	}

	public void setNutaunit(String nutaunit) {
		this.nutaunit = nutaunit;
	}

	public String getNutalinker() {
		return nutalinker;
	}

	public void setNutalinker(String nutalinker) {
		this.nutalinker = nutalinker;
	}

	public String getNutbname() {
		return nutbname;
	}

	public void setNutbname(String nutbname) {
		this.nutbname = nutbname;
	}

	public String getNutbunit() {
		return nutbunit;
	}

	public void setNutbunit(String nutbunit) {
		this.nutbunit = nutbunit;
	}

	public String getNutblinker() {
		return nutblinker;
	}

	public void setNutblinker(String nutblinker) {
		this.nutblinker = nutblinker;
	}

	public String getNutcname() {
		return nutcname;
	}

	public void setNutcname(String nutcname) {
		this.nutcname = nutcname;
	}

	public String getNutcunit() {
		return nutcunit;
	}

	public void setNutcunit(String nutcunit) {
		this.nutcunit = nutcunit;
	}

	public String getNutdname() {
		return nutdname;
	}

	public void setNutdname(String nutdname) {
		this.nutdname = nutdname;
	}

	public String getNutdunit() {
		return nutdunit;
	}

	public void setNutdunit(String nutdunit) {
		this.nutdunit = nutdunit;
	}

	public String getNutdlinker() {
		return nutdlinker;
	}

	public void setNutdlinker(String nutdlinker) {
		this.nutdlinker = nutdlinker;
	}

	public String getNutename() {
		return nutename;
	}

	public void setNutename(String nutename) {
		this.nutename = nutename;
	}

	public String getNuteunit() {
		return nuteunit;
	}

	public void setNuteunit(String nuteunit) {
		this.nuteunit = nuteunit;
	}

	public String getNutelinker() {
		return nutelinker;
	}

	public void setNutelinker(String nutelinker) {
		this.nutelinker = nutelinker;
	}

	public int getOpt4l() {
		return opt4l;
	}

	public void setOpt4l(int opt4l) {
		this.opt4l = opt4l;
	}

	public int getOpt6h() {
		return opt6h;
	}

	public void setOpt6h(int opt6h) {
		this.opt6h = opt6h;
	}

	public String[] getOptvarname() {
		return optvarname;
	}

	public void setOptvarname(String[] optvarname) {
		this.optvarname = optvarname;
	}

	public String[] getOptvarunit() {
		return optvarunit;
	}

	public void setOptvarunit(String[] optvarunit) {
		this.optvarunit = optvarunit;
	}

	public String[] getLinkers() {
		return linkers;
	}

	public void setLinkers(String[] linkers) {
		this.linkers = linkers;
	}

	public void additionalProcessing() {
		nut0name = optvarname[sel0];
		nut0unit = optvarunit[sel0];
		nut0linker = linkers[link0];
		nut1name = optvarname[sel1];
		nut1unit = optvarunit[sel1];
		nut1linker = linkers[link1];
		nut2name = optvarname[sel2];
		nut2unit = optvarunit[sel2];
		nut2linker = linkers[link2];
		nut3name = optvarname[sel3];
		nut3unit = optvarunit[sel3];
		nut3linker = linkers[link3];
		nut4name = optvarname[sel4];
		nut4unit = optvarunit[sel4];
		nut4linker = linkers[link4];
		nut5name = optvarname[sel5];
		nut5unit = optvarunit[sel5];
		nut5linker = linkers[link5];
		nut6name = optvarname[sel6];
		nut6unit = optvarunit[sel6];
		nut6linker = linkers[link6];
		nut7name = optvarname[sel7];
		nut7unit = optvarunit[sel7];
		nut7linker = linkers[link7];
		nut8name = optvarname[sel8];
		nut8unit = optvarunit[sel8];
		nut8linker = linkers[link8];
		nut9name = optvarname[sel9];
		nut9unit = optvarunit[sel9];
		nut9linker = linkers[link9];
		nutaname = optvarname[sela];
		nutaunit = optvarunit[sela];
		nutalinker = linkers[linka];
		nutbname = optvarname[selb];
		nutbunit = optvarunit[selb];
		nutblinker = linkers[linkb];
		nutcname = optvarname[selc];
		nutcunit = optvarunit[selc];
		nutclinker = linkers[linkc];
		nutdname = optvarname[seld];
		nutdunit = optvarunit[seld];
		nutdlinker = linkers[linkd];
		nutename = optvarname[sele];
		nuteunit = optvarunit[sele];
		nutelinker = linkers[linke];
		
	}



	@Override
	public String toString() {
		return "OptInfo [optenh=" + optenh + ", optenl=" + optenl + ", opt0h="
				+ opt0h + ", opt0l=" + opt0l + ", opt1h=" + opt1h + ", opt1l="
				+ opt1l + ", opt2h=" + opt2h + ", opt2l=" + opt2l + ", opt3h="
				+ opt3h + ", opt3l=" + opt3l + ", opt4h=" + opt4h + ", opt4l="
				+ opt4l + ", opt5h=" + opt5h + ", opt5l=" + opt5l + ", opt6h="
				+ opt6h + ", opt6l=" + opt6l + ", opt7h=" + opt7h + ", opt7l="
				+ opt7l + ", opt8h=" + opt8h + ", opt8l=" + opt8l + ", opt9h="
				+ opt9h + ", opt9l=" + opt9l + ", optah=" + optah + ", optal="
				+ optal + ", optbh=" + optbh + ", optbl=" + optbl + ", optch="
				+ optch + ", optcl=" + optcl + ", optdh=" + optdh + ", optdl="
				+ optdl + ", opteh=" + opteh + ", optel=" + optel + ", apt0h="
				+ apt0h + ", apt0l=" + apt0l + ", apt1h=" + apt1h + ", apt1l="
				+ apt1l + ", apt2h=" + apt2h + ", apt2l=" + apt2l + ", apt3h="
				+ apt3h + ", apt3l=" + apt3l + ", apt4h=" + apt4h + ", apt4l="
				+ apt4l + ", apt5h=" + apt5h + ", apt5l=" + apt5l + ", apt6h="
				+ apt6h + ", apt6l=" + apt6l + ", apt7h=" + apt7h + ", apt7l="
				+ apt7l + ", apt8h=" + apt8h + ", apt8l=" + apt8l + ", apt9h="
				+ apt9h + ", apt9l=" + apt9l + ", aptah=" + aptah + ", aptal="
				+ aptal + ", aptbh=" + aptbh + ", aptbl=" + aptbl + ", aptch="
				+ aptch + ", aptcl=" + aptcl + ", aptdh=" + aptdh + ", aptdl="
				+ aptdl + ", apteh=" + apteh + ", aptel=" + aptel + ", sel0="
				+ sel0 + ", sel1=" + sel1 + ", sel2=" + sel2 + ", sel3=" + sel3
				+ ", sel4=" + sel4 + ", sel5=" + sel5 + ", sel6=" + sel6
				+ ", sel7=" + sel7 + ", sel8=" + sel8 + ", sel9=" + sel9
				+ ", sela=" + sela + ", selb=" + selb + ", selc=" + selc
				+ ", seld=" + seld + ", sele=" + sele + ", link0=" + link0
				+ ", link1=" + link1 + ", link2=" + link2 + ", link3=" + link3
				+ ", link4=" + link4 + ", link5=" + link5 + ", link6=" + link6
				+ ", link7=" + link7 + ", link8=" + link8 + ", link9=" + link9
				+ ", linka=" + linka + ", linkb=" + linkb + ", linkc=" + linkc
				+ ", linkd=" + linkd + ", linke=" + linke + ", nut0name="
				+ nut0name + ", nut0unit=" + nut0unit + ", nut0linker="
				+ nut0linker + ", nut1name=" + nut1name + ", nut1unit="
				+ nut1unit + ", nut1linker=" + nut1linker + ", nut2name="
				+ nut2name + ", nut2unit=" + nut2unit + ", nut2linker="
				+ nut2linker + ", nut3name=" + nut3name + ", nut3unit="
				+ nut3unit + ", nut3linker=" + nut3linker + ", nut4name="
				+ nut4name + ", nut4unit=" + nut4unit + ", nut4linker="
				+ nut4linker + ", nut5name=" + nut5name + ", nut5unit="
				+ nut5unit + ", nut5linker=" + nut5linker + ", nut6name="
				+ nut6name + ", nut6unit=" + nut6unit + ", nut6linker="
				+ nut6linker + ", nut7name=" + nut7name + ", nut7unit="
				+ nut7unit + ", nut7linker=" + nut7linker + ", nut8name="
				+ nut8name + ", nut8unit=" + nut8unit + ", nut8linker="
				+ nut8linker + ", nut9name=" + nut9name + ", nut9unit="
				+ nut9unit + ", nut9linker=" + nut9linker + ", nutaname="
				+ nutaname + ", nutaunit=" + nutaunit + ", nutalinker="
				+ nutalinker + ", nutbname=" + nutbname + ", nutbunit="
				+ nutbunit + ", nutblinker=" + nutblinker + ", nutcname="
				+ nutcname + ", nutcunit=" + nutcunit + ", nutclinker="
				+ nutclinker + ", nutdname=" + nutdname + ", nutdunit="
				+ nutdunit + ", nutdlinker=" + nutdlinker + ", nutename="
				+ nutename + ", nuteunit=" + nuteunit + ", nutelinker="
				+ nutelinker + ", optvarname=" + Arrays.toString(optvarname)
				+ ", optvarunit=" + Arrays.toString(optvarunit) + ", linkers="
				+ Arrays.toString(linkers) + "]";
	}



	public String getNutclinker() {
		return nutclinker;
	}



	public void setNutclinker(String nutclinker) {
		this.nutclinker = nutclinker;
	}
	
	

	
}
