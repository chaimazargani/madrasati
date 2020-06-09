package com.pfe.madrasati.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.UtilisateurDAO;
import com.pfe.madrasati.model.Utilisateur;
 
@Service (value="utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService  {
	
	@Autowired
	    private UtilisateurDAO utilisateurDAO;
	 
	    @Override
	    @Transactional
	    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur ) {
	    	//utilisateur.setIdUtilisateur(5252);
	        return (Utilisateur) utilisateurDAO.ajouterUtilisateur(utilisateur);

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
		@Transactional
		public List<Utilisateur> findAll() {
       return (List<Utilisateur>) utilisateurDAO.findAll();
		//	return null;
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
