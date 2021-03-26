package com.cts.javafundas.ui;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import com.cts.javafundas.model.Book;
import com.cts.javafundas.service.BookTitleComparator;

public class BookSetDemo {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		
		//Set<Book> books = new TreeSet<>();
		Set<Book> books = new TreeSet<>(new BookTitleComparator());
		books.add(new Book(111, "The tales", today, 2540.0));
		books.add(new Book(101, "Hounds Of Baskervalli", today.minusDays(1), 2540.0));
		books.add(new Book(110, "Java Complete Reference", today.minusDays(100), 2540.0));
		books.add(new Book(121, "Arabian Nights", today.minusDays(5), 2540.0));
		books.add(new Book(104, "Greek Legends", today.minusDays(10), 2540.0));
		books.add(new Book(102, "National LEaders", today.minusDays(15), 2540.0));
	
		for(Book b : books) {
			System.out.println(b);
		}
	}

}
