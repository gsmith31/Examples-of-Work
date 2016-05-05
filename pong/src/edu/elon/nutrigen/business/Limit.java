package edu.elon.nutrigen.business;

import java.io.Serializable;

/*
 * Primarily a short lived class to pass data to Allpass sort
 */
public class Limit implements Serializable {
	// From Wts
	private double maxdiff1;
	private double maxdiff2;;
	private double maxdiff3;
	private double enlowMult;
	private double enhighMult;

	// From Adequacy
	private double enUL;
	private double nut0UL;
	private double nut1UL;
	private double nut2UL;
	private double nut3UL;
	private double nut4UL;
	private double nut5UL;
	private double nut6UL;
	private double nut7UL;
	private double nut8UL;
	private double nut9UL;
	private double nutaUL;
	private double nutbUL;
	private double nutcUL;
	private double nutdUL;
	private double nuteUL;

	// From Adequecy
	private double nut0Target;
	private double nut1Target;
	private double nut2Target;
	private double nut3Target;
	private double nut4Target;
	private double nut5Target;
	private double nut6Target;
	private double nut7Target;
	private double nut8Target;
	private double nut9Target;
	private double nutaTarget;
	private double nutbTarget;
	private double nutcTarget;
	private double nutdTarget;
	private double nuteTarget;

	// From Adequecy
	private double endayTarget;
	private double nut0dayTarget;
	private double nut1dayTarget;
	private double nut2dayTarget;
	private double nut3dayTarget;
	private double nut4dayTarget;
	private double nut5dayTarget;
	private double nut6dayTarget;
	private double nut7dayTarget;
	private double nut8dayTarget;
	private double nut9dayTarget;
	private double nutadayTarget;
	private double nutbdayTarget;
	private double nutcdayTarget;
	private double nutddayTarget;
	private double nutedayTarget;

	// from wts
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

	// from OptInfo
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

	// from OptInfo
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

	private int exclude; // from User
	private double fraction; // from currentFraction in MealsCombos

	private transient Adequacy adequacy;
	private transient MealCombos mealcombos;
	private transient OptInfo optInfo;
	private transient Wts wts;
	private transient User user;

	public Limit(Adequacy adequacy, MealCombos mealcombos, OptInfo optInfo, User user,
			Wts wts) {
		this.adequacy = adequacy;
		this.mealcombos = mealcombos;
		this.optInfo = optInfo;
		this.wts = wts;
		this.user = user;
		updateTargets();
		initializeData();
	}

