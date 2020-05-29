package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Niveau;

@Repository(value="niveauDAO")
@Transactional
public class NiveauImpl implements NiveauDAO {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	

	@Override
	public List<Niveau> getListNiveau(List<Integer> idNiveau) {
		String hql1 = "from  Niveau N where idNiveau in (1,2,3,4,5,6) order by N.nomNiveau";
		Query query = getCurrentSession().createQuery(hql1);
	//	query.setParameterList("idNiveau", idNiveau);
		List<Niveau> results = query.list();		
		return results;
	}

}
