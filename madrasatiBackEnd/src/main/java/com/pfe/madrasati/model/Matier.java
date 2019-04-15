package com.pfe.madrasati.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name = "Matier")
public class Matier {
	@Id
	  @GeneratedValue 
	  @Column(name = "idMatier")
private Integer idMatier;
	
	  @Column(name = "nomMatier")
	private String nomMatier;
	  @Column(name = "section")
	private String section;
	  @Column(name = "nbrHeure")
	  private Integer nbrHeure;
	  
	  @ManyToOne
	  private Enseignant enseignant;
}