	private void initializeData() {
		maxdiff1 = wts.getMaxdiff1();
		maxdiff2 = wts.getMaxdiff2();
		maxdiff3 = wts.getMaxdiff3();
		enlowMult = wts.getEnlowMult();
		enhighMult = wts.getEnhighMult();

		enUL = adequacy.getEnUL();
		nut0UL = adequacy.getNut0UL();
		nut1UL = adequacy.getNut1UL();
		nut2UL = adequacy.getNut2UL();
		nut3UL = adequacy.getNut3UL();
		nut4UL = adequacy.getNut4UL();
		nut5UL = adequacy.getNut5UL();
		nut6UL = adequacy.getNut6UL();
		nut7UL = adequacy.getNut7UL();
		nut8UL = adequacy.getNut8UL();
		nut9UL = adequacy.getNut9UL();
		nutaUL = adequacy.getNutaUL();
		nutbUL = adequacy.getNutbUL();
		nutcUL = adequacy.getNutcUL();
		nutdUL = adequacy.getNutdUL();
		nuteUL = adequacy.getNuteUL();

		endayTarget = adequacy.getEndayTarget();
		nut0dayTarget = adequacy.getNut0dayTarget();
		nut1dayTarget = adequacy.getNut1dayTarget();
		nut2dayTarget = adequacy.getNut2dayTarget();
		nut3dayTarget = adequacy.getNut3dayTarget();
		nut4dayTarget = adequacy.getNut4dayTarget();
		nut5dayTarget = adequacy.getNut5dayTarget();
		nut6dayTarget = adequacy.getNut6dayTarget();
		nut7dayTarget = adequacy.getNut7dayTarget();
		nut8dayTarget = adequacy.getNut8dayTarget();
		nut9dayTarget = adequacy.getNut9dayTarget();
		nutadayTarget = adequacy.getNutadayTarget();
		nutbdayTarget = adequacy.getNutbdayTarget();
		nutcdayTarget = adequacy.getNutcdayTarget();
		nutddayTarget = adequacy.getNutddayTarget();
		nutedayTarget = adequacy.getNutedayTarget();

		enlowt = wts.getEnlowt();
		enhiwt = wts.getEnhiwt();
		nut0lowt = wts.getNut0lowt();
		nut0hiwt = wts.getNut0hiwt();
		nut1lowt = wts.getNut1lowt();
		nut1hiwt = wts.getNut1hiwt();
		nut2lowt = wts.getNut2lowt();
		nut2hiwt = wts.getNut2hiwt();
		nut3lowt = wts.getNut3lowt();
		nut3hiwt = wts.getNut3hiwt();
		nut4lowt = wts.getNut4lowt();
		nut4hiwt = wts.getNut4hiwt();
		nut5lowt = wts.getNut5lowt();
		nut5hiwt = wts.getNut5hiwt();
		nut6lowt = wts.getNut6lowt();
		nut6hiwt = wts.getNut6hiwt();
		nut7lowt = wts.getNut7lowt();
		nut7hiwt = wts.getNut7hiwt();
		nut8lowt = wts.getNut8lowt();
		nut8hiwt = wts.getNut8hiwt();
		nut9lowt = wts.getNut9lowt();
		nut9hiwt = wts.getNut9hiwt();
		nutalowt = wts.getNutalowt();
		nutahiwt = wts.getNutahiwt();
		nutblowt = wts.getNutblowt();
		nutbhiwt = wts.getNutbhiwt();
		nutclowt = wts.getNutclowt();
		nutchiwt = wts.getNutchiwt();
		nutdlowt = wts.getNutdlowt();
		nutdhiwt = wts.getNutdhiwt();
		nutelowt = wts.getNutelowt();
		nutehiwt = wts.getNutehiwt();

		optenh = optInfo.getOptenh();
		optenl = optInfo.getOptenl();
		opt0h = optInfo.getOpt0h();
		opt0l = optInfo.getOpt0l();
		opt1h = optInfo.getOpt1h();
		opt1l = optInfo.getOpt1l();
		opt2h = optInfo.getOpt2h();
		opt2l = optInfo.getOpt2l();
		opt3h = optInfo.getOpt3h();
		opt3l = optInfo.getOpt3l();
		opt4h = optInfo.getOpt4h();
		opt4l = optInfo.getOpt4l();
		opt5h = optInfo.getOpt5h();
		opt5l = optInfo.getOpt5l();
		opt6h = optInfo.getOpt6h();
		opt6l = optInfo.getOpt6l();
		opt7h = optInfo.getOpt7h();
		opt7l = optInfo.getOpt7l();
		opt8h = optInfo.getOpt8h();
		opt8l = optInfo.getOpt8l();
		opt9h = optInfo.getOpt9h();
		opt9l = optInfo.getOpt9l();
		optah = optInfo.getOptah();
		optal = optInfo.getOptal();
		optbh = optInfo.getOptbh();
		optbl = optInfo.getOptbl();
		optch = optInfo.getOptch();
		optcl = optInfo.getOptcl();
		optdh = optInfo.getOptdh();
		optdl = optInfo.getOptdl();
		opteh = optInfo.getOpteh();
		optel = optInfo.getOptel();
		
		 apt0h = optInfo.getApt0h();								
		 apt0l = optInfo.getApt0l();								
		 apt1h = optInfo.getApt1h();								
		 apt1l = optInfo.getApt1l();								
		 apt2h = optInfo.getApt2h();								
		 apt2l = optInfo.getApt2l();								
		 apt3h = optInfo.getApt3h();								
		 apt3l = optInfo.getApt3l();								
		 apt4h = optInfo.getApt4h();								
		 apt4l = optInfo.getApt4l();								
		 apt5h = optInfo.getApt5h();								
		 apt5l = optInfo.getApt5l();								
		 apt6h = optInfo.getApt6h();								
		 apt6l = optInfo.getApt6l();								
		 apt7h = optInfo.getApt7h();								
		 apt7l = optInfo.getApt7l();								
		 apt8h = optInfo.getApt8h();								
		 apt8l = optInfo.getApt8l();								
		 apt9h = optInfo.getApt9h();								
		 apt9l = optInfo.getApt9l();								
		 aptah = optInfo.getAptah();								
		 aptal = optInfo.getAptal();								
		 aptbh = optInfo.getAptbh();								
		 aptbl = optInfo.getAptbl();								
		 aptch = optInfo.getAptch();								
		 aptcl = optInfo.getAptcl();								
		 aptdh = optInfo.getAptdh();								
		 aptdl = optInfo.getAptdl();								
		 apteh = optInfo.getApteh();								
		 aptel = optInfo.getAptel();
		 
		 exclude = user.getExclude();
		 fraction =  mealcombos.getCurrentFraction();

	}

