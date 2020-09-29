package com.pfe.madrasati.dao.security;

import java.util.List;

import com.pfe.madrasati.model.security.Autorite;

public interface AuthorizationDAO {

	List<Autorite> getAuthorityListByRoleId(Integer roleId);
	
}
