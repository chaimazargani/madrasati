package com.pfe.madrasati.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pfe.madrasati.configuration.filters.CORSFilter;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringMvcConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringMvcConfiguration.class };
    }
  
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CORSFilter()};
    }    
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
