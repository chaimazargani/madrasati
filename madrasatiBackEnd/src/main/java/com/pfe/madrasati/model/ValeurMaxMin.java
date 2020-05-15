package com.pfe.madrasati.model;

public class ValeurMaxMin {
	 public static void main(String[] args) {
	     
	       
	       int array[] = {51, 24, 19, 5, 37, 76, 61, 99, 101, 36};
	       rechMinMax(array);
	 }
	   	public static void rechMinMax(int[] tab) {
	   		int maxVal = Integer.MAX_VALUE;
		       int minVal = Integer.MIN_VALUE;
	   		for (int nombre:tab)
	         System.out.print(nombre+" ");
	  
	       for(int i = 0; i < tab.length; i++){
	         if(tab[i] < maxVal)
	           maxVal = tab[i];
	         if(tab[i] > minVal)
	           minVal = tab[i];
	       }
	  
	       System.out.print("\nValeur minimale = "+maxVal);
	       System.out.print("\nValeur maximale = "+minVal);
	    }
}  
