package com.pfe.madrasati.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotePK implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ideleve",insertable = true, updatable = true)
	private Integer idEleve ;
	
	@Column(name = "idmatier",insertable = true, updatable = true)
	private Integer idMatier ;
	
	
	@Column(name = "idexamen",insertable = true, updatable = true)
	private Integer idExamen ;


	public Integer getIdEleve() {
		return idEleve;
	}


	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}


	public Integer getIdMatier() {
		return idMatier;
	}


	public void setIdMatier(Integer idMatier) {
		this.idMatier = idMatier;
	}


	public Integer getIdExamen() {
		return idExamen;
	}


	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
