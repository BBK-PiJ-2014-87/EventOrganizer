package com.famlabs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Helper function for handling dates
 * @author Famlabs
 *
 */
public class CalendarUtil {
	/**
	 * Default date format in the form 30-01-2015
	 */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Returns the given date as well formatted string. 
	 * The above defined date format is used.
	 * 
	 * @param calendar date to be return as string
	 * @return formatted string
	 */
	public static String format(Calendar calendar){
		if (calendar == null){
			return null;
		}
		return DATE_FORMAT.format(calendar.getTime());
	}
	
	/**
	 * Converts a String in the format "dd/MM/yyyy" to a Calendar object.
	 * 
	 * Return null if the String couldn't be converted.
	 * 
	 * @param dateString
	 * @return
	 */
	public static Calendar parse(String dateString){
		Calendar result = Calendar.getInstance();
		try{
			result.setTime(DATE_FORMAT.parse(dateString));
			return result;
		}catch(ParseException e){
			return null;
		}
	}
	
	public static boolean validString(String dateString){
		try{
			DATE_FORMAT.parse(dateString);
			return true;
		}catch (ParseException e){
			return false;
		}
	}

}
