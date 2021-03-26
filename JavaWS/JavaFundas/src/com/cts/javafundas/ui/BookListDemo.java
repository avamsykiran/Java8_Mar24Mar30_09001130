package com.cts.javafundas.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import com.cts.javafundas.model.Book;
import com.cts.javafundas.service.BookTitleComparator;

public class BookListDemo {
	public static void main(String[] args) {

		LocalDate today = LocalDate.now();

		List<Book> books = new ArrayList<Book>();
		books.add(new Book(111, "The tales", today, 2540.0));
		books.add(new Book(101, "Hounds Of Baskervalli", today.minusDays(1), 34540.0));
		books.add(new Book(110, "Java Complete Reference", today.minusDays(100), 540.0));
		books.add(new Book(121, "Arabian Nights", today.minusDays(5), 2140.0));
		books.add(new Book(104, "Greek Legends", today.minusDays(10), 1540.0));
		books.add(new Book(102, "National LEaders", today.minusDays(15), 7540.0));

		for (Book b : books) {
			System.out.println(b);
		}

		System.out.println("-----------------------------------------");

		Collections.sort(books);
		for (Book b : books) {
			System.out.println(b);
		}

		System.out.println("-----------------------------------------");

		BookTitleComparator btc = new BookTitleComparator();
		Collections.sort(books, btc);
		for (Book b : books) {
			System.out.println(b);
		}
		
		System.out.println("-----------------------------------------");

		Comparator<Book> bpc =  (b1,b2) -> ((Double)b1.getPrice()).compareTo(b2.getPrice());
		Collections.sort(books,bpc);
		for (Book b : books) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------");

		Comparator<Book> dopComp = (a, b) -> a.getDateOfPub().compareTo(b.getDateOfPub()) ;
		Collections.sort(books,dopComp);
		for (Book b : books) {
			System.out.println(b);
		}
		
		pickOneAndPrint(books, (b1,b2) -> b1.getPrice()>b2.getPrice()?b1:b2);
		pickOneAndPrint(books, (b1,b2) -> b1.getPrice()<b2.getPrice()?b1:b2);
	}
	
	static void pickOneAndPrint(List<Book> books,BinaryOperator<Book> binOpt) {
		
		Book finalBook = null;
		for(Book b : books) {
			if(finalBook==null) {
				finalBook = b;
			}else{
				finalBook = binOpt.apply(b, finalBook);
			}
		}
		
		System.out.println("------------------------------------");
		System.out.println(finalBook);
		System.out.println("------------------------------------");
	}
}
