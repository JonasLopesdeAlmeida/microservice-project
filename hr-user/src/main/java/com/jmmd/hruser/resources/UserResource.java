package com.jmmd.hruser.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmmd.hruser.entities.User;
import com.jmmd.hruser.repositories.UserRepository;


@RefreshScope
@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserRepository repo;

	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id ){

		User obj = repo.findById(id).get();
		
		return ResponseEntity.ok(obj);
	}
	
	
	@GetMapping(value="/search")
	//RequestParam receive ? before parameter
	public ResponseEntity<User> findByEmail(@RequestParam String email ){

		User obj = repo.findByEmail(email);
		
		return ResponseEntity.ok(obj);
	}

}
