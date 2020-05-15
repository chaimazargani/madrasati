package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Activite;
@Transactional
@Repository  (value="activiteDAO")
public class ActiviteDAOImpl implements ActiviteDAO  {
	   @Autowired
	   SessionFactory sessionFactory;
	 
	   protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
	@Override
	public List<Activite> getActivites(Integer idEnseignant) {
		 
    String hql = "From Activite where idEnseignant = :a";
    Query query = getCurrentSession().createQuery(hql);
    query.setParameter("a",idEnseignant);
    List<Activite> results = query.list();
	return results;
	}

	
	
  

}
