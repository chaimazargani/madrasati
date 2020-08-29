package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.Event;
import com.pfe.madrasati.model.EventEleve;

public interface EmploiDAO {
	   List<Event> getEvent( Integer idClasse  ) ;
	   List<EventEleve> getEventbyeleve( Integer idEleve) ;

	   public Event delete(Event data);
	   public List<Event> findAll();
	   public Event update(Event event);
	   public Event findById(int id);
		public Event ajouterEvent(Event event);

}
