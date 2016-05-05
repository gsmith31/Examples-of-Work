package edu.elon.nutrigen.business;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

/**
 * PONG has many dates. This class tries to consolidate them into on location.
 * 
 * TODO - create accessors for dates that need to be accessed. I did not create all accessors
 * yet as some may be used by only GUIs that are being rewritten
 * 
 * @author dpowell2
 *
 */
public class DateManager implements Serializable {
	private static final int BASE_YEAR = 1900;
	private String yesterday;
	private String yester;
	private String today;
	private long referenceday;
	private Date next1Date;
	private Date next2Date;
	private Date next3Date;
	private Date next4Date;
	private Date next5Date;
	private Date next6Date;
	private Date next7Date;
	private Date next8Date;
	private Date prev1Date;
	private Date prev2Date;
	private Date prev3Date;
	private Date prev4Date;
	private Date prev5Date;
	private Date prev6Date;
	private Date prev7Date;
	private Date prev8Date;
	private int archiveday;
	private int archivepage;
	private String todayplus0;
	private String todayplus1;
	private String todayplus2;
	private String todayplus3;
	private String todayplus4;
	private String todayplus5;
	private String todayplus6;
	private String todayplus7;
	private String todayplus8;
	private int menudays;
	private int useddays;
	private Date now;
	private Date startDate;
	private Date todaysDate;

	private String[] weekdayArray = new String[9];
	private String[] selectdayArray = new String[9];
	private int selectedday;

	private String yesterweekday;
	private String yd;
	private String yesterwd;
	private String toweekday;
	private String[] shortweekdayArray = { "Su", "Mo", "Tu", "We", "Th", "Fr",
			"Sa", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };
	private String[] longweekdayArray = { "Sunday", "Monday", "Tuesday",
			"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday",
			"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	public DateManager() {
		now = new Date();
		startDate = new Date(2010 - 1900, 6, 1, 0, 0, 0);
		todaysDate = new Date();
		initDates();
	}

