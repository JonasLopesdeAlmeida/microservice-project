package com.jmmd.workers.resouces;

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
import org.springframework.web.bind.annotation.RestController;

import com.jmmd.workers.entities.Worker;
import com.jmmd.workers.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value="/workers")
public class WorkerResource {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	//testing ribbon
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repo;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
        //testing whether worker micriservice is able to read configiration.
		logger.info("CONFIG = " + testConfig);
	    //no response body
		return ResponseEntity.noContent().build();
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
 
		List<Worker> listofworkers = repo.findAll();
		
		return ResponseEntity.ok(listofworkers);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id ){
 

		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//print the number port that is running
		logger.info("PORT = " + env.getProperty("local.server.port") );
		
		Worker obj = repo.findById(id).get();
		
		return ResponseEntity.ok(obj);
	}
	

}
