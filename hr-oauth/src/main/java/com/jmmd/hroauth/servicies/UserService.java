package com.jmmd.hroauth.servicies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jmmd.hroauth.entities.User;
import com.jmmd.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;

	//****this implementation has been used for tests****.
	public User findByEmail(String email) {
		//communicating with hr-user Microservices
		//getBody catching user response entity 
		User user = userFeignClient.findByEmail(email).getBody();
	    if(user == null) {
	    	logger.error("Email not found: " + email);
	    	throw new IllegalArgumentException("Email not found");
	    }
	    logger.info("Email found : " + email);
	    return user;
	}

	//this is the real method and implementation for an application.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
	    if(user == null) {
	    	logger.error("Email not found: " + username);
	    	throw new UsernameNotFoundException("Email not found");
	    }
	    logger.info("Email found : " + username);
	    return user;
	}
}
