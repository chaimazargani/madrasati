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
import com.pfe.madrasati.model.NoteDTO;
import com.pfe.madrasati.model.NoteEleveDTO;
import com.pfe.madrasati.model.NotePK;
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
	public List<NoteDTO> getNoteEleve(Integer idClasse) {
		String hql2 = "select "
				+ " N.valeurNote as valeurNote  ,"
				+ " E.nomEleve as nomEleve ,"
				+ " X.nomExamen as nomExamen ,"
				+ " N.notePk.idEleve as idEleve ,"
				+ " N.notePk.idExamen as idExamen ,"
				+ " N.notePk.idMatier as idMatier "
				+ " from Note N"
				+ " right join N.eleve E "
				+ " left join  N.matiere M "
				+ " left join  N.examen X "
				+ " where "
				+ " E.idClasse = :idClasse" ;
		Query query = getCurrentSession().createQuery(hql2);
		query.setParameter("idClasse", idClasse);
		query.setResultTransformer(Transformers.aliasToBean(NoteDTO.class));

		List<NoteDTO> results = query.list();
		return results;
		// return new ArrayList();

	}			   
		

			@Override
			public NoteDTO ajouterNote(NoteDTO noteDTO) {
				this.getCurrentSession().save(noteDTO);
				return noteDTO;
			}
			
			
			@Override
			public List<NoteEleveDTO> getNoteByEleve(Integer idEleve) {
				  String hql2=  "select M.nomMatier as nomMatier ,"
				  		+ " N.valeurNote as valeurNote ,"
				  		+ " E.nomExamen as nomExamen"
				  		+ " from Examen E ,"
				  		+ " Matier M ,"
				  		+ " Note N ,"
				  		+ " Eleve El "
				  		+ " where N.notePk.idMatier = M.idMatier "
				  		+ " and N.notePk.idExamen = E.idExamen  "
				  		+ " and N.notePk.idEleve = :idEleve";
				     Query query= getCurrentSession().createQuery(hql2);
						  query.setParameter("idEleve" , idEleve);
							query.setResultTransformer(Transformers.aliasToBean(NoteEleveDTO.class));

						   List<NoteEleveDTO> results= query.list();
						   return results ;
			}
			@Override
			public List<NoteDTO> sauvegarderNote(List<NoteDTO> noteDto) {
				noteDto.forEach( object -> {
					Note noteBD =  new Note() ; 
					NotePK  notePK = new NotePK() ; 

					notePK.setIdEleve(object.getIdEleve());
					notePK.setIdExamen(object.getIdExamen());
					notePK.setIdMatier(object.getIdMatier());
					noteBD.setValeurNote(object.getValeurNote());
					noteBD.setNotePK(notePK);
			     this.getCurrentSession().saveOrUpdate(noteBD);
				});
				return noteDto;
			}}


