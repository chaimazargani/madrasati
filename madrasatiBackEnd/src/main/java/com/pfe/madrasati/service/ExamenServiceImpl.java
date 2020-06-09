package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.ExamenDAO;
import com.pfe.madrasati.model.Examen;
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
	


}
