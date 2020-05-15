package com.pfe.madrasati.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.ClasseDAO;
import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.model.RegistreDTO;

@Service (value="classeService")
public class ClasseServiceImpl implements ClasseService {
	@Autowired
	    private ClasseDAO classeDAO;
	     private Classe  classes[];
	 
	    @Override
	    @Transactional
	    public Classe ajouterClasse(Classe classe) {
	        return (Classe) classeDAO.ajouterClasse(classe);
	        

	    }


		@Override
		public Classe delete(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Classe> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Classe update(Classe classe) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Classe findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
	    @Transactional

		public List<MatierEnseignantClasse> getClassesByIdEnseignant (Integer idEnseignant, Integer idMatier) {
			List<MatierEnseignantClasse> list = (List<MatierEnseignantClasse>)  classeDAO.getClassesByIdEnseignant(idEnseignant, idMatier);
			return list ;
					
					
		}
}
