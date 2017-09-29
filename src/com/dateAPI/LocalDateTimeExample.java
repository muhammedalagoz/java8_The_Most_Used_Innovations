package com.dateAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dateTime = LocalDateTime.of(2014, Month.JANUARY, 3, 4, 5, 45);
		
		dateTime.getYear(); // 2014
		dateTime.getMonth(); // JANUARY
		dateTime.getDayOfMonth(); // 3
		dateTime.getHour(); // 4
		dateTime.getMinute(); // 5
		dateTime.getSecond(); // 45
		
		// LocalDateTime2LocalDate ve LocalDateTime2LocalTime
		LocalDate date = dateTime.toLocalDate();
		LocalTime time = dateTime.toLocalTime();
		
		LocalDateTime edit = dateTime
			.minusDays(3)
			.plusYears(3)
			.plusMinutes(3)
			.minusWeeks(5)
			.plusSeconds(2);
		
		System.out.println("datetime : " + dateTime);
		System.out.println("Edit1 : " + edit);		
		
	}
	
}
