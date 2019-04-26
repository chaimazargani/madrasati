package com.pfe.madrasati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.service.UtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired
   private UtilisateurService utilisateurService;
	
	@RequestMapping(value = "/creerUtilisateur", method = RequestMethod.POST)
	public Utilisateur  Saveutilisateur(@RequestBody Utilisateur utilisateur) {
		return (Utilisateur) utilisateurService.ajouterUtilisateur(utilisateur);
	}
	@RequestMapping(value = "/listUtilisateur", method = RequestMethod.GET) 
	public List<Utilisateur> Afficherlaliste(){
		return (List<Utilisateur>) utilisateurService.findAll();
		
	}
}
