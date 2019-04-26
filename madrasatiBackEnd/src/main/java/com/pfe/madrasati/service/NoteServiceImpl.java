package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.madrasati.dao.NoteDAO;
import com.pfe.madrasati.model.Note;

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
   
   
   
   
   
   
   
   
   
   
   
}
