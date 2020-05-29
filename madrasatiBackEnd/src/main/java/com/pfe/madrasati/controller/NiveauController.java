package com.pfe.madrasati.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Niveau;
import com.pfe.madrasati.service.NiveauService;

@RestController
public class NiveauController {
	
	@Autowired
 private NiveauService niveauService ;
	
	@RequestMapping(value = "/getListNiveau", method = RequestMethod.GET)
	@ResponseBody
	public List<Niveau> getListNiveau(@RequestParam("idNiveau") List<Integer> idNiveau) {
		 
			
		return 	niveauService.getListNiveau(idNiveau);
	}
}
