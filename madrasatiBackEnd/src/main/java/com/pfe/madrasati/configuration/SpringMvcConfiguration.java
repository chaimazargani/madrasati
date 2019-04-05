package com.pfe.madrasati.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@EnableWebMvc 
@ComponentScan(basePackages = "com.pfe.madrasati")
public class SpringMvcConfiguration  {
	

}