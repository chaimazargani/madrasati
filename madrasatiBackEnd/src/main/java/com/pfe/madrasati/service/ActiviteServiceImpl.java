package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.ActiviteDAO;
import com.pfe.madrasati.model.Activite;
import com.pfe.madrasati.model.Classe;

@Service (value="activiteService")
public class ActiviteServiceImpl implements ActiviteService {
	@Autowired
    private ActiviteDAO activiteDAO;
	
  	
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
	public Classe ajouterClasse(Classe classe) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public List<Activite> getActivites(Integer idEnseignant) {
		List<Activite> list = (List<Activite>)  activiteDAO.getActivites(idEnseignant);
		return list;
	} 
	
}
