package com.pfe.madrasati.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.pfe.madrasati.model.Registre;
import com.pfe.madrasati.model.RegistreDTO;

public interface RegistreDAO {

  // public 	List<RegistreDTO> getPresenceByIdEleve( LocalDateTime datePresence, Integer idClasse);


public List<RegistreDTO> getPresenceByIdEleve(LocalDateTime datePresence, List<Integer> listIdEleve1);


}
