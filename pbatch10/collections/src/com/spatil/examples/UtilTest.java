package com.spatil.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilTest {

	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date);
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime currDate = LocalDateTime.now();
		System.out.println(currDate);

		//SimpleDateFormatter - > old class
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		System.out.println(formatter.format(currDate));
		
		/*
		 * ZoneId zone = ZoneId.from(currDate); System.out.println(zone);
		 */	
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		
		
	}
}
