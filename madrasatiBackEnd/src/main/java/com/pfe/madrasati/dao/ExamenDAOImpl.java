package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.model.Utilisateur;
@Repository ("name= examenDAO ")
@Transactional
public class ExamenDAOImpl implements ExamenDAO {

	 @Autowired
	   SessionFactory sessionFactory;
	 
	   protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
	   
	   
	   @Override
	   @Transactional
	public Examen ajouterExamen(Examen examen) {
	     this.getCurrentSession().save(examen);
		return examen ;
	}


	@Override
	public List<Examen> findAll() {
		String hql2 = " from Examen E " ;
		Query query = getCurrentSession().createQuery(hql2);		
		List<Examen> results = query.list();
		return results ;
	

}


	@Override
	@Transactional
	public Examen delete(Examen examen) {
		this.getCurrentSession().delete(examen);
        this.getCurrentSession().flush();		
        return examen;
	}


	@Override
	
	public Examen update(Examen examen) {
		this.getCurrentSession().update(examen);
		return examen;
	}
}