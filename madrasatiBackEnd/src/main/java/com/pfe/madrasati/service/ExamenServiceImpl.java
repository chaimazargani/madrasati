package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.ExamenDAO;
import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.model.Utilisateur;
@Service (value="examenService")
public class ExamenServiceImpl implements ExamenService {
	
	@Autowired
	public ExamenDAO examenDAO ; 
	
	
	


	@Override
    @Transactional
	public Examen ajouterExamen(Examen examen) {
		
		return (Examen) examenDAO.ajouterExamen(examen) ; 
	}





	@Override
	public List<Examen> findAll() {
		// TODO Auto-generated method stub
		return (List<Examen>) examenDAO.findAll();
	}





	@Override
	public Examen delete(Examen examen) {
		// TODO Auto-generated method stub
		return (Examen) examenDAO.delete(examen);
	}





	@Override
	public Examen update(Examen examen) {
		// TODO Auto-generated method stub
		return (Examen) examenDAO.update(examen);
	}




	


}
