package com.pfe.madrasati.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eleve")
public class Eleve{

	@Id
	@GeneratedValue
	@Column(name = "ideleve")
	private Integer idEleve;

	@JoinColumn(name = "idclasse")
	private Integer idClasse;
	
	@Column(name="nomeleve")
	private String nomEleve;
	
	@ManyToOne
	@JoinColumn(name="ideleve" ,insertable = false, updatable = false)
	private Utilisateur utilisateur ;

	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Eleve(Integer idEleve, Integer idClasse, String nomEleve, Utilisateur utilisateur) {
		super();
		this.idEleve = idEleve;
		this.idClasse = idClasse;
		this.nomEleve = nomEleve;
		this.utilisateur = utilisateur;
	}

	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}

	public Integer getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
	}

	public String getNomEleve() {
		return nomEleve;
	}

	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Eleve [idEleve=" + idEleve + ", idClasse=" + idClasse + ", nomEleve=" + nomEleve + ", utilisateur="
				+ utilisateur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClasse == null) ? 0 : idClasse.hashCode());
		result = prime * result + ((idEleve == null) ? 0 : idEleve.hashCode());
		result = prime * result + ((nomEleve == null) ? 0 : nomEleve.hashCode());
		result = prime * result + ((utilisateur == null) ? 0 : utilisateur.hashCode());
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
		Eleve other = (Eleve) obj;
		if (idClasse == null) {
			if (other.idClasse != null)
				return false;
		} else if (!idClasse.equals(other.idClasse))
			return false;
		if (idEleve == null) {
			if (other.idEleve != null)
				return false;
		} else if (!idEleve.equals(other.idEleve))
			return false;
		if (nomEleve == null) {
			if (other.nomEleve != null)
				return false;
		} else if (!nomEleve.equals(other.nomEleve))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}

	
	
	
}
