package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.model.Utilisateur;

public interface ClasseService {
	
    public Classe delete(Classe classe);
    public List<Classe> findAll();
    public Classe update(Classe classe);
    public Classe findById(int id);
	public Classe ajouterClasse(Classe classe);
	List<MatierEnseignantClasse> getClassesByIdEnseignant (Integer idEnseignant);
	List<Classe> getClassesByIdNiveau( Integer idNiveau);
	public Classe getClasseByEleveId(Integer idUtilisateur);
	
}