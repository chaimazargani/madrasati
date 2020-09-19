package com.pfe.madrasati.configuration.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.pfe.madrasati.configuration.CustomUserDetailsService;

import java.io.Serializable;

import javax.annotation.Resource;

/**
 * 
 * @author mnaouali
 * @author bbarhoumi
 *
 */
@Component("authenticationProvider")
public class LimitLoginAuthenticationProviderBasicAuth extends DaoAuthenticationProvider
    implements Serializable {
  private static final long serialVersionUID = 1L;
  @Resource(name = "customUserDetailsService")
  private transient CustomUserDetailsService customUserDetailsService;

  @Autowired
  @Qualifier("customUserDetailsService")
  @Override
  public void setUserDetailsService(UserDetailsService userDetailsService) {
    super.setUserDetailsService(userDetailsService);
  }

  @Override
  public Authentication authenticate(final Authentication authentication) {
    return super.authenticate(authentication);
  }
}

