package com.pfe.madrasati.controller;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.model.Niveau;
import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.service.ClasseService;
import com.pfe.madrasati.service.NiveauService;
import java.util.Map;
@RestController
public class ClasseController {
	@Autowired
	private ClasseService classeService;
	
	
	@RequestMapping(value = "/creerclasse", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Classe> Saveclasse(@RequestBody Classe classe) {

		return new ResponseEntity<Classe>((Classe) classeService.ajouterClasse(classe), HttpStatus.OK);
	}

	@RequestMapping(value = "/getClassesByIdEnseignant", method = RequestMethod.GET)
	@ResponseBody
	public List<MatierEnseignantClasse> getClassesByIdEnseignant(@RequestParam("idEnseignant") Integer idEnseignant,
			@RequestParam("idMatier") Integer idMatier) {
		  
			return	(List<MatierEnseignantClasse>) classeService.getClassesByIdEnseignant(idEnseignant, idMatier);
	}
	
	@RequestMapping(value = "/getClassesByIdNiveau", method = RequestMethod.GET)
	@ResponseBody
	public List<Classe> getClassesByIdNiveau(@RequestParam("idNiveau") Integer idNiveau) {
		return classeService. getClassesByIdNiveau(idNiveau);
				//(List<MatierEnseignantClasse>) classeService.getClassesByIdEnseignant(idEnseignant, idMatier);
	}
	@RequestMapping(value = "/getClasse", method = RequestMethod.GET) 
	@ResponseBody
	public Map<String, List<Classe>> Afficherlaliste(){
		 
		List<Classe> listClasse =  classeService.findAll();
		return getClasseGroupeBY( listClasse)  ;
	}
	public Map<String, List<Classe>> getClasseGroupeBY(List<Classe> listClasse) {
		List<Classe> list = listClasse;
 
		Map<String, List<Classe>> map = list.stream().collect(Collectors.groupingBy(Classe::getNomClasse));

		return map;
	}
	
	@RequestMapping(value = "/supprimerClasse", method = RequestMethod.DELETE) 
	@ResponseBody
	public Classe supprimerClasse(Classe classe ){
		return  (Classe) classeService.delete( classe) ;
		
	}
	@RequestMapping(value = "/modifierClasse", method = RequestMethod.POST) 
	public Classe  modifierClasse(@RequestBody Classe classe ){
		return  (Classe) classeService.update( classe) ;
		
	}
	
}