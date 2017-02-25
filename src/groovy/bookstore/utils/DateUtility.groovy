package bookstore.utils

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class DateUtility {
	public static String addLeadingZero(int val){
		if(val<10)
			return "0"+val;
		return Integer.toString(val);
	}
	 
	public static String getSpecificDate(Calendar cal){
		if(cal == null)
			return "N/A";
		SimpleDateFormat sdm = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
		return sdm.format(cal.getTime());
	}
	
	public static String getSpecificDate(Date t){
		if(t == null)
			return "N/A";
		SimpleDateFormat sdm = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
		return sdm.format(t);
	}
 
	public static String getDate(Date t){
		if(t==null)
			return null;
		SimpleDateFormat sdm = new SimpleDateFormat("MM/dd/yyyy");
		return sdm.format(t);
	}
	
	public static String getConcatDate(Calendar cal){
		SimpleDateFormat sdm = new SimpleDateFormat("MMddyy");
		return sdm.format(cal.getTime());
	}
 
	public static Calendar getPlainDate(Calendar date){
		 Calendar d = new GregorianCalendar();
		 d.setTimeInMillis(date.getTimeInMillis());
		 d.set(Calendar.HOUR_OF_DAY, 0);
		 d.set(Calendar.MINUTE, 0);
		 d.set(Calendar.SECOND, 0);
		 d.set(Calendar.MILLISECOND, 0);
		 return d;
	}
	public static void log(String message) {
        Calendar cal = Calendar.getInstance();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
                DateFormat.MEDIUM);
        String dateStr = df.format(cal.getTime());

        System.out.println("[" + dateStr + "]  " + message);
    }
    
    public static String getLoggedString(String message) {
        Calendar cal = Calendar.getInstance()
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
                DateFormat.MEDIUM)
        String dateStr = df.format(cal.getTime())

        return ("[" + dateStr + "]  " + message)
    }
	
	public static long extendMonths(long millis, int nMonths){
		Calendar cal = Calendar.getInstance()
		cal.setTimeInMillis(millis)
		int year = cal.get(Calendar.YEAR)
		int month = cal.get(Calendar.MONTH)+nMonths
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)
		
		year += (int)(month/12)
		month = month%12
		cal.getActualMaximum(Calendar.DAY_OF_MONTH)
		cal.set(Calendar.DAY_OF_MONTH,1)
		cal.set(Calendar.YEAR,year)
		cal.set(Calendar.MONTH,month)
		cal.set(Calendar.DAY_OF_MONTH,Math.min(cal.getActualMaximum(Calendar.DAY_OF_MONTH), dayOfMonth))
		return cal.getTimeInMillis()
	}
}


