package com.pfe.madrasati.dao;
import java.util.List;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.MatierEnseignantClasse;
public interface ClasseDAO {
	
	Classe ajouterClasse(Classe classe);
	List<MatierEnseignantClasse> getClassesByIdEnseignant (Integer idEnseignant);
	 List<Classe> getClassesByIdNiveau(Integer idNiveau);
	   public List<Classe> findAll();
	   public Classe delete(Classe classe);
	   public Classe update(Classe classe);
	   Eleve getClasseByEleveId(Integer idEleve);
}