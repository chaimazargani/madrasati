package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.model.NoteDT;
import com.pfe.madrasati.model.NoteDTO;
@Repository (value="noteDAO")
@Transactional
public class NoteDAOImp implements NoteDAO {
     @Autowired
    SessionFactory sessionFactory;
     
      protected Session getCurrentSession() {
	 return sessionFactory.getCurrentSession();
 }
	   @Override
      public List<Note> getNotByIdEleve(List<Integer> idEleveList){
		   String hql1="from Note N where N.idEleve in :idEleveList";
		   Query query= getCurrentSession().createQuery(hql1);
		   query.setParameterList("idEleveList", idEleveList);
		   List<Note> results= query.list();
		    return results;
	   }
			   @Override
		    public List<NoteDTO> getNoteEleve( Integer idMatier , Integer  idClasse){
				  String hql2= "select N.valeurNote as valeurNote  , E.nomEleve as nomEleve , X.nomExamen as nomExamen from Note N, Eleve E, Utilisateur U, Matier M ,  Examen X  where E.idEleve = U.idUtilisateur and E.idEleve= N.idEleve and M.idMatier= N.idMatier and M.idMatier = :idMatier and E.idClasse = :idClasse and X.idExamen = N.idExamen";
		     Query query= getCurrentSession().createQuery(hql2);
				  query.setParameter("idMatier" , idMatier);
				  query.setParameter("idClasse" , idClasse);
					query.setResultTransformer(Transformers.aliasToBean(NoteDTO.class));

				   List<NoteDTO> results= query.list();
				   return results;
				 //  return new ArrayList();
				   
			  
			  }
			   
		

			@Override
			public NoteDTO ajouterNote(NoteDTO noteDTO) {
				this.getCurrentSession().save(noteDTO);
				return noteDTO;
			}}


