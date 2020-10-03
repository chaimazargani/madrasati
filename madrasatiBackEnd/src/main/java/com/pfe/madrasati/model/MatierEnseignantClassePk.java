package com.pfe.madrasati.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatierEnseignantClassePk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Column(name="idmatier")
	private Integer idMatier;

	@Column(name="idenseignant")
	private Integer idEnseignant;

	@Column(name="idclasse")
	private Integer idClasse;

	
	public MatierEnseignantClassePk() {
	}


	public MatierEnseignantClassePk(Integer idMatier, Integer idEnseignant, Integer idClasse) {
		super();
		this.idMatier = idMatier;
		this.idEnseignant = idEnseignant;
		this.idClasse = idClasse;
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


	
}
