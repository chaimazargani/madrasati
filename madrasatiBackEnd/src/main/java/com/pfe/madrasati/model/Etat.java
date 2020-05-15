package com.pfe.madrasati.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "etat")
public class Etat {
	@Id
	  @GeneratedValue 
	  @Column(name = "idetat")
	private Integer idEtat ;
	@Column(name="nometat")
	private String nomEtat ;
	public Integer getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(Integer idEtat) {
		this.idEtat = idEtat;
	}
	public String getNomEtat() {
		return nomEtat;
	}
	public void setNomEtat(String nomEtat) {
		this.nomEtat = nomEtat;
	}

	
	
}
