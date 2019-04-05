package com.pfe.madrasati.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.madrasati.model.Utilisateur;
@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur,Integer> {

	
}
