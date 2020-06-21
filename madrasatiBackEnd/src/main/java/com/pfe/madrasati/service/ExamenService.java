package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.model.Utilisateur;

public interface ExamenService {
	public  Examen    ajouterExamen( Examen examen) ;
    public List<Examen> findAll();
    public 	Examen delete(Examen examen) ;
    public Examen update(Examen examen) ;
}
