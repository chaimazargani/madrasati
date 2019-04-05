package com.pfe.madrasati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.service.ClasseService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ClasseController {
	@Autowired
	private ClasseService classeService;
	
	@RequestMapping(value = "/classe", method = RequestMethod.GET)
    public ResponseEntity<Classe> Saveclasse(@RequestParam Classe classe) {
		return new ResponseEntity<Classe> ((Classe)classeService.ajouterClasse(classe),HttpStatus.OK);
	}
}
