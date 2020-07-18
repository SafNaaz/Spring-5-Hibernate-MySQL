package com.spring.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	public UserDetailsServiceImp() {
		// TODO Auto-generated constructor stub
	}
	  @Transactional(readOnly = true)
	  @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	    
		  System.out.println(username);
	    UserBuilder builder = null;
	    if (username!=null && username.equalsIgnoreCase("admin")) {
	    	System.out.println("Entered for authentication");
	      
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.disabled(false);
	      builder.password(new BCryptPasswordEncoder().encode("admin@123#"));
	      builder.authorities(new String[] {"ROLE_ADMIN"});
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }
	    return builder.build();
	  }

}
