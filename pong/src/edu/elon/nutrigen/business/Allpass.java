package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Allpass implements Serializable {
	private ArrayList<MealComboNutrients> foodcombos; // created by MealCombos
	private ArrayList<MealComboCompare> foods; // initialized in sortitems

	private int[] nrArray;
	private String[] labelArray;
	private int[] excludeArray;

	private int[] enArray;
	private double[] nut0Array;
	private double[] nut1Array;
	private double[] nut2Array;
	private double[] nut3Array;
	private double[] nut4Array;
	private double[] nut5Array;
	private double[] nut6Array;
	private double[] nut7Array;
	private double[] nut8Array;
	private double[] nut9Array;
	private double[] nutaArray;
	private double[] nutbArray;
	private double[] nutcArray;
	private double[] nutdArray;
	private double[] nuteArray;
	private int[] typeArray;
	private int[] type2Array;
	private int[] type3Array;
	private int[] type4Array;
	private int[] type5Array;

	public Allpass() {
		// intentionally empty
	}

	public void loadnrArray(int[] nrArray) {
		this.nrArray = nrArray;
	}

	public void loadlabelArray(String[] labelArray) {
		this.labelArray = labelArray;
	}

	public void loadexcludeArray(int[] excludeArray) {
		this.excludeArray = excludeArray;
	}

	public void loadenArray(int[] enArray) {
		this.enArray = enArray;
	}

	public void loadtypeArray(int[] typeArray) {
		this.typeArray = typeArray;
	}

	public void loadtype2Array(int[] type2Array) {
		this.type2Array = type2Array;
	}

	public void loadtype3Array(int[] type3Array) {
		this.type3Array = type3Array;
	}

	public void loadtype4Array(int[] type4Array) {
		this.type4Array = type4Array;
	}

	public void loadtype5Array(int[] type5Array) {
		this.type5Array = type5Array;
	}

	public void loadnut0Array(double[] nut0Array) {
		this.nut0Array = nut0Array;
	}

	public void loadnut1Array(double[] nut1Array) {
		this.nut1Array = nut1Array;
	}

	public void loadnut2Array(double[] nut2Array) {
		this.nut2Array = nut2Array;
	}

	public void loadnut3Array(double[] nut3Array) {
		this.nut3Array = nut3Array;
	}

	public void loadnut4Array(double[] nut4Array) {
		this.nut4Array = nut4Array;
	}

	public void loadnut5Array(double[] nut5Array) {
		this.nut5Array = nut5Array;
	}

	public void loadnut6Array(double[] nut6Array) {
		this.nut6Array = nut6Array;
	}

	public void loadnut7Array(double[] nut7Array) {
		this.nut7Array = nut7Array;
	}

	public void loadnut8Array(double[] nut8Array) {
		this.nut8Array = nut8Array;
	}

	public void loadnut9Array(double[] nut9Array) {
		this.nut9Array = nut9Array;
	}

	public void loadnutaArray(double[] nutaArray) {
		this.nutaArray = nutaArray;
	}

	public void loadnutbArray(double[] nutbArray) {
		this.nutbArray = nutbArray;
	}

	public void loadnutcArray(double[] nutcArray) {
		this.nutcArray = nutcArray;
	}

	public void loadnutdArray(double[] nutdArray) {
		this.nutdArray = nutdArray;
	}

	public void loadnuteArray(double[] nuteArray) {
		this.nuteArray = nuteArray;
	}

	public void loadfoodcombos(ArrayList<MealComboNutrients> foodcombos) {
		this.foodcombos = foodcombos;
	}

	/*
	 * Side effect of setting foods
	 */
	public ArrayList<MealComboCompare> sortItems(Limit limit) {
		int numItems;
		foods = new ArrayList<MealComboCompare>();
		MealComboCompare temp = new MealComboCompare();
		// double dataSortField:SortField;
		// double numericDataSort:Sort;
		int edititemNr = 0;
		double fraction = limit.getFraction();
		double enlowMult = limit.getEnlowMult();
		double enhighMult = limit.getEnhighMult();
		double maxdiff1 = limit.getMaxdiff1();
		double maxdiff2 = limit.getMaxdiff2();
		double maxdiff3 = limit.getMaxdiff3();
		double trans = 0;
		double diff = 0;

		String foodval = "";
		int nrFood = 0;;
		double enFood = 0;
		double nut0Food = 0;
		double nut1Food = 0;
		double nut2Food = 0;
		double nut3Food = 0;
		double nut4Food = 0;
		double nut5Food = 0;
		double nut6Food = 0;
		double nut7Food = 0;
		double nut8Food = 0;
		double nut9Food = 0;
		double nutaFood = 0;
		double nutbFood = 0;
		double nutcFood = 0;
		double nutdFood = 0;
		double nuteFood = 0;
		double transen = 0;
		double transnut0 = 0;
		double transnut1 = 0;
		double transnut2 = 0;
		double transnut3 = 0;
		double transnut4 = 0;
		double transnut5 = 0;
		double transnut6 = 0;
		double transnut7 = 0;
		double transnut8 = 0;
		double transnut9 = 0;
		double transnuta = 0;
		double transnutb = 0;
		double transnutc = 0;
		double transnutd = 0;
		double transnute = 0;
		double delta;
		double delta2;
		double enTarget;
		double nut0Target;
		double nut1Target;
		double nut2Target;
		double nut3Target;
		double nut4Target;
		double nut5Target;
		double nut6Target;
		double nut7Target;
		double nut8Target;
		double nut9Target;
		double nutaTarget;
		double nutbTarget;
		double nutcTarget;
		double nutdTarget;
		double nuteTarget;
		double endayTarget;
		double enUL;
		double nut0UL;
		double nut1UL;
		double nut2UL;
		double nut3UL;
		double nut4UL;
		double nut5UL;
		double nut6UL;
		double nut7UL;
		double nut8UL;
		double nut9UL;
		double nutaUL;
		double nutbUL;
		double nutcUL;
		double nutdUL;
		double nuteUL;
		double enlowt;
		double enhiwt;
		double nut0lowt;
		double nut0hiwt;
		double nut1lowt;
		double nut1hiwt;
		double nut2lowt;
		double nut2hiwt;
		double nut3lowt;
		double nut3hiwt;
		double nut4lowt;
		double nut4hiwt;
		double nut5lowt;
		double nut5hiwt;
		double nut6lowt;
		double nut6hiwt;
		double nut7lowt;
		double nut7hiwt;
		double nut8lowt;
		double nut8hiwt;
		double nut9lowt;
		double nut9hiwt;
		double nutalowt;
		double nutahiwt;
		double nutblowt;
		double nutbhiwt;
		double nutclowt;
		double nutchiwt;
		double nutdlowt;
		double nutdhiwt;
		double nutelowt;
		double nutehiwt;

		double optenh;
		double opt0h;
		double opt1h;
		double opt2h;
		double opt3h;
		double opt4h;
		double opt5h;
		double opt6h;
		double opt7h;
		double opt8h;
		double opt9h;
		double optah;
		double optbh;
		double optch;
		double optdh;
		double opteh;
		double optenl;
		double opt0l;
		double opt1l;
		double opt2l;
		double opt3l;
		double opt4l;
		double opt5l;
		double opt6l;
		double opt7l;
		double opt8l;
		double opt9l;
		double optal;
		double optbl;
		double optcl;
		double optdl;
		double optel;
		double aptenh;
		double apt0h;
		double apt1h;
		double apt2h;
		double apt3h;
		double apt4h;
		double apt5h;
		double apt6h;
		double apt7h;
		double apt8h;
		double apt9h;
		double aptah;
		double aptbh;
		double aptch;
		double aptdh;
		double apteh;
		double aptenl;
		double apt0l;
		double apt1l;
		double apt2l;
		double apt3l;
		double apt4l;
		double apt5l;
		double apt6l;
		double apt7l;
		double apt8l;
		double apt9l;
		double aptal;
		double aptbl;
		double aptcl;
		double aptdl;
		double aptel;

		int exclude;

		int excludesum = 0;
		int excludedec;

		if (limit.getExclude() == 0) {
			exclude = 1;
		} else {
			exclude = 0;
		}
		enlowt = limit.getEnlowt();
		enhiwt = limit.getEnhiwt();

		nut0lowt = limit.getNut0lowt();
		nut0hiwt = limit.getNut0hiwt();
		nut1lowt = limit.getNut1lowt();
		nut1hiwt = limit.getNut1hiwt();
		nut2lowt = limit.getNut2lowt();
		nut2hiwt = limit.getNut2hiwt();
		nut3lowt = limit.getNut3lowt();
		nut3hiwt = limit.getNut3hiwt();
		nut4lowt = limit.getNut4lowt();
		nut4hiwt = limit.getNut4hiwt();
		nut5lowt = limit.getNut5lowt();
		nut5hiwt = limit.getNut5hiwt();
		nut6lowt = limit.getNut6lowt();
		nut6hiwt = limit.getNut6hiwt();
		nut7lowt = limit.getNut7lowt();
		nut7hiwt = limit.getNut7hiwt();
		nut8lowt = limit.getNut8lowt();
		nut8hiwt = limit.getNut8hiwt();
		nut9lowt = limit.getNut9lowt();
		nut9hiwt = limit.getNut9hiwt();
		nutalowt = limit.getNutalowt();
		nutahiwt = limit.getNutahiwt();
		nutblowt = limit.getNutblowt();
		nutbhiwt = limit.getNutbhiwt();
		nutclowt = limit.getNutclowt();
		nutchiwt = limit.getNutchiwt();
		nutdlowt = limit.getNutdlowt();
		nutdhiwt = limit.getNutdhiwt();
		nutelowt = limit.getNutelowt();
		nutehiwt = limit.getNutehiwt();

		enUL = limit.getEnUL();
		nut0UL = limit.getNut0UL();
		nut1UL = limit.getNut1UL();
		nut2UL = limit.getNut2UL();
		nut3UL = limit.getNut3UL();
		nut4UL = limit.getNut4UL();
		nut5UL = limit.getNut5UL();
		nut6UL = limit.getNut6UL();
		nut7UL = limit.getNut7UL();
		nut8UL = limit.getNut8UL();
		nut9UL = limit.getNut9UL();
		nutaUL = limit.getNutaUL();
		nutbUL = limit.getNutbUL();
		nutcUL = limit.getNutcUL();
		nutdUL = limit.getNutdUL();
		nuteUL = limit.getNuteUL();

		enTarget = limit.getEndayTarget() * fraction;
		nut0Target = limit.getNut0dayTarget() * fraction;
		nut1Target = limit.getNut1dayTarget() * fraction;
		nut2Target = limit.getNut2dayTarget() * fraction;
		nut3Target = limit.getNut3dayTarget() * fraction;
		nut4Target = limit.getNut4dayTarget() * fraction;
		nut5Target = limit.getNut5dayTarget() * fraction;
		nut6Target = limit.getNut6dayTarget() * fraction;
		nut7Target = limit.getNut7dayTarget() * fraction;
		nut8Target = limit.getNut8dayTarget() * fraction;
		nut9Target = limit.getNut9dayTarget() * fraction;
		nutaTarget = limit.getNutadayTarget() * fraction;
		nutbTarget = limit.getNutbdayTarget() * fraction;
		nutcTarget = limit.getNutcdayTarget() * fraction;
		nutdTarget = limit.getNutddayTarget() * fraction;
		nuteTarget = limit.getNutedayTarget() * fraction;

		optenh = limit.getOptenh();
		opt0h = limit.getOpt0h();
		opt1h = limit.getOpt1h();
		opt2h = limit.getOpt2h();
		opt3h = limit.getOpt3h();
		opt4h = limit.getOpt4h();
		opt5h = limit.getOpt5h();
		opt6h = limit.getOpt6h();
		opt7h = limit.getOpt7h();
		opt8h = limit.getOpt8h();
		opt9h = limit.getOpt9h();
		optah = limit.getOptah();
		optbh = limit.getOptbh();
		optch = limit.getOptch();
		optdh = limit.getOptdh();
		opteh = limit.getOpteh();
		optenl = limit.getOptenl();
		opt0l = limit.getOpt0l();
		opt1l = limit.getOpt1l();
		opt2l = limit.getOpt2l();
		opt3l = limit.getOpt3l();
		opt4l = limit.getOpt4l();
		opt5l = limit.getOpt5l();
		opt6l = limit.getOpt6l();
		opt7l = limit.getOpt7l();
		opt8l = limit.getOpt8l();
		opt9l = limit.getOpt9l();
		optal = limit.getOptal();
		optbl = limit.getOptbl();
		optcl = limit.getOptcl();
		optdl = limit.getOptdl();
		optel = limit.getOptel();

		aptenh = 1;
		apt0h = limit.getApt0h();
		apt1h = limit.getApt1h();
		apt2h = limit.getApt2h();
		apt3h = limit.getApt3h();
		apt4h = limit.getApt4h();
		apt5h = limit.getApt5h();
		apt6h = limit.getApt6h();
		apt7h = limit.getApt7h();
		apt8h = limit.getApt8h();
		apt9h = limit.getApt9h();
		aptah = limit.getAptah();
		aptbh = limit.getAptbh();
		aptch = limit.getAptch();
		aptdh = limit.getAptdh();
		apteh = limit.getApteh();
		aptenl = 1;
		apt0l = limit.getApt0l();
		apt1l = limit.getApt1l();
		apt2l = limit.getApt2l();
		apt3l = limit.getApt3l();
		apt4l = limit.getApt4l();
		apt5l = limit.getApt5l();
		apt6l = limit.getApt6l();
		apt7l = limit.getApt7l();
		apt8l = limit.getApt8l();
		apt9l = limit.getApt9l();
		aptal = limit.getAptal();
		aptbl = limit.getAptbl();
		aptcl = limit.getAptcl();
		aptdl = limit.getAptdl();
		aptel = limit.getAptel();

		numItems = foodcombos.size();

		int i;
		int j;
		int k;
		int nr;
		int[] FC;
		String[] foodLabel;
		int comborating;
		for (i = 0; i < numItems; i++) {
			FC = new int[numItems];
			foodLabel = new String[numItems];
			comborating = foodcombos.get(i).getRating();
			FC[0] = foodcombos.get(i).getNrFC();
			FC[1] = foodcombos.get(i).getItem1();
			FC[2] = foodcombos.get(i).getItem2();
			FC[3] = foodcombos.get(i).getItem3();
			FC[4] = foodcombos.get(i).getItem4();
			FC[5] = foodcombos.get(i).getItem5();
			FC[6] = foodcombos.get(i).getItem6();
			FC[7] = foodcombos.get(i).getItem7();
			FC[8] = foodcombos.get(i).getItem8();
			FC[9] = foodcombos.get(i).getItem9();
			FC[10] = foodcombos.get(i).getItem10();
			FC[11] = foodcombos.get(i).getItem11();
			FC[12] = foodcombos.get(i).getItem12();
			FC[13] = foodcombos.get(i).getItem13();
			FC[14] = foodcombos.get(i).getItem14();
			FC[15] = foodcombos.get(i).getItem15();
			FC[16] = foodcombos.get(i).getItem16();
			FC[17] = foodcombos.get(i).getItem17();
			FC[18] = foodcombos.get(i).getItem18();
			FC[19] = foodcombos.get(i).getItem19();
			FC[20] = foodcombos.get(i).getItem20();
			FC[21] = foodcombos.get(i).getItem21();
			foodLabel[1] = "";
			foodLabel[2] = "";
			foodLabel[3] = "";
			foodLabel[4] = "";
			foodLabel[5] = "";
			foodLabel[6] = "";
			foodLabel[7] = "";
			foodLabel[8] = "";
			foodLabel[9] = "";
			foodLabel[10] = "";
			foodLabel[11] = "";
			foodLabel[12] = "";
			foodLabel[13] = "";
			foodLabel[14] = "";
			foodLabel[15] = "";
			foodLabel[16] = "";
			foodLabel[17] = "";
			foodLabel[18] = "";
			foodLabel[19] = "";
			foodLabel[20] = "";
			foodLabel[21] = "";

			nr = FC[1];
			if (nr > 0) {
				if (excludeArray[nr] == 0) {
					excludesum = 1;
				} else {
					excludesum = 0;
				}
				enFood = enArray[nr];
				nut0Food = nut0Array[nr];
				nut1Food = nut1Array[nr];
				nut2Food = nut2Array[nr];
				nut3Food = nut3Array[nr];
				nut4Food = nut4Array[nr];
				nut5Food = nut5Array[nr];
				nut6Food = nut6Array[nr];
				nut7Food = nut7Array[nr];
				nut8Food = nut8Array[nr];
				nut9Food = nut9Array[nr];
				nutaFood = nutaArray[nr];
				nutbFood = nutbArray[nr];
				nutcFood = nutcArray[nr];
				nutdFood = nutdArray[nr];
				nuteFood = nuteArray[nr];
				foodLabel[1] = labelArray[nr];
			}

			for (j = 2; j < 22; j++) {
				if (FC[j] == 0) {
					foodLabel[j] = "";
				}
				nr = FC[j];
				if (nr > 0) {
					foodLabel[j] = labelArray[nr];
					if (excludeArray[nr] == 0) {
						excludesum = excludesum + 1;
					}
					enFood = enFood + enArray[nr];
					nut0Food = nut0Food + nut0Array[nr];
					nut1Food = nut1Food + nut1Array[nr];
					nut2Food = nut2Food + nut2Array[nr];
					nut3Food = nut3Food + nut3Array[nr];
					nut4Food = nut4Food + nut4Array[nr];
					nut5Food = nut5Food + nut5Array[nr];
					nut6Food = nut6Food + nut6Array[nr];
					nut7Food = nut7Food + nut7Array[nr];
					nut8Food = nut8Food + nut8Array[nr];
					nut9Food = nut9Food + nut9Array[nr];
					nutaFood = nutaFood + nutaArray[nr];
					nutbFood = nutbFood + nutbArray[nr];
					nutcFood = nutcFood + nutcArray[nr];
					nutdFood = nutdFood + nutdArray[nr];
					nuteFood = nuteFood + nuteArray[nr];
				}
			}
			if (excludesum == 0) {
				excludedec = 0;
			} else {
				excludedec = 1;
			}
			int dltmax = 0;
			// process values
			// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			if ((enFood > enlowMult * enTarget)
					&& (enFood < enhighMult * enTarget)
					&& (excludedec == exclude)) {
				if (enFood > enTarget) {
					diff = (aptenh * ((enFood - enTarget) / (enUL - enTarget)));
					transen = Math.pow(diff, optenh) * enhiwt;
				}
				if (enFood < enTarget) {
					diff = (aptenl * (1 - (enFood / enTarget)));
					transen = Math.pow(diff, optenl) * enlowt;
				}
				if (enFood == enTarget) {
					transen = 0;
				}

				if (nut0Food > nut0Target) {
					diff = (apt0h * ((nut0Food - nut0Target) / (nut0UL - nut0Target)));
					transnut0 = Math.pow(diff, opt0h) * nut0hiwt;
				}
				if (nut0Food < nut0Target) {
					diff = (apt0l * (1 - (nut0Food / nut0Target)));
					transnut0 = Math.pow(diff, opt0l) * nut0lowt;
				}
				if (nut0Food == nut0Target) {
					transnut0 = 0;
				}

				if (nut1Food > nut1Target) {
					diff = (apt1h * ((nut1Food - nut1Target) / (nut1UL - nut1Target)));
					transnut1 = Math.pow(diff, opt1h) * nut1hiwt;
				}
				if (nut1Food < nut1Target) {
					diff = (apt1l * (1 - (nut1Food / nut1Target)));
					transnut1 = Math.pow(diff, opt1l) * nut1lowt;
				}
				if (nut1Food == nut1Target) {
					transnut1 = 0;
				}

				if (nut2Food > nut2Target) {
					diff = (apt2h * ((nut2Food - nut2Target) / (nut2UL - nut2Target)));
					transnut2 = Math.pow(diff, opt2h) * nut2hiwt;
				}
				if (nut2Food < nut2Target) {
					diff = (apt2l * (1 - (nut2Food / nut2Target)));
					transnut2 = Math.pow(diff, opt2l) * nut2lowt;
				}
				if (nut2Food == nut2Target) {
					transnut2 = 0;
				}

				if (nut3Food > nut3Target) {
					diff = (apt3h * ((nut3Food - nut3Target) / (nut3UL - nut3Target)));
					transnut3 = Math.pow(diff, opt3h) * nut3hiwt;
				}
				if (nut3Food < nut3Target) {
					diff = (apt3l * (1 - (nut3Food / nut3Target)));
					transnut3 = Math.pow(diff, opt3l) * nut3lowt;
				}
				if (nut3Food == nut3Target) {
					transnut3 = 0;
				}

				if (nut4Food > nut4Target) {
					diff = (apt4h * ((nut4Food - nut4Target) / (nut4UL - nut4Target)));
					transnut4 = Math.pow(diff, opt4h) * nut4hiwt;
				}
				if (nut4Food < nut4Target) {
					diff = (apt4l * (1 - (nut4Food / nut4Target)));
					transnut4 = Math.pow(diff, opt4l) * nut4lowt;
				}
				if (nut4Food == nut4Target) {
					transnut4 = 0;
				}

				if (nut5Food > nut5Target) {
					diff = (apt5h * ((nut5Food - nut5Target) / (nut5UL - nut5Target)));
					transnut5 = Math.pow(diff, opt5h) * nut5hiwt;
				}
				if (nut5Food < nut5Target) {
					diff = (apt5l * (1 - (nut5Food / nut5Target)));
					transnut5 = Math.pow(diff, opt5l) * nut5lowt;
				}
				if (nut5Food == nut5Target) {
					transnut5 = 0;
				}

				if (nut6Food > nut6Target) {
					diff = (apt6h * ((nut6Food - nut6Target) / (nut6UL - nut6Target)));
					transnut6 = Math.pow(diff, opt6h) * nut6hiwt;
				}
				if (nut6Food < nut6Target) {
					diff = (apt6l * (1 - (nut6Food / nut6Target)));
					transnut6 = Math.pow(diff, opt6l) * nut6lowt;
				}
				if (nut6Food == nut6Target) {
					transnut6 = 0;
				}

				if (nut7Food > nut7Target) {
					diff = (apt7h * ((nut7Food - nut7Target) / (nut7UL - nut7Target)));
					transnut7 = Math.pow(diff, opt7h) * nut7hiwt;
				}
				if (nut7Food < nut7Target) {
					diff = (apt7l * (1 - (nut7Food / nut7Target)));
					transnut7 = Math.pow(diff, opt7l) * nut7lowt;
				}
				if (nut7Food == nut7Target) {
					transnut7 = 0;
				}

				if (nut8Food > nut8Target) {
					diff = (apt8h * ((nut8Food - nut8Target) / (nut8UL - nut8Target)));
					transnut8 = Math.pow(diff, opt8h) * nut8hiwt;
				}
				if (nut8Food < nut8Target) {
					diff = (apt8l * (1 - (nut8Food / nut8Target)));
					transnut8 = Math.pow(diff, opt8l) * nut8lowt;
				}
				if (nut8Food == nut8Target) {
					transnut8 = 0;
				}

				if (nut9Food > nut9Target) {
					diff = (apt9h * ((nut9Food - nut9Target) / (nut9UL - nut9Target)));
					transnut9 = Math.pow(diff, opt9h) * nut9hiwt;
				}
				if (nut9Food < nut9Target) {
					diff = (apt9l * (1 - (nut9Food / nut9Target)));
					transnut9 = Math.pow(diff, opt9l) * nut9lowt;
				}
				if (nut9Food == nut9Target) {
					transnut9 = 0;
				}

				if (nutaFood > nutaTarget) {
					diff = (aptah * ((nutaFood - nutaTarget) / (nutaUL - nutaTarget)));
					transnuta = Math.pow(diff, optah) * nutahiwt;
				}
				if (nutaFood < nutaTarget) {
					diff = (aptal * (1 - (nutaFood / nutaTarget)));
					transnuta = Math.pow(diff, optal) * nutalowt;
				}
				if (nutaFood == nutaTarget) {
					transnuta = 0;
				}

				if (nutbFood > nutbTarget) {
					diff = (aptbh * ((nutbFood - nutbTarget) / (nutbUL - nutbTarget)));
					transnutb = Math.pow(diff, optbh) * nutbhiwt;
				}
				if (nutbFood < nutbTarget) {
					diff = (aptbl * (1 - (nutbFood / nutbTarget)));
					transnutb = Math.pow(diff, optbl) * nutblowt;
				}
				if (nutbFood == nutbTarget) {
					transnutb = 0;
				}

				if (nutcFood > nutcTarget) {
					diff = (aptch * ((nutcFood - nutcTarget) / (nutcUL - nutcTarget)));
					transnutc = Math.pow(diff, optch) * nutchiwt;
				}
				if (nutcFood < nutcTarget) {
					diff = (aptcl * (1 - (nutcFood / nutcTarget)));
					transnutc = Math.pow(diff, optcl) * nutclowt;
				}
				if (nutcFood == nutcTarget) {
					transnutc = 0;
				}

				if (nutdFood > nutdTarget) {
					diff = (aptdh * ((nutdFood - nutdTarget) / (nutdUL - nutdTarget)));
					transnutd = Math.pow(diff, optdh) * nutdhiwt;
				}
				if (nutdFood < nutdTarget) {
					diff = (aptdl * (1 - (nutdFood / nutdTarget)));
					transnutd = Math.pow(diff, optdl) * nutdlowt;
				}
				if (nutdFood == nutdTarget) {
					transnutd = 0;
				}

				if (nuteFood > nuteTarget) {
					diff = (apteh * ((nuteFood - nuteTarget) / (nuteUL - nuteTarget)));
					transnute = Math.pow(diff, opteh) * nutehiwt;
				}
				if (nuteFood < nuteTarget) {
					diff = (aptel * (1 - (nuteFood / nuteTarget)));
					transnute = Math.pow(diff, optel) * nutelowt;
				}
				if (nuteFood == nuteTarget) {
					transnute = 0;
				}

				delta = transen + transnut0 + transnut1 + transnut2 + transnut3
						+ transnut4 + transnut5 + transnut6 + transnut7
						+ transnut8 + transnut9 + transnuta + transnutb
						+ transnutc + transnutd + transnute;
				delta = delta * 10000;
				delta2 = Math.round(delta);
				 
				if (delta < maxdiff1) {
					foodval = "best";
				}
				if (delta >= maxdiff1 && delta < maxdiff2) {
					foodval = "good";
				}
				if (delta >= maxdiff2 && delta < maxdiff3) {
					foodval = "least";
				}

				if (delta < maxdiff3) {
					temp = new MealComboCompare();

					for (k = 1; k < 22; k++) {
						if (foodLabel[k].equals("0")) {
							foodLabel[k] = "";
						}
					}

					temp.setLabel1(foodLabel[1]);
					temp.setLabel2(foodLabel[2]);
					temp.setLabel3(foodLabel[3]);
					temp.setLabel4(foodLabel[4]);
					temp.setLabel5(foodLabel[5]);
					temp.setLabel6(foodLabel[6]);
					temp.setLabel7(foodLabel[7]);
					temp.setLabel8(foodLabel[8]);
					temp.setLabel9(foodLabel[9]);
					temp.setLabel10(foodLabel[10]);
					temp.setLabel11(foodLabel[11]);
					temp.setLabel12(foodLabel[12]);
					temp.setLabel13(foodLabel[13]);
					temp.setLabel14(foodLabel[14]);
					temp.setLabel15(foodLabel[15]);
					temp.setLabel16(foodLabel[16]);
					temp.setLabel17(foodLabel[17]);
					temp.setLabel18(foodLabel[18]);
					temp.setLabel19(foodLabel[19]);
					temp.setLabel20(foodLabel[20]);
					temp.setLabel21(foodLabel[21]);

					temp.setRating(comborating);
					temp.setNr(FC[0]);
					temp.setItem1(FC[1]);
					temp.setItem2(FC[2]);
					temp.setItem3(FC[3]);
					temp.setItem4(FC[4]);
					temp.setItem5(FC[5]);
					temp.setItem6(FC[6]);
					temp.setItem7(FC[7]);
					temp.setItem8(FC[8]);
					temp.setItem9(FC[9]);
					temp.setItem10(FC[10]);
					temp.setItem11(FC[11]);
					temp.setItem12(FC[12]);
					temp.setItem13(FC[13]);
					temp.setItem14(FC[14]);
					temp.setItem15(FC[15]);
					temp.setItem16(FC[16]);
					temp.setItem17(FC[17]);
					temp.setItem18(FC[18]);
					temp.setItem19(FC[19]);
					temp.setItem20(FC[20]);
					temp.setItem21(FC[21]);

					temp.setEn(enFood);
					temp.setNut0(nut0Food);
					temp.setNut1(nut1Food);
					temp.setNut2(nut2Food);
					temp.setNut3(nut3Food);
					temp.setNut4(nut4Food);
					temp.setNut5(nut5Food);
					temp.setNut6(nut6Food);
					temp.setNut7(nut7Food);
					temp.setNut8(nut8Food);
					temp.setNut9(nut9Food);
					temp.setNuta(nutaFood);
					temp.setNutb(nutbFood);
					temp.setNutc(nutcFood);
					temp.setNutd(nutdFood);
					temp.setNute(nuteFood);

					temp.setDlt(delta2);
					temp.setVal(foodval);
					temp.setDltmax(dltmax);

					temp.setTypefits(false);
					// add item only if it is a good fit, exclude based on
					// criteria
				
					foods.add(temp);
				}
			}
		}
		Collections.sort(foods);
		return foods;
	}

	public ArrayList<MealComboNutrients> getFoodcombos() {
		return foodcombos;
	}

	public void setFoodcombos(ArrayList<MealComboNutrients> foodcombos) {
		this.foodcombos = foodcombos;
	}

	public ArrayList<MealComboCompare> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<MealComboCompare> foods) {
		this.foods = foods;
	}

}
