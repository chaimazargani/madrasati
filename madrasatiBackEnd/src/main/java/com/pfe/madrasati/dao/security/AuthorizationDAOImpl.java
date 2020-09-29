package com.pfe.madrasati.dao.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pfe.madrasati.model.security.Autorite;

@Repository("authorizationDAOImpl")
public class AuthorizationDAOImpl implements AuthorizationDAO{

	@Override
	public List<Autorite> getAuthorityListByRoleId(Integer roleId) {
			return new ArrayList<>();
	}

	
	
}
