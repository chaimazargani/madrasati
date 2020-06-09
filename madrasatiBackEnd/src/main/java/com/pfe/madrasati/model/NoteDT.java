package com.pfe.madrasati.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "notedt")
public class NoteDT {
	@Id
	  @GeneratedValue 
	  @Column(name = "nomeleve")
	private String nomEleve ;
	  @Column(name = "notecontrole1")
private Integer noteControle1  ;
	  @Column(name = "notecontrole2")
private Integer noteControle2 ;
	  @Column(name = "noteorale")
private Integer noteOrale ;
	  @Column(name = "notesynthese")
private Integer noteSynthese ;

}
