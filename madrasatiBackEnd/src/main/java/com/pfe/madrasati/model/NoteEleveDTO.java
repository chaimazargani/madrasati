package com.pfe.madrasati.model;

public class NoteEleveDTO {

	
    private String nomExamen;
	private Double valeurNote;
    private String nomMatier ;
	public NoteEleveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoteEleveDTO(String nomExamen, Double valeurNote, String nomMatier) {
		super();
		this.nomExamen = nomExamen;
		this.valeurNote = valeurNote;
		this.nomMatier = nomMatier;
	}
	public String getNomExamen() {
		return nomExamen;
	}
	public void setNomExamen(String nomExamen) {
		this.nomExamen = nomExamen;
	}
	public Double getValeurNote() {
		return valeurNote;
	}
	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}
	public String getNomMatier() {
		return nomMatier;
	}
	public void setNomMatier(String nomMatier) {
		this.nomMatier = nomMatier;
	}
    
}
