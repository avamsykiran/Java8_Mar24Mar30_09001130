package com.cts.javafundas.ui;

import java.time.LocalDate;

import com.cts.javafundas.model.Book;
import com.cts.javafundas.service.SwapperService;

public class SwapperDemo {

	public static void main(String[] args) {

		Book b1 = new Book(1, "abc", LocalDate.now(),1234.0);
		Book b2 = new Book(2, "opopo", LocalDate.now().minusDays(3),4321.0);
		SwapperService<Book> bswap = new SwapperService<Book>();
		bswap.doSwap(b1, b2);
		
		int x=67,y=45;
		SwapperService<Integer> iswap = new SwapperService<Integer>();
		iswap.doSwap(x, y);
		
		
	}

}