	public void initDates() {
		archiveday = 8;
		archivepage = 1;
		selectedday = 2;

		if (now.getDay() > 0) {
			yesterweekday = longweekdayArray[now.getDay() - 1];
			yesterwd = shortweekdayArray[now.getDay() - 1];
		}
		if (now.getDay() == 0) {
			yesterweekday = longweekdayArray[6];
			yesterwd = shortweekdayArray[6];
		}
		if (now.getDay() > 1) {
			yd = "" + (now.getMonth() + 1) + "/" + (now.getDate() - 1) + "/"
					+ (now.getYear()+ BASE_YEAR);
			yesterday = yesterweekday + ", " + yd;
			yester = yesterwd + ": " + yd;
		}
		if (now.getDate() == 1) {
			if (now.getMonth() + 1 == 1) {
				yd = "12/31" +  "/"
						+ (now.getYear() + BASE_YEAR - 1);
				yesterday = yesterweekday + ", " + yd;
				yester = yesterwd + ": " + yd;
			}
			if (now.getMonth() + 1 == 3) {
				yd = "" + (now.getMonth()) + "/28" +  "/"
						+ (now.getYear() + BASE_YEAR);
				yesterday = yesterweekday + ", " + yd;
				yester = yesterwd + ": " + yd;
			}
			if (now.getMonth() + 1 == 3 && (now.getYear() + BASE_YEAR) == 2012) {
				yd = "" + (now.getMonth()) + "/29" +  "/"
						+ (now.getYear());
				yesterday = yesterweekday + ", " + yd;
				yester = yesterwd + ": " + yd;
			}
			if (now.getMonth() + 1 == 3 && (now.getYear() + BASE_YEAR) == 2016) {
				yd = "" + now.getMonth() + "/29" +  "/"
						+ now.getYear() + BASE_YEAR;
				yesterday = yesterweekday + ", " + yd;
				yester = yesterwd + ": " + yd;
			}
			if (now.getMonth() + 1 == 5 || now.getMonth() + 1 == 7
					|| now.getMonth() + 1 == 10 || now.getMonth() + 1 == 12) {
				yd = "" + (now.getMonth()) + "/30" +  "/"
						+ (now.getYear() + BASE_YEAR);
				yesterday = yesterweekday + ", " + yd;
				yester = yesterwd + ": " + yd;
			}
			if (now.getMonth() + 1 == 2 || now.getMonth() + 1 == 4
					|| now.getMonth() + 1 == 6 || now.getMonth() + 1 == 8
					|| now.getMonth() + 1 == 9 || now.getMonth() + 1 == 11) {
				yd = "" + now.getMonth() + "/31" +  "/"
						+ (now.getYear() + BASE_YEAR);
				yesterday = yesterweekday + ", " + yd;
				yester = yesterwd + ": " + yd;
			}
		}

		today = "" + longweekdayArray[now.getDay()] + ", "
				+ (now.getMonth() + 1) + "/" + now.getDate() + "/"
				+ (now.getYear() + BASE_YEAR);

		todayplus0 = "" + shortweekdayArray[now.getDay()] + ", "
				+ (now.getMonth() + 1) + "/" + (now.getDate());

		referenceday = Math
				.round(((todaysDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24)) + 0.5);
		
		next1Date = new Date(todaysDate.getTime() + (1 * 1000 * 60 * 60 * 24));
		next2Date = new Date(todaysDate.getTime() + (2 * 1000 * 60 * 60 * 24));
		next3Date = new Date(todaysDate.getTime() + (3 * 1000 * 60 * 60 * 24));
		next4Date = new Date(todaysDate.getTime() + (4 * 1000 * 60 * 60 * 24));
		next5Date = new Date(todaysDate.getTime() + (5 * 1000 * 60 * 60 * 24));
		next6Date = new Date(todaysDate.getTime() + (6 * 1000 * 60 * 60 * 24));
		next7Date = new Date(todaysDate.getTime() + (7 * 1000 * 60 * 60 * 24));
		next8Date = new Date(todaysDate.getTime() + (8 * 1000 * 60 * 60 * 24));

		weekdayArray[0] = "unassigned";
		weekdayArray[1] = longweekdayArray[todaysDate.getDay()];
		weekdayArray[2] = longweekdayArray[next1Date.getDay()];
		weekdayArray[3] = longweekdayArray[next2Date.getDay()];
		weekdayArray[4] = longweekdayArray[next3Date.getDay()];
		weekdayArray[5] = longweekdayArray[next4Date.getDay()];
		weekdayArray[6] = longweekdayArray[next5Date.getDay()];
		weekdayArray[7] = longweekdayArray[next6Date.getDay()];
		weekdayArray[8] = longweekdayArray[next7Date.getDay()];

		selectdayArray[0] = "don't assign";
		selectdayArray[1] = longweekdayArray[todaysDate.getDay()] + ", today";
		selectdayArray[2] = longweekdayArray[next1Date.getDay()] + ", tomorrow";
		selectdayArray[3] = longweekdayArray[next2Date.getDay()];
		selectdayArray[4] = longweekdayArray[next3Date.getDay()];
		selectdayArray[5] = longweekdayArray[next4Date.getDay()];
		selectdayArray[6] = longweekdayArray[next5Date.getDay()];
		selectdayArray[7] = longweekdayArray[next6Date.getDay()];
		selectdayArray[8] = longweekdayArray[next7Date.getDay()]
				+ ", a week from today";

		prev1Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) - 6) * 1000 * 60 * 60 * 24));
		prev2Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) - 5) * 1000 * 60 * 60 * 24));
		prev3Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) - 4) * 1000 * 60 * 60 * 24));
		prev4Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) - 3) * 1000 * 60 * 60 * 24));
		prev5Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) - 2) * 1000 * 60 * 60 * 24));
		prev6Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) - 1) * 1000 * 60 * 60 * 24));
		Date prev7Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) + 0) * 1000 * 60 * 60 * 24));
		Date prev8Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) + 1) * 1000 * 60 * 60 * 24));
		Date prev9Date = new Date(todaysDate.getTime()
				- (((7 * archivepage) + 2) * 1000 * 60 * 60 * 24));

		

		todayplus1 = shortweekdayArray[next1Date.getDay()] + ", "
				+ (next1Date.getMonth() + 1) + "/" + (next1Date.getDate());
		todayplus2 = shortweekdayArray[next2Date.getDay()] + ", "
				+ (next2Date.getMonth() + 1) + "/" + (next2Date.getDate());
		todayplus3 = shortweekdayArray[next3Date.getDay()] + ", "
				+ (next3Date.getMonth() + 1) + "/" + (next3Date.getDate());
		todayplus4 = shortweekdayArray[next4Date.getDay()] + ", "
				+ (next4Date.getMonth() + 1) + "/" + (next4Date.getDate());
		todayplus5 = shortweekdayArray[next5Date.getDay()] + ", "
				+ (next5Date.getMonth() + 1) + "/" + (next5Date.getDate());
		todayplus6 = shortweekdayArray[next6Date.getDay()] + ", "
				+ (next6Date.getMonth() + 1) + "/" + (next6Date.getDate());
		todayplus7 = shortweekdayArray[next7Date.getDay()] + ", "
				+ (next7Date.getMonth() + 1) + "/" + (next7Date.getDate());
		todayplus8 = shortweekdayArray[next8Date.getDay()] + ", "
				+ (next8Date.getMonth() + 1) + "/" + (next8Date.getDate());

	}

	public long getReferenceday() {
		return referenceday;
	}

	public void setReferenceday(long referenceday) {
		this.referenceday = referenceday;
	}

	public int getSelectedday() {
		return selectedday;
	}

	public void setSelectedday(int selectedday) {
		this.selectedday = selectedday;
	}

	@Override
	public String toString() {
		return "DateManager [yesterday=" + yesterday + ", yester=" + yester
				+ ", today=" + today + ", referenceday=" + referenceday
				+ ", next1Date=" + next1Date + ", next2Date=" + next2Date
				+ ", next3Date=" + next3Date + ", next4Date=" + next4Date
				+ ", next5Date=" + next5Date + ", next6Date=" + next6Date
				+ ", next7Date=" + next7Date + ", next8Date=" + next8Date
				+ ", prev1Date=" + prev1Date + ", prev2Date=" + prev2Date
				+ ", prev3Date=" + prev3Date + ", prev4Date=" + prev4Date
				+ ", prev5Date=" + prev5Date + ", prev6Date=" + prev6Date
				+ ", prev7Date=" + prev7Date + ", prev8Date=" + prev8Date
				+ ", archiveday=" + archiveday + ", archivepage=" + archivepage
				+ ", todayplus0=" + todayplus0 + ", todayplus1=" + todayplus1
				+ ", todayplus2=" + todayplus2 + ", todayplus3=" + todayplus3
				+ ", todayplus4=" + todayplus4 + ", todayplus5=" + todayplus5
				+ ", todayplus6=" + todayplus6 + ", todayplus7=" + todayplus7
				+ ", todayplus8=" + todayplus8 + ", menudays=" + menudays
				+ ", useddays=" + useddays + ", now=" + now + ", startDate="
				+ startDate + ", todaysDate=" + todaysDate + ", weekdayArray="
				+ Arrays.toString(weekdayArray) + ", selectdayArray="
				+ Arrays.toString(selectdayArray) + ", selectedday="
				+ selectedday + ", yesterweekday=" + yesterweekday + ", yd="
				+ yd + ", yesterwd=" + yesterwd + ", toweekday=" + toweekday
				+ ", shortweekdayArray=" + Arrays.toString(shortweekdayArray)
				+ ", longweekdayArray=" + Arrays.toString(longweekdayArray)
				+ "]";
	}
	
	/**
	 * Nutrigen deals with a reference day which is the number of days from June 1, 2010. This method
	 * accepts a Date and returns the corresponding reference day
	 * 
	 * @param aDate date to calculate reference day for
	 */
	public int getReferenceDay(Date aDate) {
		long referenceDay = Math
				.round(((aDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24)) + 0.5);
		return (int) referenceDay;	
	}
	
	/**
	 * Given a date, returns the reference day for the first day of the month.
	 * 
	 * @param aDate date for which user wants the first day of month
	 * @return int reference day of the month
	 */
	public int getFirstDayOfMonthRefDay(Date aDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfMonth = calendar.getTime();
		return getReferenceDay(firstDayOfMonth);
	}
	
	/**
	 * Given a date, returns the reference day for the last day of the month.
	 * 
	 * @param aDate date for which user wants the last day of month
	 * @return int reference day of the month
	 */
	public int getLastDayOfMonthRefDay(Date aDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		Date lastDayOfMonth = calendar.getTime();
		return getReferenceDay(lastDayOfMonth);
	}
	
	public Date getDateFromReferenceDay(int day) {
		Date startDate = new Date(2010 - 1900, 6, 1, 0, 0, 0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DATE, day - 1);
		Date date = calendar.getTime();
		return date;
	}

}
