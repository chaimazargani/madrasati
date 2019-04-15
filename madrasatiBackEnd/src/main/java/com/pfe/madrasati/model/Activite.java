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
@Table (name = "Activite")
public class Activite {
	@Id
	  @GeneratedValue 
	  @Column(name = "idActivite")
		private Integer idActivite;
	  @Column(name = "nomActivite")
      private String nomActivite;
	  @Column(name = "dateDebut")
		private Date dateDebut;
	  @Column(name = "dateFin")
		private Date dateFin;
	  
	  @ManyToOne
	  @JoinColumn(name="idEnseignant")
	  private Enseignant enseignant;
	
	
		public Activite(Integer idActivite, String nomActivite, Date dateDebut, Date dateFin) {
		super();
		this.idActivite = idActivite;
		this.nomActivite = nomActivite;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
		public Activite() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getIdActivite() {
			return idActivite;
		}
		public void setIdActivite(Integer idActivite) {
			this.idActivite = idActivite;
		}
		public String getNomActivite() {
			return nomActivite;
		}
		public void setNomActivite(String nomActivite) {
			this.nomActivite = nomActivite;
		}
		public Date getDateDebut() {
			return dateDebut;
		}
		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}
		public Date getDateFin() {
			return dateFin;
		}
		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}
		
		public Enseignant getEnseignant() {
			return enseignant;
		}
		public void setEnseignant(Enseignant enseignant) {
			this.enseignant = enseignant;
		}
		@Override
		public String toString() {
			return "Activite [idActivite=" + idActivite + ", nomActivite=" + nomActivite + ", dateDebut=" + dateDebut
					+ ", dateFin=" + dateFin + "]";
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
