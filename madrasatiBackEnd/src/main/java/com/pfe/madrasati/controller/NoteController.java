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

import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.model.NoteDTO;
import com.pfe.madrasati.model.NoteEleveDTO;
import com.pfe.madrasati.service.NoteService;
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
	 public  Map<String, List<NoteDTO>>getNoteEleve( @RequestParam ("idClasse")Integer  idClasse){

	final List<NoteDTO> resultList	=	noteService.getNoteEleve(idClasse);
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
	

		@RequestMapping (value = "/getNoteBYEleve", method = RequestMethod.GET)
		@ResponseBody
		 public  Map<String, List<NoteEleveDTO>>getNoteByEleve(@RequestParam ("idEleve") Integer  idEleve){

		final List<NoteEleveDTO> resultList	=	noteService.getNoteByEleve(idEleve);
		//	return new ArrayList();
		 return getNoteEleveGroupeBY(resultList) ;
		
	}
		
		public Map<String, List<NoteEleveDTO>> getNoteEleveGroupeBY(List<NoteEleveDTO> eleveNoteDtoList) {
			List<NoteEleveDTO> list = eleveNoteDtoList;

			Map<String, List<NoteEleveDTO>> map = list.stream().collect(Collectors.groupingBy(NoteEleveDTO::getNomMatier));

			return map;
		}
		@RequestMapping(value = "/SauvegarderNote", method = RequestMethod.POST)
		@ResponseBody
		public  List<NoteDTO> sauvegarderNote( @RequestBody List<NoteDTO> noteDto){
       	 List<NoteDTO> list = noteService.sauvegarderNote(noteDto);
					return list;
		}
}