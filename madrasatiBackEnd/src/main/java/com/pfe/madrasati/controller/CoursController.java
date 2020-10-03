package com.pfe.madrasati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.madrasati.model.FileDTO;
import com.pfe.madrasati.service.CoursService;

@RestController
public class CoursController {

	@Autowired
	private CoursService coursService;
	
	
	

	@RequestMapping(value = "/getNomCours", method = RequestMethod.POST)
   public List<String> getCours(@RequestBody final FileDTO obj) {
		return coursService.getCours(obj);
	}
	

	@RequestMapping(value = "/putcours", method = RequestMethod.POST)
    public void File(@RequestParam MultipartFile file) {
		this.coursService.putCours(file);
//        if (file != null) {
//            System.out.println(file.getOriginalFilename());
//        }
//    coursService.putCours(file);
	}
	
	
	@RequestMapping(value = "/getObjectCours", method = RequestMethod.GET)
	   public byte[] getObjectCours(@RequestParam ("nomFichier") String nomFichier ) {
	   return coursService.getObjectCours(nomFichier );
		}
	
}
