package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.MatierEnseignantClasse;
@Repository ("name=MatiereDAO")
@Transactional
public class MatiereDAOImp implements MatiereDAO{
	  @Autowired
	   SessionFactory sessionFactory;
	 
	   protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
	   @Override
    public List<MatierEnseignantClasse> getMatiereByIdEnseignant (Integer idEnseignant) {
		   String hql1="from MatierEnseignantClasse MEC where MEC.enseignant.idEnseignant= :idEnseignant" ;
		   Query query = getCurrentSession().createQuery(hql1);
		    query.setParameter("idEnseignant",idEnseignant);
		    List<MatierEnseignantClasse> results = query.list();
           return results ;
		   
	   }	
    	
    }

