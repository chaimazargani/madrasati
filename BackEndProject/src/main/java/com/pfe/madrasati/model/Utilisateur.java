package com.pfe.madrasati.model;

public class Utilisateur {
	private Integer idUtilisateur;
	private String nom;
	private String prenom;
	private Integer age;
	private Integer cin;
	private Integer numTel;
	private String adresse;
	private String login;
	private String motDepasse;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Integer idUtilisateur, String nom, String prenom, Integer age, Integer cin, Integer numTel,
			String adresse) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.cin = cin;
		this.numTel = numTel;
		this.adresse = adresse;
	}
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCin() {
		return cin;
	}
	public void setCin(Integer cin) {
		this.cin = cin;
	}
	public Integer getNumTel() {
		return numTel;
	}
	public void setNumTel(Integer numTel) {
		this.numTel = numTel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ ", cin=" + cin + ", numTel=" + numTel + ", adresse=" + adresse + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((idUtilisateur == null) ? 0 : idUtilisateur.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numTel == null) ? 0 : numTel.hashCode());
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
		Utilisateur other = (Utilisateur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!idUtilisateur.equals(other.idUtilisateur))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numTel == null) {
			if (other.numTel != null)
				return false;
		} else if (!numTel.equals(other.numTel))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	
}
