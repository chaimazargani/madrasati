package com.pfe.madrasati.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.RegistreDAO;
import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.model.RegsitreDTOEnseignant;

@Service(value = "registreService")

public class RegsitreServiceImpl implements RegistreService {

	@Autowired
	private RegistreDAO registreDAO;

	List<Integer> ListIdEleve;
	Integer idClasse;

	@Override
	@Transactional

	public List<RegistreDTO> getPresenceByIdEleve(LocalDateTime datePresence, Integer idClasse) {
		List<Eleve> list1 = registreDAO.getListEleveByIdClasse(idClasse);
		if (list1.size() > 0) {
			List<RegistreDTO> list = registreDAO.getPresenceByIdEleve(datePresence, list1);
			list.forEach(object -> {
				LocalDateTime dateP = object.getDatePresence();
				Timestamp datePT = Timestamp.valueOf(dateP);
				object.setDatePresenceTimeStamp(datePT);
			});
			return list;
		}
		return new ArrayList<>();
	}

	@Override
	@Transactional
	public List<RegistreDTO> sauvegarderPresence(List<RegistreDTO> registreDTOList) {
		registreDTOList.forEach(object -> {
			Timestamp datePT = object.getDatePresenceTimeStamp();
			LocalDateTime dateP = datePT.toLocalDateTime();
			object.setDatePresence(dateP);

		});
		List<RegistreDTO> list = registreDAO.sauvegarderPresence(registreDTOList);

		return list;
	}

	@Override
	public List<RegistreDTO> getPresence(String datePresence, Integer idClasse) {
		return null;
	}

	@Override
	public List<RegsitreDTOEnseignant> getPresenceByIdEnseignant(LocalDateTime datePresence, Integer idEnseignant) {
		return registreDAO.getPresenceByIdEnseignant(datePresence, idEnseignant);
	}

}
