package com.cts.javafundas.ui;

import java.util.Scanner;

public class Caliculator {
	
	public static void main(String a[]) {
		Scanner scan = new Scanner(System.in);
		
		ArthMenu choice = null;
		do {
			
			
			for(ArthMenu m : ArthMenu.values()) {
				System.out.println(m.ordinal() + "\t" + m);
			}
			System.out.println("Choice? ");
			int index = scan.nextInt();
			if(index>=0 && index<ArthMenu.values().length) {
				choice = ArthMenu.values()[index];
			}else {
				System.out.println("Invlaid Choice");
				continue;
			}
			
			System.out.println("Number: ");
			int n1 = scan.nextInt();
			System.out.println("Number: ");
			int n2 = scan.nextInt();			
			
			switch(choice) {
			case SUM: System.out.println("Sum "+(n1+n2)); break;
			case DIF: System.out.println("Dif "+(n1-n2)); break;
			case PROD: System.out.println("Prod "+(n1*n2)); break;
			case REM: 
				if(n2!=0) {
					System.out.println("Rem "+(n1%n2)); 
				}
				break;
			case QUT: 
				if(n2!=0) {
					System.out.println("Qut "+(n1/n2)); 
				}
				break;
			case QUIT: System.out.println("OK Bye"); break;
			default: System.out.println("Invlaid Choice"); break;
			}
		}while(choice!=ArthMenu.QUIT);
	}

}
