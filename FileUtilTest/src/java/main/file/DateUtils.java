package file;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public abstract class DateUtils {
	
	public static int getDurationDays(Date date1, Date date2) {
		DateTime dateTime1 = new DateTime(date1.getTime());
		DateTime dateTime2 = new DateTime(date2.getTime());
		return Days.daysBetween(dateTime1, dateTime2).getDays();
	}
	
	/***
	 * The pattern syntax is mostly compatible with java.text.SimpleDateFormat - time zone names cannot be parsed and a few more symbols are supported. All ASCII letters are reserved as pattern letters, which are defined as follows:
		 Symbol  Meaning                      Presentation  Examples
		 ------  -------                      ------------  -------
		 G       era                          text          AD
		 C       century of era (>=0)         number        20
		 Y       year of era (>=0)            year          1996
		
		 x       weekyear                     year          1996
		 w       week of weekyear             number        27
		 e       day of week                  number        2
		 E       day of week                  text          Tuesday; Tue
		
		 y       year                         year          1996
		 D       day of year                  number        189
		 M       month of year                month         July; Jul; 07
		 d       day of month                 number        10
		
		 a       halfday of day               text          PM
		 K       hour of halfday (0~11)       number        0
		 h       clockhour of halfday (1~12)  number        12
		
		 H       hour of day (0~23)           number        0
		 k       clockhour of day (1~24)      number        24
		 m       minute of hour               number        30
		 s       second of minute             number        55
		 S       fraction of second           number        978
		
		 z       time zone                    text          Pacific Standard Time; PST
		 Z       time zone offset/id          zone          -0800; -08:00; America/Los_Angeles
		
		 '       escape for text              delimiter
		 ''      single quote                 literal       '

		String dateTime = "11/15/2013 08:00:00";
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
		
	 * 
	 * @param dateTime
	 * @param format
	 * @return
	 */
	public static DateTime parseDateTime(String dateTime, String format) {
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		
		// Parsing the date
		DateTime jodatime = dtf.parseDateTime(dateTime);
		
		return jodatime;
	}
	
	public static Boolean isBetween(Date inputDate, Date start, Date finish) {
		return inputDate.compareTo(start) >= 0 && inputDate.compareTo(finish) <= 0;
	}
	
	public static Boolean isABeforeB(Date a, Date b) {
		LocalDateTime aLocalDateTime = new LocalDateTime(a);
		LocalDateTime bLocalDateTime = new LocalDateTime(b);
		return aLocalDateTime.isBefore(bLocalDateTime);
	}
	
	public static Boolean isAAfterB(Date a, Date b) {
		LocalDateTime aLocalDateTime = new LocalDateTime(a);
		LocalDateTime bLocalDateTime = new LocalDateTime(b);
		return aLocalDateTime.isAfter(bLocalDateTime);
	}
	
	public static String formatDate(Date datetime, String outputFormat) {
		LocalDateTime jodatime = new LocalDateTime(datetime);
		
		// Format for output
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern(outputFormat);
		return dtfOut.print(jodatime);
	}
	
	public static Date getCurrentDate() {
		LocalDate date = new LocalDate();
		return date.toDate();
	}
	
	public static Date getCurrentDateTime() {
		return new Date();
	}
	
	
	public static Date getLastDayOfMonthDateTime235959(Date inputDate) {
		 LocalDateTime localDateTime = new LocalDateTime(inputDate);
		 localDateTime = localDateTime.withDayOfMonth(localDateTime.dayOfMonth().getMaximumValue());
		 LocalDateTime withSecondOfMinute = localDateTime.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
		 return withSecondOfMinute.toDate();
	}
	

	public static Date getDateTime000000(Date date) {
		LocalDate localDate = new LocalDate(date);
		return localDate.toDate();
	}

	public static Date getDateTime235959(Date date) {
		LocalDateTime localDateTime = new LocalDateTime(date);
		LocalDateTime withSecondOfMinute = localDateTime.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
		return withSecondOfMinute.toDate();
	}
	
}
