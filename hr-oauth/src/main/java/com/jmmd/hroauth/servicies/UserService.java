package com.jmmd.hroauth.servicies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmmd.hroauth.entities.User;
import com.jmmd.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;

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
}
