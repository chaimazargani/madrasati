package com.pfe.madrasati.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.pfe.madrasati.configuration.security.AuthFailure;
import com.pfe.madrasati.configuration.security.AuthSuccess;
import com.pfe.madrasati.configuration.security.LimitLoginAuthenticationProviderBasicAuth;

//@EnableWebSecurity
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig {

//	@Autowired
//	@Qualifier("authenticationProvider")
//	LimitLoginAuthenticationProviderBasicAuth authenticationProvider;
//	
//	@Autowired
//	@Qualifier("customUserDetailsService")
//	private UserDetailsService customUserDetailsService;
//
//	@Autowired
//	private AuthSuccess authSuccess;
//
//	@Autowired
//	private AuthFailure authFailure;
//	
//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.authenticationProvider(authenticationProvider);
//	        auth.userDetailsService(customUserDetailsService);
//	        super.configure(auth);
//	}
//
//	@Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//          .csrf().disable()
//          .authorizeRequests()
//          .antMatchers("/admin/**").hasRole("ADMIN")
//          .antMatchers("/anonymous*")
//          .anonymous()
//          .antMatchers("/login*").permitAll()
//          .anyRequest().authenticated()
//          .and()
//          .formLogin()
//          .loginPage("/login")
//          .successHandler(this.authSuccess)
//          .failureHandler(this.authFailure)
//          .and()
//          .logout()
//          .logoutUrl("/perform_logout")
//          .deleteCookies("JSESSIONID");
//    }

}
