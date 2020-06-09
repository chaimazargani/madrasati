package com.pfe.madrasati.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.NoteDAO;
import com.pfe.madrasati.model.EleveNoteDTO;
import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.model.NoteDT;
import com.pfe.madrasati.model.NoteDTO;
import com.pfe.madrasati.model.Utilisateur;

@Service (value="noteService")
public class NoteServiceImpl implements NoteService {
	
            @Autowired
            NoteDAO noteDAO ;
            
            
   @Override
   @Transactional
     public 	List<Note> getNotByIdEleve(List<Integer> idEleveList){
	  List<Note> list= (List<Note>) noteDAO.getNotByIdEleve(idEleveList);
		return list ; 

   }
   
   @Override
   @Transactional
   public List<NoteDTO> getNoteEleve( Integer idMatier , Integer  idClasse){
	    
	   List<NoteDTO> list =   (List<NoteDTO>) noteDAO.getNoteEleve(idMatier, idClasse);
	  
			   return list ;
   
   }

@Override
public Note create(Note note) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Note delete(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Note> findAll() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Note update(Note note) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Note findById(int id) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public NoteDTO ajouterNote(NoteDTO noteDTO) {
	// TODO Auto-generated method stub
	return (NoteDTO) noteDAO.ajouterNote( noteDTO);
}


   
   
   
   
   
}
