package com.pfe.madrasati.dao.security;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.RegistreDTO;
import com.pfe.madrasati.model.security.Autorite;

@Repository("authorizationDAOImpl")
@Transactional
public class AuthorizationDAOImpl implements AuthorizationDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Autorite> getAuthorityListByRoleId(Integer roleId) {
		try {
		final String queryString = "select A.idAutorite as idAutorite,A.nomAutorite as nomAutorite from AutoriteRole as AR ,Autorite as A where AR.id.idAutorite = A.idAutorite and AR.id.idRole = :idRole";
		Query query = getCurrentSession().createQuery(queryString);
		query.setParameter("idRole", roleId);
		query.setResultTransformer(Transformers.aliasToBean(Autorite.class));
		return query.list();
		}catch (Exception e) {
			System.out.println(e);
			throw new IllegalStateException(e);
		}
	}

	
	
}
