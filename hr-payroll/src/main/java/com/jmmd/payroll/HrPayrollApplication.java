package com.jmmd.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
//ther's no need RibbonClient anymore. it was replaced for eureka client
//@RibbonClient(name = "hr-worker")
//Eureka client provides load balacing
@EnableEurekaClient
@EnableFeignClients //basic anotation feign responsable to inject feign into the project.
@SpringBootApplication 
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
