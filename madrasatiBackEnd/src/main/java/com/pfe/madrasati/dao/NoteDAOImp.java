package com.pfe.madrasati.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.model.EleveNoteDTO;
import com.pfe.madrasati.model.Note;
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
		   String hql1="from Note N where N.eleve.idEleve in :idEleveList";
		   Query query= getCurrentSession().createQuery(hql1);
		   query.setParameterList("idEleveList", idEleveList);
		   List<Note> results= query.list();
		    return results;
	   }
			   @Override
		    public List<EleveNoteDTO> getNoteEleve( Integer idMatier , Integer  idClasse){
				   String hql2= "select N.idNote , E.idEleve , N.nomNote, N.valeurNote, U.nom, U.prenom "
				   		+ "from Note N, Eleve E, Utilisateur U, Matier M "
				   		+ "where E.idEleve = U.idUtilisateur and E.idEleve= N.eleve.idEleve and M.idMatier= N.matier.idMatier and M.idMatier = :idMatier and E.classe.idClasse = :idClasse"; 
				   Query query= getCurrentSession().createQuery(hql2);
				   query.setParameter("idMatier" , idMatier);
				   query.setParameter("idClasse" , idClasse);
				   List<EleveNoteDTO> results= query.list();
				   return results;
				   
				   
			   }
}


