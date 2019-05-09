package com.pfe.madrasati.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EleveNoteDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idnote")
	private String idNote;
	
	@Column(name="nomnote")
	private Double nomNote;
	
	@Column(name = "valeurnote")
	private Double valeurNote;
	
	@ManyToOne
	@JoinColumn(name = "ideleve")
	private Eleve eleve;
 
	@ManyToOne
	@JoinColumn(name = "idmatier")
    private Matier matier;
	
	@Id
	@GeneratedValue
	@Column(name = "ideleve")
	private Integer idEleve;

	
	@ManyToOne
	@JoinColumn(name = "idclasse")
	private Classe classe;
	
	@ManyToOne
	@JoinColumn(name="ideleve" ,insertable = false, updatable = false)
	private Utilisateur utilisateur ;

	public EleveNoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EleveNoteDTO(String idNote, Double nomNote, Double valeurNote, Eleve eleve, Matier matier, Integer idEleve,
			Classe classe, Utilisateur utilisateur) {
		super();
		this.idNote = idNote;
		this.nomNote = nomNote;
		this.valeurNote = valeurNote;
		this.eleve = eleve;
		this.matier = matier;
		this.idEleve = idEleve;
		this.classe = classe;
		this.utilisateur = utilisateur;
	}

	public String getIdNote() {
		return idNote;
	}

	public void setIdNote(String idNote) {
		this.idNote = idNote;
	}

	public Double getNomNote() {
		return nomNote;
	}

	public void setNomNote(Double nomNote) {
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

	public Matier getMatier() {
		return matier;
	}

	public void setMatier(Matier matier) {
		this.matier = matier;
	}

	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EleveNoteDTO [idNote=" + idNote + ", nomNote=" + nomNote + ", valeurNote=" + valeurNote + ", eleve="
				+ eleve + ", matier=" + matier + ", idEleve=" + idEleve + ", classe=" + classe + ", utilisateur="
				+ utilisateur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEleve == null) ? 0 : idEleve.hashCode());
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
		EleveNoteDTO other = (EleveNoteDTO) obj;
		if (idEleve == null) {
			if (other.idEleve != null)
				return false;
		} else if (!idEleve.equals(other.idEleve))
			return false;
		if (idNote == null) {
			if (other.idNote != null)
				return false;
		} else if (!idNote.equals(other.idNote))
			return false;
		return true;
	}

	
	
}
