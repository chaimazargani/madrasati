package com.pfe.madrasati.model;

public class Matier {
	 private String nomMatier;

	public Matier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matier(String nomMatier) {
		super();
		this.nomMatier = nomMatier;
	}

	public String getNomMatier() {
		return nomMatier;
	}

	public void setNomMatier(String nomMatier) {
		this.nomMatier = nomMatier;
	}

	@Override
	public String toString() {
		return "Matier [nomMatier=" + nomMatier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomMatier == null) ? 0 : nomMatier.hashCode());
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
		Matier other = (Matier) obj;
		if (nomMatier == null) {
			if (other.nomMatier != null)
				return false;
		} else if (!nomMatier.equals(other.nomMatier))
			return false;
		return true;
	} 
}
