package com.pfe.madrasati.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name = "classe")
public class Classe {

	@Id
	  @GeneratedValue 
	  @Column(name = "idclasse")
    private Integer idClasse;
	@Column(name="nomclasse")
	private String nomClasse;
	@Column(name="nombreeleve")
	private Integer nombreEleve;
	@Column(name="niveauclasse")
	private String niveauClasse;
	



	
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getIdClasse() {
		return idClasse;
	}


	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
	}


	public String getNomClasse() {
		return nomClasse;
	}


	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}


	public Integer getNombreEleve() {
		return nombreEleve;
	}


	public void setNombreEleve(Integer nombreEleve) {
		this.nombreEleve = nombreEleve;
	}


	public Classe(Integer idClasse, String nomClasse, Integer nombreEleve) {
		super();
		this.idClasse = idClasse;
		this.nomClasse = nomClasse;
		this.nombreEleve = nombreEleve;
	}
	





	@Override
	public String toString() {
		return "Classe [idClasse=" + idClasse + ", nomClasse=" + nomClasse + ", nombreEleve=" + nombreEleve
				+ ", niveauClasse=" + niveauClasse + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClasse == null) ? 0 : idClasse.hashCode());
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
		Classe other = (Classe) obj;
		if (idClasse == null) {
			if (other.idClasse != null)
				return false;
		} else if (!idClasse.equals(other.idClasse))
			return false;
		return true;
	}

	

	
	
}
