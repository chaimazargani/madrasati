package com.pfe.madrasati.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "niveau")
public class Niveau {
		@Id
	  @Column(name = "idniveau")
	private  Integer idNiveau ; 
	  @Column(name = "nomniveau")

	  
	private String nomNiveau ;
	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Niveau(Integer idNiveau, String nomNiveau) {
		super();
		this.idNiveau = idNiveau;
		this.nomNiveau = nomNiveau;
	}
	public Integer getIdNiveau() {
		return idNiveau;
	}
	public void setIdNiveau(Integer idNiveau) {
		this.idNiveau = idNiveau;
	}
	public String getNomNiveau() {
		return nomNiveau;
	}
	public void setNomNiveau(String nomNiveau) {
		this.nomNiveau = nomNiveau;
	}
	  
	  
	
	
	
	
}
