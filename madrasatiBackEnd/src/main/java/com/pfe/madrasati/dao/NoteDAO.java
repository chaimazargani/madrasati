package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.EleveMatiereMoyenne;
import com.pfe.madrasati.model.EleveNoteDTO;
import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.model.NoteDT;
import com.pfe.madrasati.model.NoteDTO;
import com.pfe.madrasati.model.NoteEleveDTO;

public interface NoteDAO {

	List<NoteEleveDTO> getNoteByEleve(Integer idEleve);

	List<Note> getNotByIdEleve(List<Integer> idEleveList);

	List<NoteDTO> getNoteEleve( Integer idClasse);
	 public   NoteDTO ajouterNote(NoteDTO noteDTO);
	   List<NoteDTO> sauvegarderNote(List<NoteDTO> noteDto);
     List<EleveMatiereMoyenne> getMoyenne(); 
}
