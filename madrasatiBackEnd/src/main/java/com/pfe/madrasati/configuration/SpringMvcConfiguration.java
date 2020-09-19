package com.pfe.madrasati.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@EnableWebMvc 
@ComponentScan(basePackages = "com.pfe.madrasati")
public class SpringMvcConfiguration {
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		   CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		    commonsMultipartResolver.setDefaultEncoding("utf-8");
		    commonsMultipartResolver.setMaxUploadSize(50000000);
		    return commonsMultipartResolver;
	}

}