	private void updateTargets() {
		double currentFraction = mealcombos.getCurrentFraction();
		endayTarget = adequacy.getEndayTarget();

		adequacy.setEnTarget(Math.round(endayTarget * currentFraction));
		adequacy.setNut0Target(Math.round(adequacy.getNut0dayTarget()
				* currentFraction));
		adequacy.setNut1Target(Math.round(adequacy.getNut1dayTarget()
				* currentFraction));
		adequacy.setNut2Target(Math.round(adequacy.getNut2dayTarget()
				* currentFraction));
		adequacy.setNut3Target(Math.round(adequacy.getNut3dayTarget()
				* currentFraction));
		adequacy.setNut4Target(Math.round(adequacy.getNut4dayTarget()
				* currentFraction));
		adequacy.setNut5Target(Math.round(adequacy.getNut5dayTarget()
				* currentFraction));
		adequacy.setNut6Target(Math.round(adequacy.getNut6dayTarget()
				* currentFraction));
		adequacy.setNut7Target(Math.round(adequacy.getNut7dayTarget()
				* currentFraction));
		adequacy.setNut8Target(Math.round(adequacy.getNut8dayTarget()
				* currentFraction));
		adequacy.setNut9Target(Math.round(adequacy.getNut9dayTarget()
				* currentFraction));
		adequacy.setNutaTarget(Math.round(adequacy.getNutadayTarget()
				* currentFraction));
		adequacy.setNutbTarget(Math.round(adequacy.getNutbdayTarget()
				* currentFraction));
		adequacy.setNutcTarget(Math.round(adequacy.getNutcdayTarget()
				* currentFraction));
		adequacy.setNutdTarget(Math.round(adequacy.getNutddayTarget()
				* currentFraction));
		adequacy.setNuteTarget(Math.round(adequacy.getNutedayTarget()
				* currentFraction));
	}

	public double getMaxdiff1() {
		return maxdiff1;
	}

	public double getMaxdiff2() {
		return maxdiff2;
	}

	public double getMaxdiff3() {
		return maxdiff3;
	}

	public double getEnlowMult() {
		return enlowMult;
	}

	public double getEnhighMult() {
		return enhighMult;
	}

	public double getEnUL() {
		return enUL;
	}

	public double getNut0UL() {
		return nut0UL;
	}

	public double getNut1UL() {
		return nut1UL;
	}

	public double getNut2UL() {
		return nut2UL;
	}

	public double getNut3UL() {
		return nut3UL;
	}

	public double getNut4UL() {
		return nut4UL;
	}

	public double getNut5UL() {
		return nut5UL;
	}

	public double getNut6UL() {
		return nut6UL;
	}

	public double getNut7UL() {
		return nut7UL;
	}

	public double getNut8UL() {
		return nut8UL;
	}

	public double getNut9UL() {
		return nut9UL;
	}

	public double getNutaUL() {
		return nutaUL;
	}

	public double getNutbUL() {
		return nutbUL;
	}

	public double getNutcUL() {
		return nutcUL;
	}

