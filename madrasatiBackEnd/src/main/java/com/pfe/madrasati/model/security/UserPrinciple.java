package com.pfe.madrasati.model.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfe.madrasati.model.Utilisateur;

public class UserPrinciple implements UserDetails {

	 private final Utilisateur user;

	    //
	 	
	    public UserPrinciple(Utilisateur user) {
	        this.user = user;
	    }

	    //

	    public Utilisateur getUser() {
			return user;
		}

		@Override
	    public String getUsername() {
	        return user.getUsername();
	    }

	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("User"));
	        return authorities;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    //

	    public Utilisateur getAppUser() {
	        return user;
	    }
}
