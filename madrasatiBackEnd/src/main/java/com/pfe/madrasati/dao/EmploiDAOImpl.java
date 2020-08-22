package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Event;
import com.pfe.madrasati.model.EventEleve;
import com.pfe.madrasati.model.Examen;
@Repository ("name= emploiDAO ")
@Transactional
public class EmploiDAOImpl implements EmploiDAO {
	
	@Autowired
	   SessionFactory sessionFactory;
	 
	   protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }

	@Override
	public List<Event> getEvent(Integer idClasse ){
		String hql1 = " from  Event E  where idClasse = :idClasse";
		Query query = getCurrentSession().createQuery(hql1);
		query.setParameter("idClasse", idClasse);
		List<Event> results = query.list();
				return results;
	}

	@Override
	public Event delete(Event event) {
		this.getCurrentSession().delete(event);
        this.getCurrentSession().flush();		
        return event;
	}

	@Override
	public List<Event> findAll() {
		String hql2 = " from Event E " ;
		Query query = getCurrentSession().createQuery(hql2);		
		List<Event> results = query.list();	
		return results;
	}

	@Override
	public Event update(Event event) {
		this.getCurrentSession().update(event);
		return event;
	}

	@Override
	public Event findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event ajouterEvent(Event event) {
		this.getCurrentSession().save(event);		
		return event;
	}

	@Override
	public List<EventEleve> getEventbyeleve(Integer idEleve) {
		String hql1 = " from  EventEleve E  where idEleve = :idEleve ORDER BY E.nomEleve";
		Query query = getCurrentSession().createQuery(hql1);
		query.setParameter("idEleve", idEleve);
		List<EventEleve> results = query.list();
		return results;
	}

	

}
