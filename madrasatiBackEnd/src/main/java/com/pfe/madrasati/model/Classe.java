package com.pfe.madrasati.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
	@SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "idclasse")
	private Integer idClasse;
	@Column(name = "nomclasse")
	private String nomClasse;
	@Column(name = "nombreeleve")
	private Integer nombreEleve;
	@Column(name = "idniveau")
	private Integer idNiveau;

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classe(Integer idClasse, String nomClasse, Integer nombreEleve, Integer idNiveau) {
		super();
		this.idClasse = idClasse;
		this.nomClasse = nomClasse;
		this.nombreEleve = nombreEleve;
		this.idNiveau = idNiveau;
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

	public Integer getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Integer idNiveau) {
		this.idNiveau = idNiveau;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClasse == null) ? 0 : idClasse.hashCode());
		result = prime * result + ((idNiveau == null) ? 0 : idNiveau.hashCode());
		result = prime * result + ((nomClasse == null) ? 0 : nomClasse.hashCode());
		result = prime * result + ((nombreEleve == null) ? 0 : nombreEleve.hashCode());
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
		if (idNiveau == null) {
			if (other.idNiveau != null)
				return false;
		} else if (!idNiveau.equals(other.idNiveau))
			return false;
		if (nomClasse == null) {
			if (other.nomClasse != null)
				return false;
		} else if (!nomClasse.equals(other.nomClasse))
			return false;
		if (nombreEleve == null) {
			if (other.nombreEleve != null)
				return false;
		} else if (!nombreEleve.equals(other.nombreEleve))
			return false;
		return true;
	}

}
