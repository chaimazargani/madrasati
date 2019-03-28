package com.pfe.madrasati.model;

public class Presence {
	private Integer idEmploye;
	private String etat;
	private String matier;
	public Presence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Presence(Integer idEmploye, String etat, String matier) {
		super();
		this.idEmploye = idEmploye;
		this.etat = etat;
		this.matier = matier;
	}
	public Integer getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getMatier() {
		return matier;
	}
	public void setMatier(String matier) {
		this.matier = matier;
	}
	@Override
	public String toString() {
		return "Presence [idEmploye=" + idEmploye + ", etat=" + etat + ", matier=" + matier + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((idEmploye == null) ? 0 : idEmploye.hashCode());
		result = prime * result + ((matier == null) ? 0 : matier.hashCode());
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
		Presence other = (Presence) obj;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (idEmploye == null) {
			if (other.idEmploye != null)
				return false;
		} else if (!idEmploye.equals(other.idEmploye))
			return false;
		if (matier == null) {
			if (other.matier != null)
				return false;
		} else if (!matier.equals(other.matier))
			return false;
		return true;
	} 

}
