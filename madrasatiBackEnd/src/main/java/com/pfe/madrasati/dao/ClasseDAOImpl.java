package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Classe;
import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.MatierEnseignantClasse;

@Repository(value = "classeDAO")
@Transactional
public class ClasseDAOImpl implements ClasseDAO {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public Classe ajouterClasse(Classe classe) {
		this.getCurrentSession().saveOrUpdate(classe);
		return classe;

	}

	@Override
	public List<MatierEnseignantClasse> getClassesByIdEnseignant(Integer idEnseignant) {
		String hql2 = "from MatierEnseignantClasse MEC where MEC.matierEnseignantClassePk.idEnseignant= :idEnseignant";
		Query query = getCurrentSession().createQuery(hql2);
		query.setParameter("idEnseignant", idEnseignant);
		return query.list();
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
		String hql2 = " from Classe C ";
		Query query = getCurrentSession().createQuery(hql2);
		List<Classe> results = query.list();
		return results;
	}

	@Override
	@Transactional
	public Classe delete(Classe classe) {
		this.getCurrentSession().delete(classe);
		this.getCurrentSession().flush();
		return classe;
	}

	@Override
	@Transactional
	public Classe update(Classe classe) {
		this.getCurrentSession().saveOrUpdate(classe);
		return classe;
	}

	@Override
	@Transactional
	public Eleve getClasseByEleveId(final Integer idEleve) {
		String queryString = "from Eleve where idEleve = :idEleve";
		Query query = this.getCurrentSession().createQuery(queryString);
		query.setParameter("idEleve", idEleve);
		return (Eleve) query.uniqueResult();
	}
}
