package com.pfe.madrasati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.service.ClasseService;

@RestController
public class ClasseController {
	@Autowired
	private ClasseService classeService;
	
	@RequestMapping(value = "/creerclasse", method = RequestMethod.POST)
	@ResponseBody
    public ResponseEntity<Classe> Saveclasse(@RequestBody Classe classe) {
		
		return new ResponseEntity<Classe> ((Classe)classeService.ajouterClasse(classe),HttpStatus.OK);
	}
}
