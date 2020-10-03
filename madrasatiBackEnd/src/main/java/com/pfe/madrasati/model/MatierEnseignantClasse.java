package com.pfe.madrasati.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "matierenseignantclasse")
public class MatierEnseignantClasse {

	@EmbeddedId
	private MatierEnseignantClassePk matierEnseignantClassePk;
	
	@JoinColumn(name = "nommatier",insertable = false, updatable = false)
	private String  nomMatier;
	
	@JoinColumn(name = "nomclasse",insertable = false, updatable = false)
	private String  nomClasse;

	@MapsId("idClasse")
	@ManyToOne
	@JoinColumn(name="idclasse", insertable = false,updatable = false)
	public Classe classe;

	
	public MatierEnseignantClassePk getMatierEnseignantClassePk() {
		return matierEnseignantClassePk;
	}

	public void setMatierEnseignantClassePk(MatierEnseignantClassePk matierEnseignantClassePk) {
		this.matierEnseignantClassePk = matierEnseignantClassePk;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getNomMatier() {
		return nomMatier;
	}

	public void setNomMatier(String nomMatier) {
		this.nomMatier = nomMatier;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matierEnseignantClassePk == null) ? 0 : matierEnseignantClassePk.hashCode());
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
		if (matierEnseignantClassePk == null) {
			if (other.matierEnseignantClassePk != null)
				return false;
		} else if (!matierEnseignantClassePk.equals(other.matierEnseignantClassePk))
			return false;
		return true;
	}



}
