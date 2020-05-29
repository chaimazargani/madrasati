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

	@ManyToOne
	@JoinColumn(name = "idclasse")
	private Classe classe;
	
	@Column(name="nomeleve")
	private String nomEleve;
	
	@ManyToOne
	@JoinColumn(name="ideleve" ,insertable = false, updatable = false)
	private Utilisateur utilisateur ;

	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Eleve(Integer idEleve, Classe classe) {
		super();
		this.idEleve = idEleve;
		this.classe = classe;
	}

	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
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
		return "Eleve [idEleve=" + idEleve + ", classe=" + classe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((idEleve == null) ? 0 : idEleve.hashCode());
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
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (idEleve == null) {
			if (other.idEleve != null)
				return false;
		} else if (!idEleve.equals(other.idEleve))
			return false;
		return true;
	}

}
