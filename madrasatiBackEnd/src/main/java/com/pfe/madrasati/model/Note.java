package com.pfe.madrasati.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note {
	
	
	@EmbeddedId
	private NotePK notePk ;



	@Column(name = "valeurnote")
	private Double valeurNote;



	@ManyToOne
	@JoinColumn(name = "idexamen",insertable = false, updatable = false)
	private Examen examen;


	@ManyToOne
	@JoinColumn(name = "ideleve",insertable = false, updatable = false)
	private Eleve eleve;


	@ManyToOne
	@JoinColumn(name = "idmatier",insertable = false, updatable = false)
	private Matier matiere;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Note(NotePK notePk, Double valeurNote) {
		super();
		this.notePk = notePk;
		this.valeurNote = valeurNote;
	}



	public NotePK getNotePK() {
		return notePk;
	}



	public void setNotePK(NotePK notePk) {
		this.notePk = notePk;
	}



	public Double getValeurNote() {
		return valeurNote;
	}



	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notePk == null) ? 0 : notePk.hashCode());
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
		if (notePk == null) {
			if (other.notePk != null)
				return false;
		} else if (!notePk.equals(other.notePk))
			return false;
		return true;
	}
	
	

	
}
