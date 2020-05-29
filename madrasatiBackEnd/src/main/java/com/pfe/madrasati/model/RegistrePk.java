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


	@Column(name = "ideleve",insertable = false, updatable = false)
	private Integer idEleve ;
	 
	
	 @Column(name = "idetat",insertable = false, updatable = false)
    private Integer idEtat ;
	
	 @Convert(converter = LocalDateTimeConverter.class)
	 @Column(name = "datepresence",insertable = false, updatable = false)
   private LocalDateTime datePresence ;

	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}

	public Integer getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(Integer idEtat) {
		this.idEtat = idEtat;
	}

	public LocalDateTime getDatePresence() {
		return datePresence;
	}

	public void setDatePresence(LocalDateTime datePresence) {
		this.datePresence = datePresence;
	}
	 
	 

}
