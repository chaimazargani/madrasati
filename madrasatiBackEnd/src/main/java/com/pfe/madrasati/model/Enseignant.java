package com.pfe.madrasati.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Enseignant")
public class Enseignant {
	@Id
	  @GeneratedValue 
	  @Column(name = "idEnseignant")
 private Integer idEnseignant;
	
	
	 @OneToMany(mappedBy = "idExamen")
	    private List<Examen> items = new ArrayList<Examen>();
	 
	 @OneToMany(mappedBy = "idActivite") 
	    private  List<Activite> items1 = new ArrayList<Activite>();
	 
	@OneToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur urilisateur;
}
