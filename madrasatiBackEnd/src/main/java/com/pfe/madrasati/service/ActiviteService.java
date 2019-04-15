package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Activite;
import com.pfe.madrasati.model.Classe;

public interface ActiviteService {
	  public Classe delete(int id);
	    public List<Classe> findAll();
	    public Classe update(Classe classe);
	    public Classe findById(int id);
		public Classe ajouterClasse(Classe classe);
		public List<Activite> getActivites(Integer idEnseignant);

}
