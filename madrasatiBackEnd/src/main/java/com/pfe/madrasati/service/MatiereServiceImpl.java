package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.MatiereDAO;
import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Matier;
import com.pfe.madrasati.model.MatierEnseignantClasse;
@Service (value="matiereService")
public class MatiereServiceImpl implements MatiereService {
 
	
	    @Autowired
	     MatiereDAO matiereDAO;
	    
	    @Override
	    @Transactional
        public List<MatierEnseignantClasse> getMatiereByIdEnseignant (Integer idEnseignant){
	    	List<MatierEnseignantClasse> list = (List<MatierEnseignantClasse>)  matiereDAO.getMatiereByIdEnseignant(idEnseignant);
	    	  return list;
	    	  }

		

		@Override
		public List<Matier> findAll() {
			// TODO Auto-generated method stub
			return (List<Matier>) matiereDAO.findAll() ;
		}

		@Override
		public Matier delete(Matier matier) {
			// TODO Auto-generated method stub
			return (Matier) matiereDAO.delete(matier) ;
		}

		@Override
		public Matier update(Matier matier) {
			// TODO Auto-generated method stub
			return(Matier) matiereDAO.update(matier);
		}

		@Override
		public Matier ajouterMatier(Matier matiere) {
			// TODO Auto-generated method stub
			return (Matier) matiereDAO.ajouterMatier(matiere);
		}


















}



