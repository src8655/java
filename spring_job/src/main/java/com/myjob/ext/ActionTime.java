package com.myjob.ext;

import java.util.Calendar;
import java.util.Date;

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
	public static int dDay(String dates) {
		if(dates == null) return 0;
		Calendar cal = Calendar.getInstance();
		
		long ms = cal.getTimeInMillis();
		
		String[] tmp = dates.split("-");
		if(tmp.length != 3 || tmp == null) return 0;
		cal.set(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])-1, Integer.parseInt(tmp[2]), 0, 0);
		
		
		
		ms = cal.getTimeInMillis() - ms;
		
		return (int)((((ms/(long)1000)/(long)60)/(long)60)/(long)24);
	}
}
