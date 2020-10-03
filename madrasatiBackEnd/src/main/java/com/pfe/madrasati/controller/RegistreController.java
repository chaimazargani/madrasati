package com.pfe.madrasati.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.model.RegsitreDTOEnseignant;
import com.pfe.madrasati.service.RegistreService;

@RestController
public class RegistreController {
	@Autowired
	private RegistreService registreService;

	private RegistreDTO registre;

	@RequestMapping(value = "/getPresenceByIdEleve", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<RegistreDTO>> getPresenceByIdEleve(@RequestParam("idClasse") Integer idClasse,
			@RequestParam("datePresenceString") String datePresenceString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
	            .withZone(ZoneId.of("UTC"));					
	       LocalDateTime datePresence = LocalDateTime.parse(datePresenceString, formatter);
  final List<RegistreDTO> dbResultList =  registreService.getPresenceByIdEleve(datePresence , idClasse);
   return  getPresenceGroupeBY(dbResultList);

	}

	public Map<String, List<RegistreDTO>> getPresenceGroupeBY(List<RegistreDTO> registreDTOList) {
		List<RegistreDTO> list = registreDTOList;

		Map<String, List<RegistreDTO>> map = list.stream().collect(Collectors.groupingBy(RegistreDTO::getNomEleve));

		return map;
	}

	@RequestMapping(value = "/sauvegarderPresence", method = RequestMethod.POST) 
	public   List<RegistreDTO> sauvegarderPresence(@RequestBody List<RegistreDTO>registreDTOList ){
	 final  List<RegistreDTO> list  = registreService.sauvegarderPresence( registreDTOList) ;
		  return  list;
	}
	
//	@RequestMapping(value = "/getPresenceByIdEleve", method = RequestMethod.GET)
//	@ResponseBody
//	public Map<String, List<RegsitreDTOEnseignant>> getPresenceByIdEnseignant(@RequestParam("idEnseiganat") Integer idEnseignat,
//			@RequestParam("datePresenceString") String datePresenceString) {
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'.000Z'")
//	            .withZone(ZoneId.of("UTC"));
//	       LocalDateTime datePresence = LocalDateTime.parse(datePresenceString, formatter);
//  final List<RegsitreDTOEnseignant> ResultList =  registreService.getPresenceByIdEnseignant(datePresence, idEnseignat);
//   return  getPresenceGroupeBYidEnseiganat(ResultList);
//
//	}
//
//	public Map<String, List<RegsitreDTOEnseignant>> getPresenceGroupeBYidEnseiganat(List<RegsitreDTOEnseignant> registreDTOList) {
//		List<RegsitreDTOEnseignant> list = registreDTOList;
//
//		Map<String, List<RegsitreDTOEnseignant>> map = list.stream().collect(Collectors.groupingBy(RegsitreDTOEnseignant::getNomEnseigant));
//
//		return map;
//	}
}
