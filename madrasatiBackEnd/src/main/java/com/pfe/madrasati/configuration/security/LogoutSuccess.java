package com.pfe.madrasati.configuration.security;

import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


/**
 * @author mnaouali
 * @author bbarhoumi
 *
 */
@Component
public class LogoutSuccess implements LogoutSuccessHandler, Serializable {
	private static final long serialVersionUID = 1L;


	@Override
	public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
		try {
			final HttpSession existingSession = httpServletRequest.getSession(false);
				if(existingSession!= null)
					existingSession.invalidate();
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception unexpected) {
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
