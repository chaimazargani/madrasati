package com.pfe.madrasati.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.pfe.madrasati.configuration.filters.CORSFilter;
import com.pfe.madrasati.configuration.security.AuthFailure;
import com.pfe.madrasati.configuration.security.AuthSuccess;
import com.pfe.madrasati.configuration.security.LimitLoginAuthenticationProviderBasicAuth;
import com.pfe.madrasati.configuration.security.LogoutSuccess;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationProvider")
	LimitLoginAuthenticationProviderBasicAuth authenticationProvider;
	
	@Autowired
	@Qualifier("corsFilter")
	private CORSFilter corsFilter;
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;

	@Autowired
	private AuthSuccess authSuccess;

	@Autowired
	private LogoutSuccess logoutSuccess;

	@Autowired
	private AuthFailure authFailure;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			this.authenticationProvider.setPasswordEncoder(passwordEncoder());
	        auth.authenticationProvider(authenticationProvider);
	        auth.userDetailsService(customUserDetailsService);
	        super.configure(auth);
	}

	@Override
    protected void configure(final HttpSecurity http) throws Exception {
		http.addFilterBefore(this.corsFilter, ChannelProcessingFilter.class);

        http
          .csrf().disable()
          .authorizeRequests()
//          .antMatchers("/admin/**").hasRole("ADMIN")
//          .antMatchers("/anonymous*")
//          .anonymous()
          .antMatchers("/login*","/logout*").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .successHandler(this.authSuccess)
          .failureHandler(this.authFailure)
          .and()
          .logout()
          .logoutUrl("/logout")
          .logoutSuccessHandler(this.logoutSuccess)
          .deleteCookies("JSESSIONID");
    }

}
