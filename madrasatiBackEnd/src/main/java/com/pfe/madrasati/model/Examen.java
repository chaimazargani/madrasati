package com.pfe.madrasati.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "examen")
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
    @SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "idexamen")
	private Integer idExamen;

	
	
	@JoinColumn(name = "nomexamen")
	private String nomExamen ;
	@JoinColumn(name = "coefficeint")
private Integer coefficeint ;
	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Examen(Integer idExamen, String nomExamen, Integer coefficeint) {
		super();
		this.idExamen = idExamen;
		this.nomExamen = nomExamen;
		this.coefficeint = coefficeint;
	}
	public Integer getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}
	public String getNomExamen() {
		return nomExamen;
	}
	public void setNomExamen(String nomExamen) {
		this.nomExamen = nomExamen;
	}
	public Integer getCoefficeint() {
		return coefficeint;
	}
	public void setCoefficeint(Integer coefficeint) {
		this.coefficeint = coefficeint;
	}
	@Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", nomExamen=" + nomExamen + ", coefficeint=" + coefficeint + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coefficeint == null) ? 0 : coefficeint.hashCode());
		result = prime * result + ((idExamen == null) ? 0 : idExamen.hashCode());
		result = prime * result + ((nomExamen == null) ? 0 : nomExamen.hashCode());
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
		Examen other = (Examen) obj;
		if (coefficeint == null) {
			if (other.coefficeint != null)
				return false;
		} else if (!coefficeint.equals(other.coefficeint))
			return false;
		if (idExamen == null) {
			if (other.idExamen != null)
				return false;
		} else if (!idExamen.equals(other.idExamen))
			return false;
		if (nomExamen == null) {
			if (other.nomExamen != null)
				return false;
		} else if (!nomExamen.equals(other.nomExamen))
			return false;
		return true;
	}

	
}
