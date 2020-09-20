package com.pfe.madrasati.configuration.security;


import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author mnaouali
 * @author bbarhoumi
 */
@Component
public class AuthSuccess extends SimpleUrlAuthenticationSuccessHandler implements Serializable {
	private static final long serialVersionUID = 1L;

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	      response.setStatus(HttpServletResponse.SC_OK);    
			final String targetUrlParameter = getTargetUrlParameter();
			if (isAlwaysUseDefaultTargetUrl()
					|| (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
				requestCache.removeRequest(request, response);
    	super.onAuthenticationSuccess(request, response, authentication);
		return;
//		SavedRequest savedRequest = requestCache.getRequest(request, response);
//		try {
//			final Object principal = authentication.getPrincipal();
//			if (principal instanceof UserPrinciple) {
//				final Utilisateur user = ((UserPrinciple) principal).getAppUser();
//				final String userLogin = user.getUsername();
//				request.getSession().setAttribute("userName", userLogin);
////				user.setLastConnexionTime(new Date());
//			} else {
//				final String userName = principal.toString();
//				request.getSession().setAttribute("userName", userName);
//			}
////			request.getSession().setAttribute("TENANT_ATTRIBUTE", sessionContext.getCurrentTenant());
//			response.setStatus(HttpServletResponse.SC_OK);
//			if (savedRequest == null) {
//				super.onAuthenticationSuccess(request, response, authentication);
//				return;
//			}
//			final String targetUrlParameter = getTargetUrlParameter();
//			if (isAlwaysUseDefaultTargetUrl()
//					|| (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
//				requestCache.removeRequest(request, response);
//				super.onAuthenticationSuccess(request, response, authentication);
//				return;
//			}
//			
//		} catch (Exception exception) {
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//		}
		}
	}
}
