package com.pfe.madrasati.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registre")
public class Registre{
	

	@EmbeddedId
	private RegistrePk registrePk ;

	@ManyToOne
	@JoinColumn(name = "ideleve",insertable = false, updatable = false)
	private Eleve eleve;

	@ManyToOne
	@JoinColumn(name = "idetat",insertable = false, updatable = false)
	private Etat etat;

	public RegistrePk getRegistrePk() {
		return registrePk;
	}

	public void setRegistrePk(RegistrePk registrePk) {
		this.registrePk = registrePk;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	

	 

	
	
}
