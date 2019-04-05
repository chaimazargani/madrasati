package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Classe;

public interface ClasseService {
	
    public Classe delete(int id);
    public List<Classe> findAll();
    public Classe update(Classe classe);
    public Classe findById(int id);
	public Classe ajouterClasse(Classe classe);
 
}
