package com.pfe.madrasati.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "enseignant")
public class Enseignant {
	@Id
	  @GeneratedValue 
	  @Column(name = "idenseignant")
 private Integer idEnseignant;

	
	@ManyToOne
	@JoinColumn(name="idenseignant" ,insertable = false, updatable = false)
	private Utilisateur utilisateur ;
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enseignant(Integer idEnseignant) {
		super();
		this.idEnseignant = idEnseignant;
	}

	public Integer getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(Integer idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEnseignant == null) ? 0 : idEnseignant.hashCode());
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
		if (idEnseignant == null) {
			if (other.idEnseignant != null)
				return false;
		} else if (!idEnseignant.equals(other.idEnseignant))
			return false;
		return true;
	}
	
	
	



	
	
}
