package com.cts.javafundas.service;

import java.util.Comparator;

import com.cts.javafundas.model.Book;

public class BookTitleComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
