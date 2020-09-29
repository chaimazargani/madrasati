package com.pfe.madrasati.configuration;

import java.io.Serializable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("Context Listener for the application")
public class MyContextListener implements ServletContextListener, Serializable {
    private static final long   serialVersionUID = 1L;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println("ContextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	System.out.println("Context Destroyed");
    }

}
