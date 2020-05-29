package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.NiveauDAO;
import com.pfe.madrasati.model.Niveau;

@Service (value="niveauService")
public class NiveauServiceImpl  implements NiveauService {
	@Autowired
	public NiveauDAO  niveauDAO ;
	
	
	





	@Override
	@Transactional
	public List<Niveau> getListNiveau(List<Integer> idNiveau) {
		// TODO Auto-generated method stub
		return niveauDAO. getListNiveau(idNiveau);
	}

}
