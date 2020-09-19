package com.pfe.madrasati.configuration.security;


import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
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
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		/**
		 * for success authenticated users : we specify 8 hours of invactivity timout 
		 */
		if (request.getSession(false) != null) {
			request.getSession(false).setMaxInactiveInterval(28800);
		} else {
			throw new IllegalStateException(
					MessageFormat.format("{0} : {1} => Session not created for success authenticated",
							AuthSuccess.class, "onAuthenticationSuccess"));
		}
//		try {
			final Object principal = authentication.getPrincipal();
//			if (principal instanceof UserSer) {
//				final User user = ((UserBeanAbstarct) principal).getParent();
//				final String userLogin = user.getUserLogin();
//				request.getSession().setAttribute("userName", userLogin);
//				user.setLastConnexionTime(new Date());
//			} else {
//				final String userName = principal.toString();
//				request.getSession().setAttribute("userName", userName);
//			}
//			request.getSession().setAttribute("TENANT_ATTRIBUTE", sessionContext.getCurrentTenant());
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
//			final String username = request.getParameter(SecurityConstants.USER_NAME);
//			final String errorMessage = String.format("AuthSuccess.onAuthenticationSuccess for User[%s]!", username);
//
//			logger.error((ESAPI.encoder().encodeForHTML(errorMessage)), exception);
//		}
		}
}
