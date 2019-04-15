package com.pfe.madrasati.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Entity
@Table (name = "Eleve")
public class Eleve {
	@Id
	  @GeneratedValue 
	  @Column(name = "idEeleve")
  private Integer idEleve;

}
