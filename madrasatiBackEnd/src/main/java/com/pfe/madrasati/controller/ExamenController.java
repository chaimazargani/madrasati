package com.pfe.madrasati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.service.ExamenService;

@RestController
public class ExamenController {
	@Autowired
	public ExamenService examenService ;
	
	@RequestMapping(value = "/ajouterExamen", method = RequestMethod.POST)
	   public Examen ajouterExamen(@RequestBody Examen examen) {
      return  (Examen) examenService.ajouterExamen(examen);
	}
	
	
	@RequestMapping(value = "/getExamen", method = RequestMethod.GET) 
	@ResponseBody
	public List<Examen> Afficherlaliste(){
		return (List<Examen>) examenService.findAll();
		
	}
	
}
