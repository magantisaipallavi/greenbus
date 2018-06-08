package com.svecw.greenbus.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	public static Date convertStringToDate(String dateString) {

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

}
