package sk.itlearning.java3.java3a.i.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

public class DateTime {

	// Date-Time package, java.time, introduced in the Java SE 8 release

	// The Date-Time API uses the calendar system defined in ISO-8601 as the default calendar.

	/*
	 * 	Prefix		Method Type			Use
	 *	of			static factory		Creates an instance where the factory is primarily validating the input parameters, not converting them.
	 *	from		static factory		Converts the input parameters to an instance of the target class, which may involve losing information from the input.
	 *	parse		static factory		Parses the input string to produce an instance of the target class.
	 *	format		instance			Uses the specified formatter to format the values in the temporal object to produce a string.
	 *	get			instance			Returns a part of the state of the target object.
	 *	is			instance			Queries the state of the target object.
	 *	with		instance			Returns a copy of the target object with one element changed; this is the immutable equivalent to a set method on a JavaBean.
	 *	plus		instance			Returns a copy of the target object with an amount of time added.
	 *	minus		instance			Returns a copy of the target object with an amount of time subtracted.
	 *	to			instance			Converts this object to another type.
	 *	at			instance			Combines this object with another.
	 */

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDateTime today2 = LocalDateTime.now();
		System.out.println(today2);
		
		System.out.println();
		
		LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(payday);
		
		LocalDate tomorrow = today.plusDays(1);
		System.out.println(tomorrow);

		System.out.println();
		
		LocalDateTime yesterday = today2.minus(60*60*24, ChronoUnit.SECONDS);
		System.out.println(yesterday);

		System.out.println();
		
		LocalDate dateOfBirth = LocalDate.of(1999, Month.MAY, 14);
		LocalDate firstBirthday = dateOfBirth.plusYears(1);
		System.out.println(firstBirthday);
		
		System.out.println();

		LocalDateTime db = LocalDateTime.now(ZoneId.of("Europe/Bratislava"));
		LocalDateTime dn = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(db);
		System.out.println(dn);

		System.out.println();
		
		System.out.println(today.format(DateTimeFormatter.ofPattern("E - ('e':e) : d MMMM yyyy", Locale.FRANCE)));

		LocalTime lt = LocalTime.now(ZoneId.of("Europe/Bratislava"));
		System.out.println(lt);
		
		// Konverzia LocalDate alebo LocalDateTime na Date
		Date d = Date.from(today.atStartOfDay(ZoneId.of("Europe/Bratislava")).toInstant());
		System.out.println(d);
		
		LocalDateTime ldt = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.of("Europe/Bratislava"));
		System.out.println(ldt);
		
	}

}
