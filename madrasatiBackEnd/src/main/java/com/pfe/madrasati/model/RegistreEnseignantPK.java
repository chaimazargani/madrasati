package com.pfe.madrasati.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import com.pfe.madrasati.dao.LocalDateTimeConverter;
@Embeddable
public class RegistreEnseignantPK implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "idenseignant",insertable = false, updatable = false)
	private Integer idenseignant ;
	 
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "datepresence",insertable = false, updatable = false)
	private LocalDateTime datePresence ;

	public RegistreEnseignantPK() {
		super();
	}

	public RegistreEnseignantPK(Integer idenseignant, LocalDateTime datePresence) {
		super();
		this.idenseignant = idenseignant;
		this.datePresence = datePresence;
	}

	public Integer getIdenseignant() {
		return idenseignant;
	}

	public void setIdenseignant(Integer idenseignant) {
		this.idenseignant = idenseignant;
	}

	public LocalDateTime getDatePresence() {
		return datePresence;
	}

	public void setDatePresence(LocalDateTime datePresence) {
		this.datePresence = datePresence;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}