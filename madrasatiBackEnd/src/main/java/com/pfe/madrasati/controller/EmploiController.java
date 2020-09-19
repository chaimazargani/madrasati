package com.pfe.madrasati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.madrasati.model.Event;
import com.pfe.madrasati.model.EventEleve;
import com.pfe.madrasati.service.EmploiService;

@RestController
public class EmploiController {
	@Autowired
	EmploiService emploiService  ;
	
	@RequestMapping (value = "/creerEvent", method = RequestMethod.POST)
    public Event ajouterEvent(@RequestBody Event event   ){
		return emploiService.ajouterEvent(event);
		
	}
	
	@RequestMapping(value = "/modifierEvent", method = RequestMethod.POST) 
   public Event  modifierEvent(@RequestBody Event event){
		return  (Event) emploiService.update(event);
	  
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
	public Event _(@RequestBody  Event data ){
		return  (Event) emploiService.delete( data) ;
		
	}
	
	@RequestMapping(value = "/getEvent", method = RequestMethod.GET) 
	@ResponseBody	
	public List<Event>  Afficherlaliste(){
		List<Event> listEvent =  emploiService.findAll();
		return  listEvent ;
	}
	

	@RequestMapping (value = "/getEventByEnseignant", method = RequestMethod.GET)
	@ResponseBody
    public	List<EventEleve> getEventbyEnseignant(@RequestParam ("idEnseignant") Integer idEnseignant  ){
		return (List<EventEleve>) emploiService.getEventbyeleve(idEnseignant);
		
	}
	
}
