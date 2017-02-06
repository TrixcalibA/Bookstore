package bookstore.utils

import java.text.DateFormat
import java.util.Calendar

public class Logger {
	public static void log(String message) {
		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.MEDIUM);
		String dateStr = df.format(cal.getTime());

		System.out.println("[" + dateStr + "]  " + message);
	}
	
	public static String getLoggedString(String message) {
		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.MEDIUM);
		String dateStr = df.format(cal.getTime());

		return ("[" + dateStr + "]  " + message);
	}
}
