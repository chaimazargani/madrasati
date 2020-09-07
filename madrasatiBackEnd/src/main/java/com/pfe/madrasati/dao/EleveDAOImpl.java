package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Eleve;
@Repository (value="eleveDAO")
@Transactional
public class EleveDAOImpl implements EleveDAO {
       @Autowired
      SessionFactory sessionFactory ;
       protected Session getCurrentSession(){
 	      return sessionFactory.getCurrentSession();
 	   }
		@Override
     public List<Eleve> getEleveByIdClasse(Integer idClasse){
			String hql1= "from Eleve E where E.classe.idClasse= :idClasse";
	    Query query = getCurrentSession().createQuery(hql1);
		    query.setParameter("idClasse", idClasse);
		    List<Eleve> results = query.list();
		    return results;


  }
		@Override
		public List<Eleve> getListEleveByIdClasse(Integer idClasse) {
			String hql1= "from Eleve E where  E.idClasse= :idClasse";
		    Query query = getCurrentSession().createQuery(hql1);
			    query.setParameter("idClasse", idClasse);
			    List<Eleve> results = (List<Eleve>) query.list();			
			    return results;
		}
    
    
    
        }	
        
        	
        	
        	
        	
        
