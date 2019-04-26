package com.pfe.madrasati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}