package com.pfe.madrasati.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matier_classe_enseignant")
public class MatierEnseignantClasse {

	@EmbeddedId
	private MatierEnseignantClassePk matierEnseignantClassePk;

	@ManyToOne
	@JoinColumn(name = "idmatier",insertable = false, updatable = false)
	private Matier matier;

	@ManyToOne
	@JoinColumn(name = "idenseignant",insertable = false, updatable = false)
	private Enseignant enseignant;

	@ManyToOne
	@JoinColumn(name = "idclasse",insertable = false, updatable = false)
	private Classe classe;

	public MatierEnseignantClasse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatierEnseignantClasse(Matier matier, Enseignant enseignant, Classe classe) {
		super();
		this.matier = matier;
		this.enseignant = enseignant;
		this.classe = classe;
	}

	public Matier getMatier() {
		return matier;
	}

	public void setMatier(Matier matier) {
		this.matier = matier;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "MatierEnseignantClasse [matier=" + matier + ", enseignant=" + enseignant + ", classe=" + classe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result + ((matier == null) ? 0 : matier.hashCode());
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
		MatierEnseignantClasse other = (MatierEnseignantClasse) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (matier == null) {
			if (other.matier != null)
				return false;
		} else if (!matier.equals(other.matier))
			return false;
		return true;
	}

}
