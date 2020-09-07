package com.pfe.madrasati.model;

import javax.persistence.Column;
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

	
	@Column(name = "nomEtat",insertable = true, updatable = true)
    private String nomEtat ;

	@ManyToOne
	@JoinColumn(name = "ideleve",insertable = false, updatable = false)
	private Eleve eleve;

	
//	@ManyToOne
//	@JoinColumn(name = "idetat",insertable = false, updatable = false)
//	private Eleve etat;

	public RegistrePk getRegistrePk() {
		return registrePk;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

//	public Eleve getEtat() {
//		return etat;
//	}
//
//	public void setEtat(Eleve etat) {
//		this.etat = etat;
//	}

	public void setRegistrePk(RegistrePk registrePk) {
		this.registrePk = registrePk;
	}

	public String getNomEtat() {
		return nomEtat;
	}

	public void setNomEtat(String nomEtat) {
		this.nomEtat = nomEtat;
	}

}
