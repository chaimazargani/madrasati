package com.pfe.madrasati.model.security;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table (name = "roleautorite")
public class AutoriteRole {
	
	@EmbeddedId
	private AutoriteRolePk id;
	@MapsId("idRole")
	@ManyToOne
	@JoinColumn(name="idrole", insertable = false,updatable = false)
	public Role role ;
	
	 
	@MapsId("idAutorite")
	@ManyToOne
	@JoinColumn(name="idautorite", insertable = false,updatable = false)
	public Autorite autorite ;
	
	public AutoriteRole() {
		super();
	}
	public AutoriteRole(Role role, Autorite autorite) {
		super();
		this.role = role;
		this.autorite = autorite;
	}

	public AutoriteRolePk getId() {
		return id;
	}
	public void setId(AutoriteRolePk id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Autorite getAutorite() {
		return autorite;
	}

	public void setAutorite(Autorite autorite) {
		this.autorite = autorite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AutoriteRole other = (AutoriteRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
	
	
}
