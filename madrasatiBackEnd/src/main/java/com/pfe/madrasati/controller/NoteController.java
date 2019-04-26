package com.pfe.madrasati.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.service.NoteService;
@RestController

public class NoteController {
	@Autowired
	NoteService noteService ;
	
	@RequestMapping (value= "/getNoteByIdenseignant", method = RequestMethod.GET)
	@ResponseBody
	public 	List<Note> getNotByIdEleve(@RequestParam ("idEleveList") List<Integer> idEleveList) {
			
			
   return  (List<Note>)  noteService.getNotByIdEleve(idEleveList);
          
}
}