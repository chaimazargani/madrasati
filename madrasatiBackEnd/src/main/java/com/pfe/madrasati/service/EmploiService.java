package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Event;
import com.pfe.madrasati.model.EventEleve;

public interface EmploiService {
   List<Event> getEvent( Integer idClasse   ) ;
   List<EventEleve> getEventbyeleve( Integer idEleve) ;

   public Event delete(Event event);
   public List<Event> findAll();
   public Event update(Event event);
   public Event findById(int id);
	public Event ajouterEvent(Event event);
}
