package com.pfe.madrasati.model;

import java.util.Scanner;

public class Tri {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = getSize(sc);
	    int[] t = new int[n];
	   RemplissageTableau(t,n,sc); 
	    trier(t) ;
	} 
	
	private static int getSize(Scanner sc) {
		System.out.println("Entrez le nombre total d'éléments du tableau à remplir");
		int n = sc.nextInt();
		return n;
	}
	public static void RemplissageTableau( int[] tableau , int n , Scanner sc) {
		for (int i=0 ; i<n ; i++) {
			System.out.println("remplir le tableau");
			int val = sc.nextInt();
			tableau[i] = val;
		
		}
		
	}

		public static void trier(int[] tableau) {
			int i, j, cle;
			
			for (i = 1; i < tableau.length; i++) {
				cle = tableau[i];
				j = i;
				while ((j >= 1) && (tableau[j - 1] > cle)) {
					tableau[j]  = tableau[j - 1] ;
					j = j - 1;
				}
				tableau[j] = cle;
			}
			for (int val : tableau)
			//System.out.println("le tableau trier : " );	
		    System.out.println( val + " ");  // afficher(t);

		}
		
		
		//public static void afficher(int[] tableau) {
			//for (int valeur : tableau) System.out.print(valeur + " ");
			//System.out.println();
		//}
	}

