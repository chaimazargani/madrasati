package com.pfe.madrasati.model;

import java.util.Scanner;

public class ValeurMinMax {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() ;
		int fac = factoiel (n);
		System.out.println(fac);
	}
		public static int factoiel (int n) {
			int fac = 1 ;
			for (int i=1 ; i<=n ; i++ ) {
				fac *= i ;
						
			}
			
					return fac ;
		}
}
