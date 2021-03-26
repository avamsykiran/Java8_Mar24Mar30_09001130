package com.cts.javafundas.service;

public class SwapperService<T> {

	public void doSwap(T a,T b) {
		System.out.println("Before : "+a+"\t"+b);
		T t = a;
		a=b;
		b=t;
		System.out.println("After : "+a+"\t"+b);
	}
}
