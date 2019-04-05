package com.pfe.madrasati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.service.UtilisateurService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UtilisateurController {
	@Autowired
   private UtilisateurService utilisateurService;
	@RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
	public Utilisateur  Saveutilisateur(Utilisateur utilisateur) {
		return (Utilisateur) utilisateurService.ajouterUtilisateur(utilisateur);
	}
}
