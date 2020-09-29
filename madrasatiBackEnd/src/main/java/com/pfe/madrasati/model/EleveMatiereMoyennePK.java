package com.pfe.madrasati.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class EleveMatiereMoyennePK implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	@Column(name="idmatier",insertable = false, updatable = false)
	private Integer idMatier;

	@Column(name="idelve",insertable = false, updatable = false)
	private Integer idEleve;

	public EleveMatiereMoyennePK() {
		super();
	}

	public EleveMatiereMoyennePK(Integer idMatier, Integer idEleve) {
		super();
		this.idMatier = idMatier;
		this.idEleve = idEleve;
	}

	public Integer getIdMatier() {
		return idMatier;
	}

	public void setIdMatier(Integer idMatier) {
		this.idMatier = idMatier;
	}

	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
