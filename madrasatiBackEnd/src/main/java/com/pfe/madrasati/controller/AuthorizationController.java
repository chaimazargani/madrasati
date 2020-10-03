package com.pfe.madrasati.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.dao.security.AuthorizationDAO;
import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.model.security.Autorite;
import com.pfe.madrasati.model.security.UserPrinciple;

@RestController
public class AuthorizationController {
	
	@Autowired
	AuthorizationDAO authorizationDAO;
	
    @RequestMapping(value = "/getAuthorities", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<String>> getAuthorityList() {
		final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final List<Autorite> authorityList = ((UserPrinciple) principal).getUser().getListAutorite();
		final List<String> authoritiesString = 
				authorityList.stream()
				.map(Autorite::getNomAutorite)
				.collect(Collectors.toList());
		return new ResponseEntity<>(authoritiesString, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Utilisateur> getUser() {
		final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final Utilisateur user = ((UserPrinciple) principal).getUser();
		user.setRole(null);
		return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
