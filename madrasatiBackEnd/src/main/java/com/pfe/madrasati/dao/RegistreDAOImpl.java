package com.pfe.madrasati.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Eleve;
import com.pfe.madrasati.model.RegistreDTO;

@Repository(value = "registreDAO")
@Transactional
public class RegistreDAOImpl implements RegistreDAO {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@Override
	public List<RegistreDTO> getPresenceByIdEleve(LocalDateTime datePresence,  List<Eleve> list1) {
		
		//LocalDateTime endOfDate = datePresence
				//  .toLocalDate().atTime(LocalTime.MAX);
		LocalDateTime datePresencePlus1 = datePresence.plusDays(1); 
		
		
//		String hql2 = "select U.nom as nom, E.nomEtat as nometat, R.datePresence as datepresence from Utilisateur U , Etat E , Registre R , Eleve EL where U.idUtilisateur = EL.idEleve and EL.idEleve = R.idEleve and R.idEtat = E.idEtat and R.datePresence ='2020-10-19 08:00:00+01' and R.idEleve in (2) ";
		String hql2 = "select R.registrePk.datePresence as datePresence ,E.nomEtat as nomEtat,EL.nomEleve as nomEleve from Etat E , Registre R , Eleve EL where EL.idEleve = R.registrePk.idEleve and R.registrePk.idEtat = E.idEtat and R.registrePk.datePresence between :datePresenceParam and :datePresencePlus1 and R.registrePk.idEleve in  :listEleve  ";
		Query query = getCurrentSession().createQuery(hql2);
		query.setParameter("datePresenceParam", datePresence.withHour(0));
		query.setParameterList("listEleve", list1);
		query.setParameter("datePresencePlus1", datePresencePlus1.withHour(0));

		query.setResultTransformer(Transformers.aliasToBean(RegistreDTO.class));
		List<RegistreDTO> results = query.list();
		return results;

	}


	@Override
	public List<Eleve> getListEleveByIdClasse(Integer idClasse) {
		String hql2 = "select E.idEleve from Eleve E where idClasse =:idClasse" ;
		Query query = getCurrentSession().createQuery(hql2);
		query.setParameter("idClasse", idClasse);
		List<Eleve> results = query.list();
		return results ;
	}
	
	
	
	
	
	

}
