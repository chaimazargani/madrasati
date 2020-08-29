package com.pfe.madrasati.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matierenseignantclasse")
public class MatierEnseignantClasse {

	////@EmbeddedId
	//private MatierEnseignantClassePk matierEnseignantClassePk;

	//@ManyToOne
	@Id
	@JoinColumn(name = "idmatier",insertable = false, updatable = false)
	private Integer idMatier;

	//@ManyToOne
	@JoinColumn(name = "idenseignant",insertable = false, updatable = false)
	private Integer idEnseignant;

	//@ManyToOne
	@JoinColumn(name = "idclasse",insertable = false, updatable = false)
	private Integer  idClasse;
	
	@JoinColumn(name = "nommatier",insertable = false, updatable = false)
	private String  nomMatier;
	
	@JoinColumn(name = "nomclasse",insertable = false, updatable = false)
	private String  nomClasse;

	public MatierEnseignantClasse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatierEnseignantClasse(Integer idMatier, Integer idEnseignant, Integer idClasse, String nomMatier,
			String nomClasse) {
		super();
		this.idMatier = idMatier;
		this.idEnseignant = idEnseignant;
		this.idClasse = idClasse;
		this.nomMatier = nomMatier;
		this.nomClasse = nomClasse;
	}

	public Integer getIdMatier() {
		return idMatier;
	}

	public void setIdMatier(Integer idMatier) {
		this.idMatier = idMatier;
	}

	public Integer getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(Integer idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public Integer getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
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



}
