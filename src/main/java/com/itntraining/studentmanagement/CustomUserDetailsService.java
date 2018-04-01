package com.itntraining.studentmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailsService implements UserDetails{
	private String username;
	private String password;
	
	Collection<? extends GrantedAuthority> authorities;
	
	public  CustomUserDetailsService() {
	}
	public CustomUserDetailsService(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		List<GrantedAuthority> auths=new ArrayList();
        user.getRoles().forEach((role) -> {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        });
       this.authorities=auths;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
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
	

}
