package com.pfe.madrasati.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Entity
@Table (name = "Role")
public class Role {
	@Id
	  @GeneratedValue 
	  @Column(name = "idRole")
 private Integer idRole;
	  @Column(name = "nomRole")
	private String nomRole;
}
