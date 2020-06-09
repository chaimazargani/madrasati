package com.pfe.madrasati.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EleveNoteDTO {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	
	
	
//	@Column(name = "valeurnote")
	private Double valeurNote;
	private String nomEleve ;
    private String nomExamen;

	
//	@JoinColumn(name = "ideleve")
	//private Eleve eleve;
 
	//@JoinColumn(name = "nomeleve")
	
	
  //@JoinColumn(name = "nomexamen")
	
//	@Id
	//@GeneratedValue
	//@Column(name = "ideleve")

	public EleveNoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EleveNoteDTO(Double valeurNote, String nomEleve, String nomExamen) {
		super();
		this.valeurNote = valeurNote;
		this.nomEleve = nomEleve;
		this.nomExamen = nomExamen;
	}

	public Double getValeurNote() {
		return valeurNote;
	}

	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}

	public String getNomEleve() {
		return nomEleve;
	}

	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}

	public String getNomExamen() {
		return nomExamen;
	}

	public void setNomExamen(String nomExamen) {
		this.nomExamen = nomExamen;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomEleve == null) ? 0 : nomEleve.hashCode());
		result = prime * result + ((nomExamen == null) ? 0 : nomExamen.hashCode());
		result = prime * result + ((valeurNote == null) ? 0 : valeurNote.hashCode());
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
		EleveNoteDTO other = (EleveNoteDTO) obj;
		if (nomEleve == null) {
			if (other.nomEleve != null)
				return false;
		} else if (!nomEleve.equals(other.nomEleve))
			return false;
		if (nomExamen == null) {
			if (other.nomExamen != null)
				return false;
		} else if (!nomExamen.equals(other.nomExamen))
			return false;
		if (valeurNote == null) {
			if (other.valeurNote != null)
				return false;
		} else if (!valeurNote.equals(other.valeurNote))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EleveNoteDTO [valeurNote=" + valeurNote + ", nomEleve=" + nomEleve + ", nomExamen=" + nomExamen + "]";
	}


 

	
}
