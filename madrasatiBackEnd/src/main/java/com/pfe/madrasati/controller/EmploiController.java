package com.pfe.madrasati.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.Event;
import com.pfe.madrasati.model.EventEleve;
import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.service.EmploiService;

@RestController
public class EmploiController {
	@Autowired
	EmploiService emploiService  ;
	
	@RequestMapping (value = "/creerEvent", method = RequestMethod.GET)
	@ResponseBody
    public	List<Event> ajouterEvent(@RequestParam ("event") Event event   ){
		return (List<Event>) emploiService.ajouterEvent(event);
		
	}
	
	@RequestMapping(value = "/modifierEvent", method = RequestMethod.POST) 
	@ResponseBody
   public Event  modifierEvent(@RequestParam ("event") Event event  ){
	return  (Event) emploiService.update( event) ;
		
	}
	@RequestMapping (value = "/getEventByClasse", method = RequestMethod.GET)
	@ResponseBody
    public	List<Event> getEvent(@RequestParam ("idClasse") Integer idClasse  ){
		List<Event> listEvent =  emploiService.getEvent(idClasse); 
		return listEvent ;
		
	}
	
	
	@RequestMapping (value = "/getEventByEleve", method = RequestMethod.GET)
	@ResponseBody
    public	List<EventEleve> getEventbyeleve(@RequestParam ("idEleve") Integer idEleve  ){
		return (List<EventEleve>) emploiService.getEventbyeleve(idEleve);
		
	}
	
	
	@RequestMapping(value = "/supprimerEvent", method = RequestMethod.POST) 
	@ResponseBody
	public Event _(@RequestBody Event event ){
		return  (Event) emploiService.delete( event) ;
		
	}
	
	@RequestMapping(value = "/getEvent", method = RequestMethod.GET) 
	@ResponseBody	
	public List<Event>  Afficherlaliste(){
		List<Event> listEvent =  emploiService.findAll();
		return  listEvent ;
	}
}
