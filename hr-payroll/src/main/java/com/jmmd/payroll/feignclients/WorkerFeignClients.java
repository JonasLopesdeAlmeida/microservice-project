package com.jmmd.payroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmmd.payroll.entities.Worker;




@Component //component managed by spring
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClients {
	
	//declaring webservice type tha come from to workers microservice
	@GetMapping(value="/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id );
	

}
