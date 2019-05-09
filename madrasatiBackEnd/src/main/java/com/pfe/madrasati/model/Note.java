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

	@Id
	@GeneratedValue
	@Column(name = "idnote")
	private Integer idNote;

	@Column(name="nomnote")
	private String nomNote;

	@Column(name = "valeurnote")
	private Double valeurNote;

	@ManyToOne
	@JoinColumn(name = "ideleve")
	private Eleve eleve;
	
	@ManyToOne
	@JoinColumn(name = "idmatier")
    private Matier matier;
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(Integer idNote, String nomNote, Double valeurNote, Eleve eleve) {
		super();
		this.idNote = idNote;
		this.nomNote = nomNote;
		this.valeurNote = valeurNote;
		this.eleve = eleve;
	}

	public Integer getIdNote() {
		return idNote;
	}

	public void setIdNote(Integer idNote) {
		this.idNote = idNote;
	}

	public String getNomNote() {
		return nomNote;
	}

	public void setNomNote(String nomNote) {
		this.nomNote = nomNote;
	}

	public Double getValeurNote() {
		return valeurNote;
	}

	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Note [idNote=" + idNote + ", nomNote=" + nomNote + ", valeurNote=" + valeurNote + ", eleve=" + eleve
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNote == null) ? 0 : idNote.hashCode());
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
		if (idNote == null) {
			if (other.idNote != null)
				return false;
		} else if (!idNote.equals(other.idNote))
			return false;
		return true;
	}

	
}
