package com.pfe.madrasati.model;

public class NoteDTO {

    private Integer idMatier ; 
	private Integer idExamen ; 
	private Integer idEleve;

	private Double valeurNote;
	private String nomEleve ;
    private String nomExamen;
	
	
	public Integer getIdMatier() {
		return idMatier;
	}
	public void setIdMatier(Integer idMatier) {
		this.idMatier = idMatier;
	}

	public NoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoteDTO(Double valeurNote, String nomEleve, String nomExamen) {
		super();
		this.valeurNote = valeurNote;
		this.nomEleve = nomEleve;
		this.nomExamen = nomExamen;
	}
	public Integer getIdEleve() {
		return idEleve;
	}
	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}
	public Integer getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
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
		NoteDTO other = (NoteDTO) obj;
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
		return "NoteDTO [valeurNote=" + valeurNote + ", nomEleve=" + nomEleve + ", nomExamen=" + nomExamen + "]";
	}
	

    
    
	
	
}
