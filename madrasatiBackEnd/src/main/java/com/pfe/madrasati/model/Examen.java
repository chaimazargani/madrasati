package com.pfe.madrasati.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examen")
public class Examen {
	@Id
	@GeneratedValue
	@Column(name = "idexamen")
	private Integer idExamen;

	@Column(name = "date")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "idenseignant")
	private Enseignant enseignant;

	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Examen(Integer idExamen, Date date, Enseignant enseignant) {
		super();
		this.idExamen = idExamen;
		this.date = date;
		this.enseignant = enseignant;
	}

	@Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", date=" + date + ", enseignant=" + enseignant + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idExamen == null) ? 0 : idExamen.hashCode());
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
		if (idExamen == null) {
			if (other.idExamen != null)
				return false;
		} else if (!idExamen.equals(other.idExamen))
			return false;
		return true;
	}

}
