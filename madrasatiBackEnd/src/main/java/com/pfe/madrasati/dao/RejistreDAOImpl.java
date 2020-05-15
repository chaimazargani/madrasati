package com.pfe.madrasati.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.configuration.AliasToBeanNestedResultTransformer;
import com.pfe.madrasati.model.RegistreDTO;

@Repository(value = "registreDAO")
@Transactional
public class RejistreDAOImpl implements RegistreDAO {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<RegistreDTO> getPresenceByIdEleve(LocalDateTime datePresence, List<Integer> idEleve) {
//		String hql2 = "select U.nom as nom, E.nomEtat as nometat, R.datePresence as datepresence from Utilisateur U , Etat E , Registre R , Eleve EL where U.idUtilisateur = EL.idEleve and EL.idEleve = R.idEleve and R.idEtat = E.idEtat and R.datePresence ='2020-10-19 08:00:00+01' and R.idEleve in (2) ";
		String hql2 = "select EL.idEleve as col_1_0_, E.nomEtat as col_0_0_, R.registrePk.datePresence as col_2_0_ from Etat E , Registre R , Eleve EL where EL.idEleve = R.registrePk.idEleve and R.registrePk.idEtat = E.idEtat and R.registrePk.datePresence ='2020-10-19 08:00:00+01' and R.registrePk.idEleve in (2) ";
		Query query = getCurrentSession().createQuery(hql2);
		//query.setParameter("datePresence", datePresence);
		//query.setParameter("idEleve", idEleve);
//		query.setResultTransformer(Transformers.aliasToBean(RegistreDTO.class));
		List<RegistreDTO> results = query.list();
		return results;

	}

}
