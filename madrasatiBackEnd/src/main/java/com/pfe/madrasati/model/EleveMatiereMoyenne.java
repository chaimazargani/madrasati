package com.pfe.madrasati.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "elevematieremoyenne")
public class EleveMatiereMoyenne {


	@EmbeddedId
	public EleveMatiereMoyennePK eleveMatiereMoyennePK ; 
	
	@JoinColumn(name = "moyenne",insertable = false, updatable = false)
   public Integer moyenne ;
	
	
	
public EleveMatiereMoyenne() {
	super();
	// TODO Auto-generated constructor stub
}

	
}
