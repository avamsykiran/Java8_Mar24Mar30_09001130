package com.cts.javafundas.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.javafundas.model.Book;
import com.cts.javafundas.service.BookTitleComparator;

import sun.misc.Perf.GetPerfAction;

public class StreamsAPiDemo {
	public static void main(String[] args) {

		LocalDate today = LocalDate.now();

		List<Book> books = new ArrayList<Book>();
		books.add(new Book(111, "The tales", today, 2540.0,new String[] {"Amit","Rahul"}));
		books.add(new Book(101, "Hounds Of Baskervalli", today.minusDays(1), 34540.0,new String[] {"Amit","Rahul"}));
		books.add(new Book(110, "Java Complete Reference", today.minusDays(100), 540.0,new String[] {"Vamsy","Uma","Amit"}));
		books.add(new Book(121, "Arabian Nights", today.minusDays(5), 2140.0,new String[] {"Uma","Srinu"}));
		books.add(new Book(104, "Greek Legends", today.minusDays(10), 1540.0,new String[] {"Vamsy","Srinu"}));
		books.add(new Book(102, "National LEaders", today.minusDays(15), 7540.0,new String[] {"Prem","Rahul"}));

		books.stream().forEach(System.out::println);
		System.out.println("-----------------------------------------");
		books.stream().forEach((b) -> {b.setPrice(b.getPrice()*2);});
		books.stream().forEach(System.out::println);
		System.out.println("-----------------------------------------");
		Optional<Book> latestPub = books.stream()
				.reduce((b1,b2) -> (b1.getDateOfPub().isAfter(b2.getDateOfPub())?b1:b2));
		System.out.println(latestPub.get());
		System.out.println("-----------------------------------------");
		Set<Book> bookSet = books.stream().collect(Collectors.toSet());
		System.out.println(bookSet);
		System.out.println("-----------------------------------------");
		books.stream().filter(b -> b.getPrice()<=4000).forEach(System.out::println);
		System.out.println("-----------------------------------------");
		List<Book> lessPricedBooks =books.stream()
				.filter(b -> b.getPrice()<=4000)
				.collect(Collectors.toList());
		System.out.println(lessPricedBooks);
		System.out.println("-----------------------------------------");
		//List<String> bookNames = books.stream().map(b -> b.getName()).collect(Collectors.toList());
		List<String> bookNames = books.stream().map(Book::getName).collect(Collectors.toList());
		System.out.println(bookNames);
		System.out.println("-----------------------------------------");
		books.stream().sorted().forEach(System.out::println);
		System.out.println("-----------------------------------------");
		books.stream()
		.sorted((b1,b2) -> b1.getDateOfPub().compareTo(b2.getDateOfPub()))
			.forEach(System.out::println);
		System.out.println("-----------------------------------------");
		//books.stream().map(Book::getAuthors).forEach(System.out::println);
		books.parallelStream()
			.flatMap(b -> Stream.of(b.getAuthors()))
			.forEach(System.out::println);
		System.out.println("-----------------------------------------");
		books.parallelStream()
			.flatMap(b -> Stream.of(b.getAuthors()))
			.distinct()
			.forEach(System.out::println);
	}
}
