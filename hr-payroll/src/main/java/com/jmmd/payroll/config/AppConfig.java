package com.jmmd.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
     //singleton pattern
	//Single instance object injecting other components.
	@Bean
	public RestTemplate restTemplete() {
		
		return new RestTemplate();
	}
}