	public double getNutdUL() {
		return nutdUL;
	}

	public double getNuteUL() {
		return nuteUL;
	}

	public double getNut0Target() {
		return nut0Target;
	}

	public double getNut1Target() {
		return nut1Target;
	}

	public double getNut2Target() {
		return nut2Target;
	}

	public double getNut3Target() {
		return nut3Target;
	}

	public double getNut4Target() {
		return nut4Target;
	}

	public double getNut5Target() {
		return nut5Target;
	}

	public double getNut6Target() {
		return nut6Target;
	}

	public double getNut7Target() {
		return nut7Target;
	}

	public double getNut8Target() {
		return nut8Target;
	}

	public double getNut9Target() {
		return nut9Target;
	}

	public double getNutaTarget() {
		return nutaTarget;
	}

	public double getNutbTarget() {
		return nutbTarget;
	}

	public double getNutcTarget() {
		return nutcTarget;
	}

	public double getNutdTarget() {
		return nutdTarget;
	}

	public double getNuteTarget() {
		return nuteTarget;
	}

	public double getEndayTarget() {
		return endayTarget;
	}

	public double getNut0dayTarget() {
		return nut0dayTarget;
	}

	public double getNut1dayTarget() {
		return nut1dayTarget;
	}

	public double getNut2dayTarget() {
		return nut2dayTarget;
	}

	public double getNut3dayTarget() {
		return nut3dayTarget;
	}

	public double getNut4dayTarget() {
		return nut4dayTarget;
	}

	public double getNut5dayTarget() {
		return nut5dayTarget;
	}

	public double getNut6dayTarget() {
		return nut6dayTarget;
	}

	public double getNut7dayTarget() {
		return nut7dayTarget;
	}

	public double getNut8dayTarget() {
		return nut8dayTarget;
	}

	public double getNut9dayTarget() {
		return nut9dayTarget;
	}

	public double getNutadayTarget() {
		return nutadayTarget;
	}

	public double getNutbdayTarget() {
		return nutbdayTarget;
	}

	public double getNutcdayTarget() {
		return nutcdayTarget;
	}

	public double getNutddayTarget() {
		return nutddayTarget;
	}

	public double getNutedayTarget() {
		return nutedayTarget;
	}

	public double getEnlowt() {
		return enlowt;
	}

	public double getEnhiwt() {
		return enhiwt;
	}

	public double getNut0lowt() {
		return nut0lowt;
	}

	public double getNut0hiwt() {
		return nut0hiwt;
	}

	public double getNut1lowt() {
		return nut1lowt;
	}

	public double getNut1hiwt() {
		return nut1hiwt;
	}

	public double getNut2lowt() {
		return nut2lowt;
	}

	public double getNut2hiwt() {
		return nut2hiwt;
	}

	public double getNut3lowt() {
		return nut3lowt;
	}

	public double getNut3hiwt() {
		return nut3hiwt;
	}

	public double getNut4lowt() {
		return nut4lowt;
	}

	public double getNut4hiwt() {
		return nut4hiwt;
	}

	public double getNut5lowt() {
		return nut5lowt;
	}

	public double getNut5hiwt() {
		return nut5hiwt;
	}

	public double getNut6lowt() {
		return nut6lowt;
	}

	public double getNut6hiwt() {
		return nut6hiwt;
	}

	public double getNut7lowt() {
		return nut7lowt;
	}

	public double getNut7hiwt() {
		return nut7hiwt;
	}

	public double getNut8lowt() {
		return nut8lowt;
	}

	public double getNut8hiwt() {
		return nut8hiwt;
	}

	public double getNut9lowt() {
		return nut9lowt;
	}

	public double getNut9hiwt() {
		return nut9hiwt;
	}

	public double getNutalowt() {
		return nutalowt;
	}

	public double getNutahiwt() {
		return nutahiwt;
	}

	public double getNutblowt() {
		return nutblowt;
	}

	public double getNutbhiwt() {
		return nutbhiwt;
	}

	public double getNutclowt() {
		return nutclowt;
	}

	public double getNutchiwt() {
		return nutchiwt;
	}

