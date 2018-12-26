package com.myjob.ext;

import java.util.Calendar;

public class ActionTime {
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		String years = Integer.toString(year);
		String months = Integer.toString(month);
		String days = Integer.toString(day);
		if(month < 10) months = "0"+months;
		if(day < 10) days = "0"+days;
		
		return (years+"-"+months+"-"+days);
	}
	public static String lastDate(int lastDay) {
		Calendar cal = Calendar.getInstance();
		
		long ms = cal.getTimeInMillis();
		cal.setTimeInMillis(ms - (long)((long)lastDay * (long)24 * (long)60 * (long)60 * (long)1000));
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		String years = Integer.toString(year);
		String months = Integer.toString(month);
		String days = Integer.toString(day);
		if(month < 10) months = "0"+months;
		if(day < 10) days = "0"+days;
		
		return (years+"-"+months+"-"+days);
	}
}
