package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.Eleve;

public interface EleveDAO {

	List<Eleve> getEleveByIdClasse(Integer idClasse);

}
