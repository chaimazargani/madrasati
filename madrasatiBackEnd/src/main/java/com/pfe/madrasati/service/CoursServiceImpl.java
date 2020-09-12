package com.pfe.madrasati.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.madrasati.configuration.FileUploader;

import io.minio.Result;
import io.minio.messages.Item;
@Service (value="CoursService")

public class CoursServiceImpl implements CoursService{

	@Autowired
	FileUploader  fileUploader ;
	
	
	@Override
	public List<String> getCours() {
		return   fileUploader.getFile(); 

//				    
		
	}

	@Override
	public void  putCours(MultipartFile file) {
		fileUploader.putFile(file); 
	}

	@Override
	public File getObjectCours(String nomFichier) {
		InputStream   cours = fileUploader.getObjectCours(nomFichier);
		
		File targetFile = new File("newName.docx");
//		 
		    try {
				java.nio.file.Files.copy(
						cours, 
				  targetFile.toPath(), 
				  StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		    IOUtils.closeQuietly(cours);	
		    return targetFile  ;
	}
    

}