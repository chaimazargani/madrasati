package com.pfe.madrasati.model;

public class Registre {
	 private  String nom;
	  private String prenom;
	  private String Etat;
	public Registre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registre(String nom, String prenom, String etat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		Etat = etat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	@Override
	public String toString() {
		return "Registre [nom=" + nom + ", prenom=" + prenom + ", Etat=" + Etat + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Etat == null) ? 0 : Etat.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registre other = (Registre) obj;
		if (Etat == null) {
			if (other.Etat != null)
				return false;
		} else if (!Etat.equals(other.Etat))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
}
