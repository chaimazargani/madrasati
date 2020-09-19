package com.pfe.madrasati.model.security;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idrole")
	private Integer idRole;

	@Column(name = "nomrole")
	private String nomRole;
	
	@OneToMany(mappedBy = "autorite")
	private List<AutoriteRole> autoriteRole;

	public Role() {
		super();
	}

	public Role(Integer idRole, String nomRole, List<AutoriteRole> autoriteRole) {
		super();
		this.idRole = idRole;
		this.nomRole = nomRole;
		this.autoriteRole = autoriteRole;
	}

	public List<AutoriteRole> getAutoriteRole() {
		return autoriteRole;
	}

	public void setAutoriteRole(List<AutoriteRole> autoriteRole) {
		this.autoriteRole = autoriteRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
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
		Role other = (Role) obj;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		return true;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", nomRole=" + nomRole + "]";
	}

}
