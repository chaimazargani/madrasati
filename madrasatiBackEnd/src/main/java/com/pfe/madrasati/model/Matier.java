package com.pfe.madrasati.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name = "matier")
public class Matier {
	@Id
	  @GeneratedValue 
	  @Column(name = "idmatier")
private Integer idMatier;
	
	  @Column(name = "nommatier")
	private String nomMatier;
	  @Column(name = "section")
	private String section;
	  @Column(name = "nbrheure")
	  private Integer nbrHeure;
	public Matier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matier(Integer idMatier, String nomMatier, String section, Integer nbrHeure) {
		super();
		this.idMatier = idMatier;
		this.nomMatier = nomMatier;
		this.section = section;
		this.nbrHeure = nbrHeure;
	}
	public Integer getIdMatier() {
		return idMatier;
	}
	public void setIdMatier(Integer idMatier) {
		this.idMatier = idMatier;
	}
	public String getNomMatier() {
		return nomMatier;
	}
	public void setNomMatier(String nomMatier) {
		this.nomMatier = nomMatier;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Matier [idMatier=" + idMatier + ", nomMatier=" + nomMatier + ", section=" + section + ", nbrHeure="
				+ nbrHeure + "]";
	}
	public Integer getNbrHeure() {
		return nbrHeure;
	}
	public void setNbrHeure(Integer nbrHeure) {
		this.nbrHeure = nbrHeure;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMatier == null) ? 0 : idMatier.hashCode());
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
		Matier other = (Matier) obj;
		if (idMatier == null) {
			if (other.idMatier != null)
				return false;
		} else if (!idMatier.equals(other.idMatier))
			return false;
		return true;
	}
	  
	


	
}
