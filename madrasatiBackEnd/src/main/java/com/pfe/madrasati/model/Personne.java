package com.pfe.madrasati.model;

public class Personne {
	public String nom ;
	public String prenom ;
	public int id ;
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(String nom, String prenom, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
	}
	
	

}
