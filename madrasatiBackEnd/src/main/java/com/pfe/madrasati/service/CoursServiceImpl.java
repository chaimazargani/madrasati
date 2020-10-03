package com.pfe.madrasati.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.madrasati.configuration.FileUploader;
import com.pfe.madrasati.model.FileDTO;
@Service (value="CoursService")

public class CoursServiceImpl implements CoursService{

	@Autowired
	FileUploader  fileUploader ;
	
	
	@Override
	public List<String> getCours(final FileDTO matier ) {
		return   fileUploader.getFile(matier); 

//				    
		
	}

	@Override
	public void  putCours(MultipartFile file) {
		fileUploader.putFile(file); 
	}

	@Override
	public byte[] getObjectCours(String nomFichier ) {
		try {
		InputStream fileInputStream = fileUploader.getObjectCours(nomFichier );
		byte[] bytes;
			bytes = IOUtils.toByteArray(fileInputStream);
			return bytes  ;
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
    

}