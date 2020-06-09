package com.pfe.madrasati.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Column(name = "valeurnote")
	private Double valeurNote;
	@Id
	
	@JoinColumn(name = "ideleve")
	private Integer idEleve ;
	

	@JoinColumn(name = "idmatier")
    private Integer idMatier;
	
	@JoinColumn(name = "idexamen")
    private Integer idExamen ;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(Double valeurNote, Integer idEleve, Integer idMatier, Integer idExamen) {
		super();
		this.valeurNote = valeurNote;
		this.idEleve = idEleve;
		this.idMatier = idMatier;
		this.idExamen = idExamen;
	}

	public Double getValeurNote() {
		return valeurNote;
	}

	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}

	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}

	public Integer getIdMatier() {
		return idMatier;
	}

	public void setIdMatier(Integer idMatier) {
		this.idMatier = idMatier;
	}

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Note [valeurNote=" + valeurNote + ", idEleve=" + idEleve + ", idMatier=" + idMatier + ", idExamen="
				+ idExamen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEleve == null) ? 0 : idEleve.hashCode());
		result = prime * result + ((idExamen == null) ? 0 : idExamen.hashCode());
		result = prime * result + ((idMatier == null) ? 0 : idMatier.hashCode());
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
		Note other = (Note) obj;
		if (idEleve == null) {
			if (other.idEleve != null)
				return false;
		} else if (!idEleve.equals(other.idEleve))
			return false;
		if (idExamen == null) {
			if (other.idExamen != null)
				return false;
		} else if (!idExamen.equals(other.idExamen))
			return false;
		if (idMatier == null) {
			if (other.idMatier != null)
				return false;
		} else if (!idMatier.equals(other.idMatier))
			return false;
		if (valeurNote == null) {
			if (other.valeurNote != null)
				return false;
		} else if (!valeurNote.equals(other.valeurNote))
			return false;
		return true;
	}

	
}
