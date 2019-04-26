package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.EleveDAO;
import com.pfe.madrasati.model.Eleve;
@Service("name= eleveService")
public class EleveServiceImlp implements EleveService {
@Autowired
  EleveDAO eleveDAO ;

    @Override
    @Transactional
	 public List<Eleve> getEleveByIdClasse(Integer idClasse) {
	 List<Eleve> list = (List<Eleve>)  eleveDAO.getEleveByIdClasse(idClasse);
     return list ;

    }
}
