package com.pfe.madrasati.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table (name = "activite")
public class Activite {
	@Id
	  @GeneratedValue 
	  @Column(name = "idactivite")
		private Integer idActivite;
	  @Column(name = "nomactivite")
      private String nomactivite;
	  @Column(name = "dateDebut")
		private Date datedebut;
	  @Column(name = "dateFin")
		private Date datefin;
	  	  @ManyToOne
	  @JoinColumn(name="idenseignant", insertable = false,updatable = false)
	  private Enseignant enseignant;
		public Activite() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Activite(Integer idActivite, String nomactivite, Date datedebut, Date datefin, Enseignant enseignant) {
			super();
			this.idActivite = idActivite;
			this.nomactivite = nomactivite;
			this.datedebut = datedebut;
			this.datefin = datefin;
			this.enseignant = enseignant;
		}
		public Integer getIdActivite() {
			return idActivite;
		}
		public void setIdActivite(Integer idActivite) {
			this.idActivite = idActivite;
		}
		public String getNomactivite() {
			return nomactivite;
		}
		public void setNomactivite(String nomactivite) {
			this.nomactivite = nomactivite;
		}
		public Date getDatedebut() {
			return datedebut;
		}
		public void setDatedebut(Date datedebut) {
			this.datedebut = datedebut;
		}
		public Date getDatefin() {
			return datefin;
		}
		public void setDatefin(Date datefin) {
			this.datefin = datefin;
		}
		public Enseignant getEnseignant() {
			return enseignant;
		}
		public void setEnseignant(Enseignant enseignant) {
			this.enseignant = enseignant;
		}
		@Override
		public String toString() {
			return "Activite [idActivite=" + idActivite + ", nomactivite=" + nomactivite + ", datedebut=" + datedebut
					+ ", datefin=" + datefin + ", enseignant=" + enseignant + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idActivite == null) ? 0 : idActivite.hashCode());
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
			Activite other = (Activite) obj;
			if (idActivite == null) {
				if (other.idActivite != null)
					return false;
			} else if (!idActivite.equals(other.idActivite))
				return false;
			return true;
		}
	
	
		
}
