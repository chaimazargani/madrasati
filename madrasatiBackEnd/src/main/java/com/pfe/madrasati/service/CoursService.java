package com.pfe.madrasati.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pfe.madrasati.model.FileDTO;

public interface CoursService {

	List<String> getCours(final FileDTO matier);

	void putCours(MultipartFile file);

	
	byte[] getObjectCours(String nomFichier );

	
}
