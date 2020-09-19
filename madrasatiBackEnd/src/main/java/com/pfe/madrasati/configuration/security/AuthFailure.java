package com.pfe.madrasati.configuration.security;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


/**
 * @author mnaouali
 * @author bbarhoumi
 */
@Component
public class AuthFailure extends SimpleUrlAuthenticationFailureHandler  implements Serializable {
	private static final long serialVersionUID = 1L;


  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {  
	  
    final String username = request.getParameter("username");
    final String errorMessage = String.format("User[%s] got AuthenticationException! %s",
    		username, exception.getMessage());
    
    setResponse(request, response, errorMessage, "msgAuthenticationException",
    		HttpServletResponse.SC_UNAUTHORIZED);
  }

  void setResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage,
      String loginErrorMessage, int status) throws IOException {
	  
		response.setStatus(status);
		response.setContentType("application/json");
  }
} 
