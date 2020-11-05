package com.jmmd.payroll.servicies;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jmmd.payroll.entities.Payment;
import com.jmmd.payroll.entities.Worker;

@Service 
public class PaymentService {
	
	//get value of application.properties that contain workers rest api.
	@Value("${hr-workers.host}")
	private String workersHost;
	
	@Autowired
	private RestTemplate restTemplate;

	//testing payment mock
	public Payment getPayment( long workerId, int days) {
		//creating a map of params 
		Map<String , String> uriVariables = new HashMap<>();
		uriVariables.put("id",""+ workerId );
		
		Worker workers = restTemplate.getForObject(workersHost +"/workers/{id}", Worker.class,uriVariables  );
		
		return new Payment(workers.getName(), workers.getDailyIncome(), days);
		
	}
	
	
	
	
	
	
	
}
