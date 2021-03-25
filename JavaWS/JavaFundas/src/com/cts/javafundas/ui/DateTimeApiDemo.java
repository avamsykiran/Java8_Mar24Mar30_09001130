package com.cts.javafundas.ui;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApiDemo {

	public static void main(String[] args) {

		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		ZonedDateTime todayInNewYork = ZonedDateTime.now(ZoneId.of("GMT-4"));
		System.out.println(todayInNewYork);
		
		Duration gap = Duration.between(today, todayInNewYork);
		System.out.println(gap);
		
		LocalDateTime indPenDate = LocalDateTime.of(1947,Month.AUGUST,15,12,0);
		Period p = Period.between(indPenDate.toLocalDate(), today.toLocalDate());
		System.out.println(p);
		
		DateTimeFormatter myFormter = DateTimeFormatter.ofPattern("dd, MMMM-yyyy");
		System.out.println(today.format(myFormter));
		System.out.println(indPenDate.format(myFormter));
	}

}
