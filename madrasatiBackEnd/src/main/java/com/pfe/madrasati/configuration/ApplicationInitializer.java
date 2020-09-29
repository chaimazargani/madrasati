package com.pfe.madrasati.configuration;

import java.util.TimeZone;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		this.setTimezoneApp();
		super.onStartup(servletContext);
		servletContext.addListener(new RequestContextListener());
	}

	/**
	 * set the Timezone of the application
	 */
	private void setTimezoneApp() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	}

}
