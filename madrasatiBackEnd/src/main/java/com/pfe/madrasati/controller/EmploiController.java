package com.pfe.madrasati.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import com.pfe.madrasati.model.dto.EventDTO;
import com.pfe.madrasati.service.EmploiService;

@RestController
public class EmploiController {
	@Autowired
	EmploiService emploiService  ;
	
	@RequestMapping (value = "/creerEvent", method = RequestMethod.POST)
    public Event ajouterEvent(@RequestBody EventDTO event   ){
		final Event e = new Event();
		e.title = event.getTitle();
		e.start = LocalDateTime.parse(event.getStartString()).withNano(0);
		e.enddate = LocalDateTime.parse(event.getEndString()).withNano(0);
		e.idclasse = event.getIdclasse();
		e.color = event.getColor();
		return emploiService.ajouterEvent(e);
	}
	
	@RequestMapping(value = "/modifierEvent", method = RequestMethod.POST) 
   public Event  modifierEvent(@RequestBody EventDTO event){
		final Event e = new Event();
		e.id = event.getId();
		e.title = event.getTitle();
		e.start = LocalDateTime.parse(event.getStartString()).withNano(0);
		e.enddate = LocalDateTime.parse(event.getEndString()).withNano(0);
		e.idclasse = event.getIdclasse();
		e.color = event.getColor();	
		return emploiService.update(e);
	}
	@RequestMapping(value = "/modifierEventList", method = RequestMethod.POST) 
	   public List<Event>  modifierEvent(@RequestBody List<EventDTO> eventList){
		eventList.forEach((event) -> {
			final Event e = new Event();
			e.id = event.getId();
			e.title = event.getTitle();
			e.start = LocalDateTime.parse(event.getStartString()).withNano(0);
			e.enddate = LocalDateTime.parse(event.getEndString()).withNano(0);
			e.idclasse = event.getIdclasse();
			e.color = event.getColor();	
			emploiService.update(e);
		});
			return new ArrayList<>();
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
		return  emploiService.delete( data) ;
		
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
