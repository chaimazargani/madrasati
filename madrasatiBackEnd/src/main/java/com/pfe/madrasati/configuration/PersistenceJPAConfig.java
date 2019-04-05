package com.pfe.madrasati.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages= "com.pfe.madrasati.dao")
@ComponentScan({"com.pfe.madrasati"})
public class PersistenceJPAConfig {
	 private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";
	    private static final String PROPERTY_NAME_DATABASE_URL = "spring.datasource.url";
	    private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";
	 
	    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	 
	    @Resource
	    private Environment env;
	 
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 
	        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
	        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
	        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
	        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
	 
	        return dataSource;
	    }
		
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource());
	        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	        entityManagerFactoryBean.setPackagesToScan(env.
	getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
	 
	        entityManagerFactoryBean.setJpaProperties(hibProperties());
	 
	        return entityManagerFactoryBean;
	    }
	    private Properties hibProperties() {
	        Properties properties = new Properties();
	        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
	        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
	        return properties;
	    }
	 
	    @Bean
	    public JpaTransactionManager transactionManager() {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	        return transactionManager;
	    }
}
