package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.Niveau;

public interface NiveauDAO {
	List<Niveau>	getListNiveau(List<Integer>idNiveau);

}
