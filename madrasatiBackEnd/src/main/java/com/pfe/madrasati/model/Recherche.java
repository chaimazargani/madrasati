package com.pfe.madrasati.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Recherche {

	public static void main(String[] args) {
		// int T[]={1, 5, 2, 22, 14, 3, 18, 52, 40, 88, 73, 27};
		Scanner sc = new Scanner(System.in);
		int n = getSize(sc);
		
		int[] t = new int[n];
		replissageTaleau(t, n, sc);
		// int valrech = sc.nextInt();
		// int valrech=22;
		recherche(t, sc);

	}

	private static int getSize(Scanner sc) {
		System.out.println("Entrez le nombre total d'éléments du tableau à remplir");
		int n = sc.nextInt();
		return n;
	}

	public static void replissageTaleau(int[] tableau, int n, Scanner sc) {
		for (int i = 0; i < n; i++) {
			System.out.println("Entrez l'élément d'indice " + i + " du tableau");
			int val = sc.nextInt();
			tableau[i] = val;
		}
	}

	public static void recherche(int T[],Scanner sc){
	  		System.out.println("Entrez la val ");
	     	 int valrech = sc.nextInt();
	     	 	int position=-1;
           for(int i = 0 ; i<T.length;i++){
		   if(valrech==T[i])
		     //retourner la position courante
		      position=i;
		  }
  
		  if(position!=-1) {
			     System.out.println(valrech+" se trouve dans la position "+position);
		 } else {
		  System.out.println("La valeur recherchée n'existe pas");
		 }}

}
