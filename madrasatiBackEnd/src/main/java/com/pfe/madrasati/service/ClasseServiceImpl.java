package com.pfe.madrasati.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.ClasseDAO;
import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.MatierEnseignantClasse;

@Service (value="classeService")
public class ClasseServiceImpl implements ClasseService {
	@Autowired
	    private ClasseDAO classeDAO;
	     private Classe  classes[];
	 
	    @Override
	    @Transactional
	    public Classe ajouterClasse(Classe classe) {
	   //	classe.setIdClasse(23);
	        return (Classe) classeDAO.ajouterClasse(classe);
	        

	    }


		

		@Override
		public List<Classe> findAll() {
			return (List<Classe>) classeDAO.findAll() ;
			
		}

		@Override
		public Classe update(Classe classe) {
			// TODO Auto-generated method stub
			return (Classe) classeDAO.update( classe) ;
		}

		@Override
		public Classe findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public List<MatierEnseignantClasse> getClassesByIdEnseignant (Integer idEnseignant) {
			return classeDAO.getClassesByIdEnseignant(idEnseignant);
		}


		@Override
	    @Transactional
    	public List<Classe> getClassesByIdNiveau(Integer idNiveau) {
			// TODO Auto-generated method stub
			return classeDAO.getClassesByIdNiveau(idNiveau) ;
		}
		
		@Override
		public Classe getClasseByEleveId(Integer idEleve) {
			final Eleve eleve=  classeDAO.getClasseByEleveId(idEleve) ;
			return eleve.getClasse();
		}
		

		@Override
		public Classe delete(Classe classe) {
			// TODO Auto-generated method stub
			return  (Classe) classeDAO.delete(classe);
		}
}
