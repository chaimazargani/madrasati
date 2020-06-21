package com.pfe.madrasati.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.pfe.madrasati.model.Utilisateur;
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
	@ResponseBody()
	public Map<String, List<Examen>>  Afficherlaliste(){
		List<Examen> listExamen =  examenService.findAll();
		return  getExamenGroupeBY(listExamen) ;
	}
	public Map<String, List<Examen>> getExamenGroupeBY(List<Examen> listExamen) {
		List<Examen> list = listExamen;
 
		Map<String, List<Examen>> map = list.stream().collect(Collectors.groupingBy(Examen::getNomExamen));

		return map;
	}

	@RequestMapping(value = "/supprimerExamen", method = RequestMethod.POST) 
	public Examen supprimerExamen(@RequestBody Examen examen ){
		return  (Examen) examenService.delete( examen) ;
		
	}
	@RequestMapping(value = "/modifierExamen", method = RequestMethod.POST) 
	public Examen  modifierExamen(@RequestBody Examen examen ){
		return  (Examen) examenService.update( examen) ;
		
	}
	
}
