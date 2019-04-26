package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.Note;

public interface NoteDAO {


	List<Note> getNotByIdEleve(List<Integer> idEleveList);

}
