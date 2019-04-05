package com.pfe.madrasati.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.UtilisateurDAO;
import com.pfe.madrasati.model.Utilisateur;
 
@Service
public class UtilisateurServiceImpl implements UtilisateurService  {
	
	@Autowired
	    private UtilisateurDAO utilisateurDAO;
	 
	    @Override
	    @Transactional
	    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
	        return (Utilisateur) utilisateurDAO.save(utilisateur);
	    }
//
		@Override
		public Utilisateur create(Utilisateur utilisateur) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Utilisateur delete(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Utilisateur> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Utilisateur update(Utilisateur utilisateur) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Utilisateur findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
