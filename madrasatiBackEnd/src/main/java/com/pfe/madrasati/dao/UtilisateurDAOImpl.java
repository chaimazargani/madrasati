package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.Utilisateur;
@Repository ("name= UtilisateurDAO ")
@Transactional
public class UtilisateurDAOImpl implements UtilisateurDAO {
	  @Autowired
	   SessionFactory sessionFactory;
	 
	   protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
	   @Override
	   @Transactional
	   public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        this.getCurrentSession().save(utilisateur);
      return utilisateur ;
}
	@Override
	public List<Utilisateur> findAll() {
		String hql2 = " from Utilisateur U " ;
		Query query = getCurrentSession().createQuery(hql2);
		List<Utilisateur> 
		results = query.list();
	return results ;
	}
	@Override
	public Utilisateur delete(Utilisateur utilisateur) {
        this.getCurrentSession().delete(utilisateur);
        this.getCurrentSession().flush();		

		return utilisateur;
	}
	@Override
	public Utilisateur update(Utilisateur utilisateur) {
        this.getCurrentSession().update(utilisateur);
		return utilisateur ;
	}
	
	
	
	
	
	
	
	
}