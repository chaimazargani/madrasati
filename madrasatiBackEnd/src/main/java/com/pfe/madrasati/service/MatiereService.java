package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.model.Matier;
import com.pfe.madrasati.model.MatierEnseignantClasse;

public interface MatiereService {
	 List<MatierEnseignantClasse> getMatiereByIdEnseignant (Integer idEnseignant);
		public  Matier   ajouterMatier( Matier matiere) ;
	    public List<Matier> findAll();
	    public 	Matier delete(Matier matier) ;
	    public Matier update(Matier matier) ;
}
