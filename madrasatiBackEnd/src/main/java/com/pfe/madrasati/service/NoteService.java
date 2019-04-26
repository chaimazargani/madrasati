package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Note;

public interface NoteService {

	List<Note> getNotByIdEleve(List<Integer> idEleveList);
}
