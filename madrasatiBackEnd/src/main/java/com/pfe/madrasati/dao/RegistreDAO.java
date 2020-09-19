package com.pfe.madrasati.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.Enseignant;
import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.model.RegsitreDTOEnseignant;

public interface RegistreDAO {

  // public 	List<RegistreDTO> getPresenceByIdEleve( LocalDateTime datePresence, Integer idClasse);


public List<RegistreDTO> getPresenceByIdEleve(LocalDateTime datePresence,  List<Eleve> list1);

public List<Eleve> getListEleveByIdClasse(Integer idClasse );

List<RegistreDTO> sauvegarderPresence(List<RegistreDTO> registreDTO);

public List<RegsitreDTOEnseignant> getPresenceByIdEnseignant(LocalDateTime datePresence, Integer idEnseignant);

}
