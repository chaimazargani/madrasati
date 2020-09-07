package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.EleveNoteDTO;
import com.pfe.madrasati.model.Note;
import com.pfe.madrasati.model.NoteDT;
import com.pfe.madrasati.model.NoteDTO;
import com.pfe.madrasati.model.NoteEleveDTO;
import com.pfe.madrasati.model.Utilisateur;

public interface NoteService {

	List<Note> getNotByIdEleve(List<Integer> idEleveList);
	List<NoteEleveDTO> getNoteByEleve(Integer idEleve);

	List<NoteDTO> getNoteEleve( Integer idClasse);
	
	public Note create(Note note);
    public 	Note delete(int id) ;
    public List<Note> findAll();
    public Note update(Note note) ;
    public Note findById(int id);
   public  NoteDTO ajouterNote(NoteDTO noteDTO);
   List<NoteDTO> sauvegarderNote(List<NoteDTO> noteDto);
}
