package com.pfe.madrasati.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Matier;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.service.MatiereService;
@RestController
public class MatiereController {
   @Autowired
    MatiereService matiereService ;

   @RequestMapping(value = "/getMatiereByIdEnseignant", method = RequestMethod.GET)
	@ResponseBody
	public List<MatierEnseignantClasse> getMatiereByIdEnseignant(@RequestParam ("idEnseignant") Integer idEnseignant){
       return (List<MatierEnseignantClasse>) matiereService.getMatiereByIdEnseignant( idEnseignant);
} 
   @RequestMapping(value = "/getMatieres", method = RequestMethod.GET) 
	@ResponseBody
	public  List<Matier> AfficherlisteMatier(){
		 
	   return   matiereService.findAll();
	
	}
	@RequestMapping(value = "/supprimerMatiers", method = RequestMethod.DELETE) 
	@ResponseBody
	public Matier supprimerClasse(Matier matier ){
		return  (Matier) matiereService.delete( matier) ;

}
	@RequestMapping(value = "/modifierMatier", method = RequestMethod.POST) 
	public Matier  modifierClasse(@RequestBody Matier matier ){
		return  (Matier) matiereService.update( matier) ;
		
	}
	}