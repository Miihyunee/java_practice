package ch12;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR));// 12 Hours
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));// 24 Hours
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		System.out.println(cal.get(Calendar.AM_PM));
		if (cal.get(Calendar.AM_PM) == 0) {
			System.out.println("am");
		} else {
			System.out.println("pm");
		}
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		String a = "";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			a = "Sunday";
			break;
		case 2:
			a = "Monday";
			break;
		case 3:
			a = "Tuesday";
			break;
		case 4:
			a = "Wednseday";
			break;
		case 5:
			a = "Thursday";
			break;
		case 6:
			a = "Friday";
			break;
		case 7:
			a = "Saturday";
			break;
		}
		System.out.println("Today is " + a);

	}
}
