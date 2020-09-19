package com.pfe.madrasati.model.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AutoriteRolePk  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "idrole",insertable = true, updatable = true)
	private Integer idRole ;
	
	@Column(name = "idautorite",insertable = true, updatable = true)
	private Integer idAutorite ;

	public AutoriteRolePk() {
		super();
	}

	public AutoriteRolePk(Integer idRole, Integer idAutorite) {
		super();
		this.idRole = idRole;
		this.idAutorite = idAutorite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutorite == null) ? 0 : idAutorite.hashCode());
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
		AutoriteRolePk other = (AutoriteRolePk) obj;
		if (idAutorite == null) {
			if (other.idAutorite != null)
				return false;
		} else if (!idAutorite.equals(other.idAutorite))
			return false;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole)) {
			return false;
		}
		return true;
	}



	
	
	
}
