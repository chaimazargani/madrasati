package com.pfe.madrasati.dao;

import java.util.List;

import com.pfe.madrasati.model.Matier;
import com.pfe.madrasati.model.MatierEnseignantClasse;

public interface MatiereDAO {

	List<MatierEnseignantClasse> getMatiereByIdEnseignant (Integer idEnseignant);

}
