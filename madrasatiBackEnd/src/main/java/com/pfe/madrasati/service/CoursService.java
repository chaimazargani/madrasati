package com.pfe.madrasati.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface CoursService {

	List<String> getCours( );

	void putCours(MultipartFile file);

	
	byte[] getObjectCours(String nomFichier );

	
}
