package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Examen;
import com.pfe.madrasati.model.Matier;
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
		   String hql1=" from MatierEnseignantClasse MEC  where MEC.enseignant.idEnseignant= :idEnseignant " ;
		   Query query = getCurrentSession().createQuery(hql1);
		    query.setParameter("idEnseignant",idEnseignant);
		    List<MatierEnseignantClasse> results = query.list();
           return results ;
		   
	   }
	@Override
	public Matier ajouterExamen(Matier matier) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Matier> findAll() {
		String hql2 = " from Matier E " ;
		Query query = getCurrentSession().createQuery(hql2);		
		List<Matier> results = query.list();
		return results ;
	

}
	@Override
	@Transactional
	public Matier delete(Matier matier) {
		this.getCurrentSession().delete(matier);
        this.getCurrentSession().flush();		
        return matier ;
	}
	@Override
	public Matier update(Matier matier) {
		this.getCurrentSession().update(matier);		
		return matier;
	}	
    	
    }

