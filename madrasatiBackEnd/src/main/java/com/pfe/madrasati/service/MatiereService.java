package com.pfe.madrasati.service;

import java.util.List;

import com.pfe.madrasati.model.Matier;
import com.pfe.madrasati.model.MatierEnseignantClasse;

public interface MatiereService {
	 List<MatierEnseignantClasse> getMatiereByIdEnseignant (Integer idEnseignant);
}
