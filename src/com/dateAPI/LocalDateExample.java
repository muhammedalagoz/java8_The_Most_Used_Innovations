package com.dateAPI;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateExample {
	public static void main(String[] args) {
		
		LocalDate lDate = LocalDate.of(1988, 07, 16);
//		veya ->
		lDate = LocalDate.of(1988, Month.JULY, 16);

		System.out.println("*******--------------*********");
		LocalDate now = LocalDate.now();
		
		LocalDate editNow = now.withYear(2016);
		System.out.println("Edit Year -> " + editNow);

		System.out.println("*******--------------*********");
		LocalDate editNow2 = now
								.with(ChronoField.YEAR, 2012)
								.with(ChronoField.MONTH_OF_YEAR, 8)
								.with(ChronoField.DAY_OF_MONTH,3);
		System.out.println("Edit Now -> " + editNow2);

		
		System.out.println("*******--------------*********");
		System.out.println("Now -> " + now);
		LocalDate plusNow = now.plusYears(3);
		System.out.println("Plus Year -> " + plusNow);
		LocalDate plusNow2 = now
								.plusWeeks(2)
								.plusDays(3)
								.plusYears(3)
								.plusDays(7);

		System.out.println("Plus Now Date 2 -> " + plusNow2);
		
		LocalDate plusNow3 = now
								.plus(2, ChronoUnit.WEEKS)
								.plus(3, ChronoUnit.YEARS)
								.plus(3, ChronoUnit.DECADES);
		System.out.println("Plus Now Date 3 -> " + plusNow3);
		
		System.out.println("*******--------------*********");
		
		LocalDate minusNow = now
								.minus(2, ChronoUnit.WEEKS)
								.minus(3, ChronoUnit.YEARS)
								.minus(33, ChronoUnit.DAYS);
		System.out.println("minus Now Date -> " + minusNow);
		LocalDate minusNow1 = now.minusDays(5).minusMonths(2);
		System.out.println("minus Now Date 2 -> " + minusNow1);

		System.out.println("*******--------------*********");
		
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);

		System.out.println("*******--------------*********");

		LocalDate date1 = LocalDate.of(2014, 01, 14);
		if (date1.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date1);

		}

		System.out.println("*******--------------*********");

		LocalDate dateOfBirth = LocalDate.of(1990, 03, 23);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}
		
		System.out.println("*******--------------*********");

		LocalDate tomorrow = LocalDate.of(2014, 1, 15);
		if (tomorrow.isAfter(today)) {
			System.out.println("Tomorrow comes after today");
		}
		
		LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
		if (yesterday.isBefore(today)) {
			System.out.println("Yesterday is day before today");
		}
		
		System.out.println("*******--------------*********");

		if (today.isLeapYear()) {
			System.out.println("This year is Leap year");
		} else {
			System.out.println("2014 is not a Leap year");
		}
		
		System.out.println("*******--------------*********");

		LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
		Period periodToNextJavaRelease = Period.between(today, java8Release);
		System.out.println("Months left between today and Java 8 release : "
				+ periodToNextJavaRelease.getMonths());
		
		System.out.println("*******--------------*********");

		String dayAfterTommorrow = "20140116";
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);

		System.out.println("*******--------------*********");

		String goodFriday = "Apr 18 2014";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
			LocalDate holiday = LocalDate.parse(goodFriday, formatter);
			
			System.out.printf("Successfully parsed String %s, date is %s%n",goodFriday, holiday);
		} catch (DateTimeParseException ex) {
			System.out.printf("%s is not parsable!%n", goodFriday);
			
			ex.printStackTrace();
		}
		
		System.out.println("*******--------------*********");
		

		
	}
}
