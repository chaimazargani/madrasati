package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.model.Utilisateur;

public interface ClasseService {
	
    public Classe delete(int id);
    public List<Classe> findAll();
    public Classe update(Classe classe);
    public Classe findById(int id);
	public Classe ajouterClasse(Classe classe);
	List<MatierEnseignantClasse> getClassesByIdEnseignant (Integer idEnseignant, Integer idMatier);
	List<Classe> getClassesByIdNiveau( Integer idNiveau);
	
}