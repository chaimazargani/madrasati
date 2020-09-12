package com.pfe.madrasati.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable , UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
	@SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "idutilisateur")
	private Integer idUtilisateur;

	@Column(name = "nom")
	// @Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String nom;
	@Column(name = "prenom")
	// @Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String prenom;
	@Column(name = "identifiant")
	private Integer identifiant;
	@Column(name = "numtel")
	private Integer numTel;

	@Column(name = "datedenaissance")
	private Date dateNaissance;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "emaill", unique = true)
	// @Email(message = "{user.email.invalid}")
	// @NotEmpty(message="Please Enter your email")
	private String email;
	@Column(name = "login")
	private String login;
	@Column(name = "motdepasse")
	private String motDepasse;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Integer idUtilisateur, String nom, String prenom, Integer identifiant, Integer numTel,
			Date dateNaissance, String adresse, String email, String login, String motDepasse) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.numTel = numTel;
		this.dateNaissance = dateNaissance;
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

	public Integer getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
	}

	public Integer getNumTel() {
		return numTel;
	}

	public void setNumTel(Integer numTel) {
		this.numTel = numTel;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.motDepasse;
	}

	@Override
	public String getUsername() {
		return this.nom;
		}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}