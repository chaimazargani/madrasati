package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.EmploiDAO;
import com.pfe.madrasati.model.Event;
import com.pfe.madrasati.model.EventEleve;

@Service (value="emploiService")
public class EmploiServiceImpl implements EmploiService {

	@Autowired
	public EmploiDAO emlpoiDAO ;
	
	@Override
	  @Transactional
	public List<Event> getEvent(Integer idClasse) {
		return emlpoiDAO.getEvent(idClasse);
	}

	@Override
	@Transactional
	public Event delete(Event data) {
		// TODO Auto-generated method stub
		return (Event) emlpoiDAO.delete(data);
	}

	@Override
	@Transactional
	public List<Event> findAll() {
		// TODO Auto-generated method stub
		return ( List<Event>) emlpoiDAO.findAll() ;
	}

	@Override
	@Transactional
	public Event update(Event event) {
		return emlpoiDAO.update(event);
	}

	@Override
	@Transactional
	public Event findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Event ajouterEvent(Event event) {
		return emlpoiDAO.ajouterEvent(event) ;
	}

	@Override
	public List<EventEleve> getEventbyeleve(Integer idEleve) {
		// TODO Auto-generated method stub
		return (List<EventEleve>) emlpoiDAO.getEventbyeleve(idEleve) ;
	}

	

}
