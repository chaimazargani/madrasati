package com.pfe.madrasati.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.RegistreDAO;
import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.RegistreDTO;

@Service(value = "registreService")

public class RegsitreServiceImpl implements RegistreService {

	@Autowired
	private RegistreDAO registreDAO;

	List<Integer> ListIdEleve;
	  Integer  idClasse ; 

	@Override
	@Transactional

	public List<RegistreDTO> getPresenceByIdEleve(LocalDateTime datePresence, Integer idClasse) {
      List<Eleve> list1 =  registreDAO.getListEleveByIdClasse(idClasse);
   List<RegistreDTO> list = registreDAO.getPresenceByIdEleve(datePresence, list1);
		return list ;
	}

}
