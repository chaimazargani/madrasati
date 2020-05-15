package com.pfe.madrasati.model;

public class Etudiant extends Personne {
  private int Cne ;

public Etudiant() {
	super();
	// TODO Auto-generated constructor stub
}

public Etudiant(String nom, String prenom, int id) {
	super(nom, prenom, id);
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Etudiant [Cne=" + Cne + "]";
}



  
}
