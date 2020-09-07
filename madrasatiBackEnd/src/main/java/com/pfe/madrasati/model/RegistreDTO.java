package com.pfe.madrasati.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RegistreDTO {

	/**
	 * 
	 */
    private  Integer idEleve ;
	private LocalDateTime datePresence;
	private Timestamp datePresenceTimeStamp;
	private String nomEtat;
	private String nomEleve;
	public RegistreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistreDTO(Integer idEleve, LocalDateTime datePresence, Timestamp datePresenceTimeStamp, String nomEtat,
			String nomEleve) {
		super();
		this.idEleve = idEleve;
		this.datePresence = datePresence;
		this.datePresenceTimeStamp = datePresenceTimeStamp;
		this.nomEtat = nomEtat;
		this.nomEleve = nomEleve;
	}
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
	public Timestamp getDatePresenceTimeStamp() {
		return datePresenceTimeStamp;
	}
	public void setDatePresenceTimeStamp(Timestamp datePresenceTimeStamp) {
		this.datePresenceTimeStamp = datePresenceTimeStamp;
	}
	public String getNomEtat() {
		return nomEtat;
	}
	public void setNomEtat(String nomEtat) {
		this.nomEtat = nomEtat;
	}
	public String getNomEleve() {
		return nomEleve;
	}
	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}


}
