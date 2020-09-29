package com.pfe.madrasati.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import com.pfe.madrasati.dao.LocalDateTimeConverter;

@Embeddable
public class RegistrePk implements Serializable {
	
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "ideleve")
	private Integer idEleve ;
	 
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "datepresence")
	private LocalDateTime datePresence ;
	



	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}


	public LocalDateTime getDatePresence() {
		return datePresence;
	}

	public void setDatePresence(LocalDateTime datePresence) {
		this.datePresence = datePresence;
	}
	 
	 

}
