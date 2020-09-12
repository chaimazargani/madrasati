package com.pfe.madrasati.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface CoursService {

	List<String> getCours();

	void putCours(MultipartFile file);

	
	File getObjectCours(String nomFichier);

	
}
