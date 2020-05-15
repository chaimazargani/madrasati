package com.pfe.madrasati.controller;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.service.RegistreService;

@RestController
public class RejistreController {
	@Autowired
	private RegistreService registreService;
	private RegistreDTO registre;

	@RequestMapping(value = "/getPresenceByIdEleve", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<RegistreDTO>> getPresenceByIdEleve(@RequestParam("idClasse") Integer idClasse,
			@RequestParam("datePresenceString") String datePresenceString) {

		OffsetDateTime offsetStartDateTime = OffsetDateTime.parse(datePresenceString);
		final LocalDateTime datePresence = offsetStartDateTime.toLocalDateTime();
		// return new ArrayList () ;
		List<RegistreDTO> registreDTOList = new ArrayList<>();
		RegistreDTO registreDTO = new RegistreDTO(datePresence, "absent", "ahmed");
		RegistreDTO registreDTO1 = new RegistreDTO(datePresence, "Absent", "amal");
		RegistreDTO registreDTO2 = new RegistreDTO(datePresence, "Absent", "chaima");
		registreDTOList.add(registreDTO);
		registreDTOList.add(registreDTO1);
		registreDTOList.add(registreDTO2);
		return  getPresenceGroupeBY(registreDTOList);

	}

	public Map<String, List<RegistreDTO>> getPresenceGroupeBY(List<RegistreDTO> registreDTOList) {
		List<RegistreDTO> list = registreDTOList;

		Map<String, List<RegistreDTO>> map = list.stream().collect(Collectors.groupingBy(RegistreDTO::getNomEleve));

		return map;
	}

//		return registreService.getPresenceByIdEleve(datePresence , idClasse);
	
}
