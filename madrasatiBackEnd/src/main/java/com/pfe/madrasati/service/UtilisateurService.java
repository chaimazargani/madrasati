package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Utilisateur;



public interface UtilisateurService {
	 
	public Utilisateur create(Utilisateur utilisateur);
    public 	Utilisateur delete(int id) ;
    public List<Utilisateur> findAll();
    public Utilisateur update(Utilisateur utilisateur) ;
    public Utilisateur findById(int id);
	Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
	
}
    