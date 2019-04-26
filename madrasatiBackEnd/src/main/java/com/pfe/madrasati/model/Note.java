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
	private Double valeurnote;

	@ManyToOne
	@JoinColumn(name = "ideleve")
	private Eleve eleve;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(Integer idNote, String nomNote, Double valeurnote, Eleve eleve) {
		super();
		this.idNote = idNote;
		this.nomNote = nomNote;
		this.valeurnote = valeurnote;
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

	public Double getValeurnote() {
		return valeurnote;
	}

	public void setValeurnote(Double valeurnote) {
		this.valeurnote = valeurnote;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


}
