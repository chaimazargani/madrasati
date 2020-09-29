package com.pfe.madrasati.model.security;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "autorite")
public class Autorite {

	@Id 
	//    @SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	 @Column(name = "idautorite")
	public Integer idAutorite ; 
	
	 @Column(name = "nomautorite")
	public String nomAutorite ;
	 
	 @OneToMany(mappedBy = "role")
	 public List<AutoriteRole> autoriteRole ;

	public Autorite() {
		super();
	}

	public Autorite(Integer idAutorite, String nomAutorite, List<AutoriteRole> autoriteRole) {
		super();
		this.idAutorite = idAutorite;
		this.nomAutorite = nomAutorite;
		this.autoriteRole = autoriteRole;
	}

	public Integer getIdAutorite() {
		return idAutorite;
	}

	public void setIdAutorite(Integer idAutorite) {
		this.idAutorite = idAutorite;
	}

	public String getNomAutorite() {
		return nomAutorite;
	}

	public void setNomAutorite(String nomAutorite) {
		this.nomAutorite = nomAutorite;
	}

	public List<AutoriteRole> getAutoriteRole() {
		return autoriteRole;
	}

	public void setAutoriteRole(List<AutoriteRole> autoriteRole) {
		this.autoriteRole = autoriteRole;
	} 
	
}