	public double getNutdlowt() {
		return nutdlowt;
	}

	public double getNutdhiwt() {
		return nutdhiwt;
	}

	public double getNutelowt() {
		return nutelowt;
	}

	public double getNutehiwt() {
		return nutehiwt;
	}

	public int getOptenh() {
		return optenh;
	}

	public int getOptenl() {
		return optenl;
	}

	public int getOpt0h() {
		return opt0h;
	}

	public int getOpt0l() {
		return opt0l;
	}

	public int getOpt1h() {
		return opt1h;
	}

	public int getOpt1l() {
		return opt1l;
	}

	public int getOpt2h() {
		return opt2h;
	}

	public int getOpt2l() {
		return opt2l;
	}

	public int getOpt3h() {
		return opt3h;
	}

	public int getOpt3l() {
		return opt3l;
	}

	public int getOpt4h() {
		return opt4h;
	}

	public int getOpt4l() {
		return opt4l;
	}

	public int getOpt5h() {
		return opt5h;
	}

	public int getOpt5l() {
		return opt5l;
	}

	public int getOpt6h() {
		return opt6h;
	}

	public int getOpt6l() {
		return opt6l;
	}

	public int getOpt7h() {
		return opt7h;
	}

	public int getOpt7l() {
		return opt7l;
	}

	public int getOpt8h() {
		return opt8h;
	}

	public int getOpt8l() {
		return opt8l;
	}

	public int getOpt9h() {
		return opt9h;
	}

	public int getOpt9l() {
		return opt9l;
	}

	public int getOptah() {
		return optah;
	}

	public int getOptal() {
		return optal;
	}

	public int getOptbh() {
		return optbh;
	}

	public int getOptbl() {
		return optbl;
	}

	public int getOptch() {
		return optch;
	}

	public int getOptcl() {
		return optcl;
	}

	public int getOptdh() {
		return optdh;
	}

	public int getOptdl() {
		return optdl;
	}

	public int getOpteh() {
		return opteh;
	}

	public int getOptel() {
		return optel;
	}

	public double getApt0h() {
		return apt0h;
	}

	public double getApt0l() {
		return apt0l;
	}

	public double getApt1h() {
		return apt1h;
	}

	public double getApt1l() {
		return apt1l;
	}

	public double getApt2h() {
		return apt2h;
	}

	public double getApt2l() {
		return apt2l;
	}

	public double getApt3h() {
		return apt3h;
	}

	public double getApt3l() {
		return apt3l;
	}

	public double getApt4h() {
		return apt4h;
	}

	public double getApt4l() {
		return apt4l;
	}

	public double getApt5h() {
		return apt5h;
	}

	public double getApt5l() {
		return apt5l;
	}

	public double getApt6h() {
		return apt6h;
	}

	public double getApt6l() {
		return apt6l;
	}

	public double getApt7h() {
		return apt7h;
	}

	public double getApt7l() {
		return apt7l;
	}

	public double getApt8h() {
		return apt8h;
	}

	public double getApt8l() {
		return apt8l;
	}

	public double getApt9h() {
		return apt9h;
	}

	public double getApt9l() {
		return apt9l;
	}

	public double getAptah() {
		return aptah;
	}

	public double getAptal() {
		return aptal;
	}

	public double getAptbh() {
		return aptbh;
	}

	public double getAptbl() {
		return aptbl;
	}

	public double getAptch() {
		return aptch;
	}

	public double getAptcl() {
		return aptcl;
	}

	public double getAptdh() {
		return aptdh;
	}

	public double getAptdl() {
		return aptdl;
	}

	public double getApteh() {
		return apteh;
	}

	public double getAptel() {
		return aptel;
	}

	public int getExclude() {
		return exclude;
	}

	public double getFraction() {
		return fraction;
	}

	public Adequacy getAdequacy() {
		return adequacy;
	}

	public MealCombos getMealcombos() {
		return mealcombos;
	}

	public OptInfo getOptInfo() {
		return optInfo;
	}

	public Wts getWts() {
		return wts;
	}

	public User getUser() {
		return user;
	}

}
