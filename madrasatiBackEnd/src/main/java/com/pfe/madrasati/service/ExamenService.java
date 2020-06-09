package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Examen;

public interface ExamenService {
	public  Examen    ajouterExamen( Examen examen) ;
    public List<Examen> findAll();

}
