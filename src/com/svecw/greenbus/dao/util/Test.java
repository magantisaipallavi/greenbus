package com.svecw.greenbus.dao.util;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Test {
	public static Calendar mysqlDateTimeToCalendar(String dateString)
	{
		try
		{
			//in my case I hade an . in the end of the date String.
			if (dateString.indexOf(".") > -1) {
				dateString = dateString.substring(0, dateString.indexOf("."));
			}
 			StringTokenizer tokenizer = new StringTokenizer(dateString," ");

			String datePart = tokenizer.nextToken();
			String timePart = tokenizer.nextToken();

			tokenizer = new StringTokenizer(datePart,"-");
			String year = tokenizer.nextToken();
			String month = tokenizer.nextToken();
			String day = tokenizer.nextToken();

			tokenizer = new StringTokenizer(timePart,":");
			String hours = tokenizer.nextToken();
			String minutes = tokenizer.nextToken();
			String seconds = tokenizer.nextToken();

			Calendar date = Calendar.getInstance();
			date.set(Calendar.YEAR, Integer.parseInt(year));
			date.set(Calendar.MONTH, Integer.parseInt(month)-1);
			date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

			date.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
			date.set(Calendar.MINUTE, Integer.parseInt(minutes));
			date.set(Calendar.SECOND, Integer.parseInt(seconds));
			return date;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
    public static void main(String[] args) {
    	 mysqlDateTimeToCalendar("2000-11-04 14:25:56 ");
	}

}



