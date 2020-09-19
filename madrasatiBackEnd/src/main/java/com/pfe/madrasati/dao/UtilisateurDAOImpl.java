package com.pfe.madrasati.dao;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Utilisateur;
@Repository("utilisateurDAO")
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
		List<Utilisateur> 	results = query.list();
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
	
	@Override
	public Utilisateur loadUserByUsername(String  username) {
		
//		String hql2 = "select U.login as login , R.nomRole as role.nomRole , A.nomAutorite as role\\.autoriteRole\\.autorite.nomAutorite from Utilisateur U , Role R , RoleAutorite RA , Autorite A where R.idRole = RA.id.idRole and U.role.idRole = R.idRole and A.idAutorite = RA.id.idAutorite" ;
		try {
			String hql2 = "from Utilisateur Where login = :nomUtilisateur" ;
		Query query = getCurrentSession().createQuery(hql2);
      query.setParameter("nomUtilisateur",username);
		return (Utilisateur) query.uniqueResult();
		} catch (Exception e) {
			throw new IllegalStateException("Error while getting user by username");
		}
	}
	
	
//	Select email from Utilisateur U where nomUtilisateur= :username 
	
	
}