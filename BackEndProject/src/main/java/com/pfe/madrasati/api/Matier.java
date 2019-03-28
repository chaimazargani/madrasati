package com.pfe.madrasati.api;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurApi {
	 private static final String template = "Hello, %s!";
	    private final utilisateur counter = new utilisateur(01,);

	    @RequestMapping("/utilisateur")
	    public utilisateur(@RequestParam(value="name", defaultValue="utilisateur") String name) {
	        return new utilisateur(counter.incrementAndGet(),
	                         String.format(template, name));
