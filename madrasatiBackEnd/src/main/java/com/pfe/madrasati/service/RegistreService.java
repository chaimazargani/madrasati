package com.pfe.madrasati.service;

import java.time.LocalDateTime;
import java.util.List;

import com.pfe.madrasati.model.RegistreDTO;


public interface RegistreService {
	
	public List<RegistreDTO> getPresenceByIdEleve( LocalDateTime datePresence , Integer IdClass);
}
