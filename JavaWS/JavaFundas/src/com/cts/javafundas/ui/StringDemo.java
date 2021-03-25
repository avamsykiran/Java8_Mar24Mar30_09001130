package com.cts.javafundas.ui;

public class StringDemo {
	
	public static void main(String a[]) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		s1 = s1 + " World";
		System.out.println(s1.hashCode());
	}

}
