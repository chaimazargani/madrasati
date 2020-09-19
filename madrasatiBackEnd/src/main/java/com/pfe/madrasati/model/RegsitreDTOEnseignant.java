package com.pfe.madrasati.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RegsitreDTOEnseignant {

	
	 
	    private  Integer idEnseignant  ;
		private LocalDateTime datePresence;
		private Timestamp datePresenceTimeStamp;
		private String nomEtat;
		private String nomEnseigant ;
		public RegsitreDTOEnseignant() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RegsitreDTOEnseignant(Integer idEnseignant, LocalDateTime datePresence, Timestamp datePresenceTimeStamp,
				String nomEtat, String nomEnseigant) {
			super();
			this.idEnseignant = idEnseignant;
			this.datePresence = datePresence;
			this.datePresenceTimeStamp = datePresenceTimeStamp;
			this.nomEtat = nomEtat;
			this.nomEnseigant = nomEnseigant;
		}
		public Integer getIdEnseignant() {
			return idEnseignant;
		}
		public void setIdEnseignant(Integer idEnseignant) {
			this.idEnseignant = idEnseignant;
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
		public String getNomEnseigant() {
			return nomEnseigant;
		}
		public void setNomEnseigant(String nomEnseigant) {
			this.nomEnseigant = nomEnseigant;
		}
	
}
