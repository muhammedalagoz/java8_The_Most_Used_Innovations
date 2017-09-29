package com.dateAPI;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {
	
	public static void main(String[] args) {

		LocalTime now= LocalTime.now();
		LocalTime time= LocalTime.of(18, 20, 55); // 18:20:55
		
		System.out.println("time: "+time);
		
		time.getHour(); // 18
		time.getMinute(); // 20
		time.getSecond(); // 55
		
		System.out.println(LocalTime.NOON); // 12:00
		System.out.println(LocalTime.MIDNIGHT);// 00:00
		
		LocalTime.parse("10:05"); // 10:05
		
		LocalTime time2 = time
		.plusSeconds(45)
		.minusSeconds(5)
		.minus(5, ChronoUnit.SECONDS); // 18:20:35
		
		System.out.println("time Edit: "+time2);
		
	}
	
}
