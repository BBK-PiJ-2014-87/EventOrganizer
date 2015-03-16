package com.famlabs.application;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TESTS {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String format(Calendar calendar){
		if (calendar == null){
			return null;
		}
		return DATE_FORMAT.format(calendar.getTime());
	}
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		
		System.out.println(format(cal));

	}
}
