package com.pfe.madrasati.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registreenseignant")
public class RegistreEnseignant {

	
	@EmbeddedId
	private RegistreEnseignantPK registreEnseignantPK ;

	
	@Column(name = "nomEtat",insertable = true, updatable = true)
    private String nomEtat ;

	@ManyToOne
	@JoinColumn(name = "idenseignant",insertable = false, updatable = false)
	private Enseignant Enseignant;

	public RegistreEnseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistreEnseignant(RegistreEnseignantPK registreEnseignantPK, String nomEtat,
			com.pfe.madrasati.model.Enseignant enseignant) {
		super();
		this.registreEnseignantPK = registreEnseignantPK;
		this.nomEtat = nomEtat;
		Enseignant = enseignant;
	}

	public RegistreEnseignantPK getRegistreEnseignantPK() {
		return registreEnseignantPK;
	}

	public void setRegistreEnseignantPK(RegistreEnseignantPK registreEnseignantPK) {
		this.registreEnseignantPK = registreEnseignantPK;
	}

	public String getNomEtat() {
		return nomEtat;
	}

	public void setNomEtat(String nomEtat) {
		this.nomEtat = nomEtat;
	}

	public Enseignant getEnseignant() {
		return Enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		Enseignant = enseignant;
	}
	
}
