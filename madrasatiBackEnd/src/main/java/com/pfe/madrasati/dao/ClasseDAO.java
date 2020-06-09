package com.pfe.madrasati.dao;
import java.util.List;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.model.Utilisateur;
public interface ClasseDAO {
	
	Classe ajouterClasse(Classe classe);
	List<MatierEnseignantClasse> getClassesByIdEnseignant (Integer idEnseignant, Integer idMatier);
	 List<Classe> getClassesByIdNiveau(Integer idNiveau);
	   public List<Classe> findAll();
}