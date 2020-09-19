package com.pfe.madrasati.configuration.security;

import org.springframework.http.HttpHeaders;
public interface Constants {

    String BASE_PACKAGE_THIS_WEB    = "com.pfe.madrasati.configuration";
    String BASE_PACKAGE_COMMON_WEB  = "com.pfe.madrasati.dao";
    String PREFIX                   = "/app/";
    String SUFFIX                   = ".html";
    String PATH_PATTERN             = "//**";
    String RESOURCE_LOCATION        = "//";
    String CONTENT_TYPE       	    = "text/html;charset=utf-8";

    String PATTERN                  = "/app/login/**";
    String VIEW_NAME_INDEX          = "hpo/index";
    String VIEW_NAME_LOGIN          = "login/login";
    String URL_PATH_INDEX           = "/index";
    String URL_PATH_LOGIN           = "/login";
    String URL_PATH_DEFAULT         = "/";
    String URL_PATH_DEFAULT_PATTERN = "/*";

    String HEADER_KEY_1             = HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
    String HEADER_VALUE_1           = "*";
    String HEADER_KEY_2             = HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
    String HEADER_VALUE_2           = "POST, GET, PUT, OPTIONS, DELETE";
    String HEADER_KEY_3             = HttpHeaders.ACCESS_CONTROL_MAX_AGE;
    String HEADER_VALUE_3           = "3600";
    String HEADER_KEY_4             = HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
    String HEADER_VALUE_4           = "X-CSRF-Token, x-requested-with, Content-Type";
    String HEADER_KEY_5             = HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
    String HEADER_VALUE_5           = "true";
    String HEADER_KEY_6             = HttpHeaders.CACHE_CONTROL;
    String HEADER_VALUE_6           = "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0";
    String HEADER_KEY_7             = HttpHeaders.PRAGMA;
    String HEADER_VALUE_7           = "no-cache";
    
    String OPTIONS          	    = "OPTIONS";
    String CONTEXT_PATH			    = "/hpo";
    String IGNORING_ANT_MATCHERS    = "/login/**";
    
	String COOKIE_USING_SECURE_PROTOCOL = "USING_SECURE_PROTOCOL";
	String COOKIE_DOMAIN = "COOKIE_DOMAIN";

}
