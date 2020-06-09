package com.pfe.madrasati.controller;

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

import com.pfe.madrasati.model.EleveNoteDTO;
import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.model.NoteDT;
import com.pfe.madrasati.model.NoteDTO;
import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.model.Utilisateur;
import com.pfe.madrasati.service.NoteService;
import com.pfe.madrasati.service.UtilisateurService;
@RestController

public class NoteController {
	@Autowired
	NoteService noteService ;
	
	private  NoteDTO Note ;
	@RequestMapping (value = "/getNoteByIdenseignant", method = RequestMethod.GET)
	@ResponseBody
	public 	List<Note> getNotByIdEleve(@RequestParam ("idEleveList") List<Integer> idEleveList) {
			 List<Note> list =   noteService.getNotByIdEleve(idEleveList);
			 return list ;
        // return new ArrayList();
}
	@RequestMapping (value = "/getNoteEleve", method = RequestMethod.GET)
	@ResponseBody
	 public  Map<String, List<NoteDTO>>getNoteEleve(@RequestParam ("idMatier")Integer idMatier , @RequestParam ("idClasse")Integer  idClasse){

	final List<NoteDTO> resultList	=	noteService.getNoteEleve( idMatier , idClasse);
	//	return new ArrayList();
	 return getNoteGroupeBY(resultList) ;
	
}
	
	public Map<String, List<NoteDTO>> getNoteGroupeBY(List<NoteDTO> eleveNoteDtoList) {
		List<NoteDTO> list = eleveNoteDtoList;

		Map<String, List<NoteDTO>> map = list.stream().collect(Collectors.groupingBy(NoteDTO::getNomEleve));

		return map;
	}

		
		@RequestMapping(value = "/ajouterNote", method = RequestMethod.POST)
		public NoteDTO  Saveutilisateur(@RequestBody NoteDTO noteDTO) {
			return noteService.ajouterNote( noteDTO);
		}
	
}