package com.pfe.madrasati.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.MatierEnseignantClasse;
import com.pfe.madrasati.model.Niveau;
import com.pfe.madrasati.model.Utilisateur;
@Repository  (value="classeDAO")
@Transactional
public class ClasseDAOImpl implements ClasseDAO{
	   @Autowired
	   SessionFactory sessionFactory;
	 
	   protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
		@Override
		   @Transactional
    public Classe ajouterClasse(Classe classe) {
			this.getCurrentSession().save(classe);
          return classe ;
			
}	
		@Override
	public List<MatierEnseignantClasse> getClassesByIdEnseignant (Integer idEnseignant, Integer idMatier) {
         String hql2 ="from MatierEnseignantClasse MEC where MEC.enseignant.idEnseignant= :idEnseignant and MEC.matier.idMatier= :idMatier";
		    Query query = getCurrentSession().createQuery(hql2);
		    query.setParameter("idEnseignant",idEnseignant);
		    query.setParameter("idMatier",idMatier);
		    List<MatierEnseignantClasse> results = query.list();
               return results;
}
		@Override
		public List<Classe> getClassesByIdNiveau(Integer idNiveau) {
			String hql1 = " from  Classe C  where idNiveau = :idNiveau ORDER BY C.nomClasse";
			Query query = getCurrentSession().createQuery(hql1);
			query.setParameter("idNiveau", idNiveau);
			List<Classe> results = query.list();		
			return results;
		}
		@Override
		public List<Classe> findAll() {
			String hql2 = " from Classe C " ;
			Query query = getCurrentSession().createQuery(hql2);
			List<Classe> results = query.list();
			return results ;
		}
		@Override
		@Transactional
		public Classe delete(Classe classe) {
			this.getCurrentSession().delete(classe);
            this.getCurrentSession().flush();		
			return classe ;
		}
		@Override
		@Transactional
		public Classe update(Classe classe) {
			this.getCurrentSession().update(classe);
			return classe ;
		}
		
}
