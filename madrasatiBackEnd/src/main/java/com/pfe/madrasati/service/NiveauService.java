package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.pfe.madrasati.model.Niveau;

public interface NiveauService {
	 List<Niveau> getListNiveau( List<Integer> idNiveau) ;
		
		
	}
	
