package com.pfe.madrasati.model;

public class Enseignant {

	 private Integer idEnseignant;
	 private Integer cin; 
	 private Integer tel; 
	 private String nom; 
	 private String prenom; 
	 private String dateDeNaisance; 
	 private String adresse;
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant(Integer idEnsaignat, Integer cin, Integer tel, String nom, String prenom, String dateDeNaisance,
			String adresse) {
		super();
		this.idEnseignant = idEnseignant;
		this.cin = cin;
		this.tel = tel;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaisance = dateDeNaisance;
		this.adresse = adresse;
	}
	public Integer getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Integer idPof) {
		this.idEnseignant = idEnseignant;
	}
	public Integer getCin() {
		return cin;
	}
	public void setCin(Integer cin) {
		this.cin = cin;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
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
	public String getDateDeNaisance() {
		return dateDeNaisance;
	}
	public void setDateDeNaisance(String dateDeNaisance) {
		this.dateDeNaisance = dateDeNaisance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Enseignant [idPof=" + idPof + ", cin=" + cin + ", tel=" + tel + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateDeNaisance=" + dateDeNaisance + ", adresse=" + adresse + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((dateDeNaisance == null) ? 0 : dateDeNaisance.hashCode());
		result = prime * result + ((idPof == null) ? 0 : idPof.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Enseignant other = (Enseignant) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (dateDeNaisance == null) {
			if (other.dateDeNaisance != null)
				return false;
		} else if (!dateDeNaisance.equals(other.dateDeNaisance))
			return false;
		if (idPof == null) {
			if (other.idPof != null)
				return false;
		} else if (!idPof.equals(other.idPof))
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
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	 
	 
}
