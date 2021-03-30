package com.cts.javafundas.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Book implements Comparable<Book>{
	
	private int bcode;
	private String name;
	private LocalDate dateOfPub;
	private double price;
	private String[] authors;
	
	public Book(){
		
	}

	public Book(int bcode, String name, LocalDate dateOfPub, double price) {
		super();
		this.bcode = bcode;
		this.name = name;
		this.dateOfPub = dateOfPub;
		this.price = price;
	}
	
	public Book(int bcode, String name, LocalDate dateOfPub, double price, String[] authors) {
		super();
		this.bcode = bcode;
		this.name = name;
		this.dateOfPub = dateOfPub;
		this.price = price;
		this.authors = authors;
	}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfPub() {
		return dateOfPub;
	}

	public void setDateOfPub(LocalDate dateOfPub) {
		this.dateOfPub = dateOfPub;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [bcode=" + bcode + ", name=" + name + ", dateOfPub=" + dateOfPub + ", price=" + price
				+ ", authors=" + Arrays.toString(authors) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + bcode;
		result = prime * result + ((dateOfPub == null) ? 0 : dateOfPub.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (!Arrays.equals(authors, other.authors))
			return false;
		if (bcode != other.bcode)
			return false;
		if (dateOfPub == null) {
			if (other.dateOfPub != null)
				return false;
		} else if (!dateOfPub.equals(other.dateOfPub))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public int compareTo(Book o) {
		return ((Integer)this.bcode).compareTo(o.bcode);
	}

	 	
}
