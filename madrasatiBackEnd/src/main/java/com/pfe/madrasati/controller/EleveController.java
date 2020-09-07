package com.pfe.madrasati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.service.EleveService;
@RestController
public class EleveController {

	@Autowired
	 EleveService eleveService ;
	
	@RequestMapping (value = "/getEleveByIdClasse", method = RequestMethod.GET)
	@ResponseBody
    public	List<Eleve> getEleveByIdClasse(@RequestParam ("idClasse") Integer idClasse){
		return (List<Eleve>) eleveService.getEleveByIdClasse(idClasse);
		
	}

	@RequestMapping (value = "/getListEleveByIdClasse", method = RequestMethod.GET)
	@ResponseBody
    public	List<Eleve> getListEleveByIdClasse(@RequestParam ("idClasse") Integer idClasse){
		return (List<Eleve>) eleveService.getListEleveByIdClasse(idClasse);
		
	}
	
}   
