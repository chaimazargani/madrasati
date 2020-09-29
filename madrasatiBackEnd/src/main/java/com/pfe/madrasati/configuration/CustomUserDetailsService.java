package com.pfe.madrasati.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.pfe.madrasati.dao.UtilisateurDAO;
import com.pfe.madrasati.dao.security.AuthorizationDAO;
import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.model.security.Autorite;
import com.pfe.madrasati.model.security.UserPrinciple;
@Service("customUserDetailsService")
public class CustomUserDetailsService   implements UserDetailsService {

	@Autowired
	@Qualifier("utilisateurDAO")
    private UtilisateurDAO utilisateurDAO;
	
	@Autowired
	@Qualifier("authorizationDAOImpl")
	private AuthorizationDAO authorizationDAOImpl;
	
	@Override
   public UserDetails loadUserByUsername(String username) {
     final Utilisateur user = this.utilisateurDAO.loadUserByUsername(username);
     if (user.getRole() != null) { 
     final List<Autorite> authorityList = this.authorizationDAOImpl.getAuthorityListByRoleId(user.getRole().getIdRole());
     user.setAuthorities(authorityList);
     }
     return new UserPrinciple(user);
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String p = bCryptPasswordEncoder.encode("password");
		System.out.println(bCryptPasswordEncoder.matches("password", p));
	}

}
