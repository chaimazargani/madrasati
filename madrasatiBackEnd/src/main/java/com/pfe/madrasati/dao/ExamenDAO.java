package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Examen;

public interface ExamenDAO {
	public  Examen    ajouterExamen( Examen examen) ;
	public List<Examen> findAll();
    public 	Examen delete(Examen examen) ;
    public Examen update(Examen examen) ;

}
