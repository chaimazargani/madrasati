package com.pfe.madrasati.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.RegistreDTO;

public interface RegistreDAO {

  // public 	List<RegistreDTO> getPresenceByIdEleve( LocalDateTime datePresence, Integer idClasse);


public List<RegistreDTO> getPresenceByIdEleve(LocalDateTime datePresence,  List<Eleve> list1);

public List<Eleve> getListEleveByIdClasse(Integer idClasse );

List<RegistreDTO> sauvegarderPresence(List<RegistreDTO> registreDTO);

}
