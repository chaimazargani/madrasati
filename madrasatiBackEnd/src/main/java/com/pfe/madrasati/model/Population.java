package com.pfe.madrasati.model;

public class Population {
         
	public static void main(String[] args) {
 		System.out.println("la population augmente de " );

		float pop = getNumberOfYearsToReach();
	}
	
	public static float getNumberOfYearsToReach () {
		int n = 0;                    
		int p = 3000;
		int aug =0 ;
		do  {
		 aug = p * 2 / 100 ;
		p = p+ aug ;
		n= n+1 ;
		}	
		while (p<= 4000 );
		return n;
			
	
}
}