package com.pfe.madrasati.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pfe.madrasati.model.security.Autorite;
import com.pfe.madrasati.model.security.Role;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable , UserDetails , CredentialsContainer {

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

//	@Column(name = "datedenaissance")
//	private Date dateNaissance;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "emaill", unique = true)
	// @Email(message = "{user.email.invalid}")
	// @NotEmpty(message="Please Enter your email")
	private String email;
	@Column(name = "login")
	private String username;
	@Column(name = "motdepasse")
	private String password;
	
	@MapsId("idRole")
	@ManyToOne
	@JoinColumn(name="idrole", insertable = false ,updatable = false)
	@JsonIgnore
	private Role role ; 
	
	@Transient
	private List<Autorite> authorities;
	
	public Utilisateur() {
		super();
	}



	public void setAuthorities(List<Autorite> authorities) {
		this.authorities = authorities;
	}
	
	public List<Autorite> getListAutorite(){
		return this.authorities;
	}

	public Utilisateur(Integer idUtilisateur, String nom, String prenom, Integer identifiant, Integer numTel,
			Date dateNaissance, String adresse, String email, String username, String password, Role role) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.numTel = numTel;
//		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Transient
	private Utilisateur user;
	

	public Utilisateur getUser() {
		return user;
	}



	public void setUser(Utilisateur user) {
		this.user = user;
	}



	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
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

//	public Date getDateNaissance() {
//		return dateNaissance;
//	}
//
//	public void setDateNaissance(Date dateNaissance) {
//		this.dateNaissance = dateNaissance;
//	}

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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final boolean hasAuthorities = !(this.authorities == null || this.authorities.isEmpty());
		final List<GrantedAuthority> authorities = new ArrayList<>();
		for (Autorite authority : this.authorities) {
			final String authorityName = authority.getNomAutorite();
			final boolean hasAuthorityName = !StringUtils.isEmpty(authorityName);
			final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authorityName);
			authorities.add(simpleGrantedAuthority);
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}



	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

}