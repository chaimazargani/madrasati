package com.pfe.madrasati.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.model.RegsitreDTOEnseignant;


public interface RegistreService {
	
	public List<RegistreDTO> getPresenceByIdEleve( LocalDateTime datePresence , Integer idClasse);
	List<RegistreDTO> sauvegarderPresence(List<RegistreDTO> registreDTO);
	public List<RegistreDTO> getPresence( String datePresence , Integer idClasse);
	public List<RegsitreDTOEnseignant> getPresenceByIdEnseignant( LocalDateTime datePresence , Integer idEnseignat);

}
