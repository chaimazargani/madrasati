package com.pfe.madrasati.dao;

import org.springframework.stereotype.Repository;

import com.pfe.madrasati.model.Utilisateur;
@Repository
public interface UtilisateurDAO  {

     Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
}
