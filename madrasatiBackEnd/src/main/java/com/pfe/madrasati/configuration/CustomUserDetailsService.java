package com.pfe.madrasati.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pfe.madrasati.dao.UtilisateurDAO;
import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.model.security.UserPrinciple;
@Service("customUserDetailsService")
public class CustomUserDetailsService   implements UserDetailsService {

	@Autowired
	@Qualifier("utilisateurDAO")
    private UtilisateurDAO utilisateurDAO;
	
	@Override
   public UserDetails loadUserByUsername(String username) {
     final Utilisateur user = this.utilisateurDAO.loadUserByUsername(username);
     if (user == null) {
         throw new UsernameNotFoundException(username);
     }
     return new UserPrinciple(user);
	}

}
