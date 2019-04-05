package com.pfe.madrasati.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "Utilisateur")
public class Utilisateur {
	  @Id
	  @GeneratedValue  
	  @Column(name = "idUtilisateur")
	private Integer idUtilisateur;
	  @Column(name = "nom")
	   @Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String nom;
	  @Column(name = "prenom")
	   @Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String prenom;
	  @Column(name = "cin")
	private Integer cin;
	  @Column(name = "numTel")
	private Integer numTel;
	  @Column(name = "dateDenaissance")
	private Date dateDenaissance;
	  @Column(name = "adresse")
	private String adresse;
	  @Column(name = "email", unique = true)
	   @Email(message = "{user.email.invalid}")
	   @NotEmpty(message="Please Enter your email")
    private String email; 
	  @Column(name = "login")
	private String login;
	  @Column(name = "motDepasse")
	private String motDepasse;
	  
	public Utilisateur() {
	}
	
	public Utilisateur(Integer idUtilisateur, String nom, String prenom, Integer cin, Integer numTel,
			Date dateDenaissance, String adresse, String email, String login, String motDepasse) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.numTel = numTel;
		this.dateDenaissance = dateDenaissance;
		this.adresse = adresse;
		this.email = email;
		this.login = login;
		this.motDepasse = motDepasse;
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

	public Date getDateDenaissance() {
		return dateDenaissance;
	}

	public void setDateDenaissance(Date dateDenaissance) {
		this.dateDenaissance = dateDenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDepasse() {
		return motDepasse;
	}

	public void setMotDepasse(String motDepasse) {
		this.motDepasse = motDepasse;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin
				+ ", numTel=" + numTel + ", dateDenaissance=" + dateDenaissance + ", adresse=" + adresse + ", email="
				+ email + ", login=" + login + ", motDepasse=" + motDepasse + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUtilisateur == null) ? 0 : idUtilisateur.hashCode());
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
		if (idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!idUtilisateur.equals(other.idUtilisateur))
			return false;
		return true;
	}


}