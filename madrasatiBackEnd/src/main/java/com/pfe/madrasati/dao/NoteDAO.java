package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.EleveNoteDTO;
import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.model.NoteDT;
import com.pfe.madrasati.model.NoteDTO;

public interface NoteDAO {


	List<Note> getNotByIdEleve(List<Integer> idEleveList);

	List<NoteDTO> getNoteEleve(Integer idMatier, Integer idClasse);
	 public   NoteDTO ajouterNote(NoteDTO noteDTO);

}
