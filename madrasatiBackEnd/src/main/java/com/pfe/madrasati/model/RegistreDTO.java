package com.pfe.madrasati.model;

import java.time.LocalDateTime;

public class RegistreDTO {

	/**
	 * 
	 */

	private LocalDateTime datePresence;
	private String nomEtat;
	private String nomEleve;

	public RegistreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public RegistreDTO(LocalDateTime datePresence, String nomEtat, String nomEleve) {
		super();
		this.datePresence = datePresence;
		this.nomEtat = nomEtat;
		this.nomEleve = nomEleve;
	}


	public LocalDateTime getDatePresence() {
		return datePresence;
	}

	public void setDatePresence(LocalDateTime datePresence) {
		this.datePresence = datePresence;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePresence == null) ? 0 : datePresence.hashCode());
		result = prime * result + ((nomEleve == null) ? 0 : nomEleve.hashCode());
		result = prime * result + ((nomEtat == null) ? 0 : nomEtat.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistreDTO other = (RegistreDTO) obj;
		if (datePresence == null) {
			if (other.datePresence != null)
				return false;
		} else if (!datePresence.equals(other.datePresence))
			return false;
		if (nomEleve == null) {
			if (other.nomEleve != null)
				return false;
		} else if (!nomEleve.equals(other.nomEleve))
			return false;
		if (nomEtat == null) {
			if (other.nomEtat != null)
				return false;
		} else if (!nomEtat.equals(other.nomEtat))
			return false;
		return true;
	}



}
