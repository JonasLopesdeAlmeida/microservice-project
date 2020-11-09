package com.jmmd.payroll.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmmd.payroll.entities.Payment;
import com.jmmd.payroll.entities.Worker;
import com.jmmd.payroll.feignclients.WorkerFeignClients;

@Service 
public class PaymentService {
	
	//get value of application.properties that contain workers rest api.
    //	@Value("${hr-workers.host}")
    //	private String workersHost;
	
	//restTemplate was replaced for Feign clients
    //	@Autowired
    //	private RestTemplate restTemplate;
	@Autowired
	private WorkerFeignClients wfc;
	
	//testing payment mock
	public Payment getPayment( long workerId, int days) {
		//creating a map of params 
       //Map<String , String> uriVariables = new HashMap<>();
       //uriVariables.put("id",""+ workerId );
		
		//getboby was used to get response body which is a type of worker.
		Worker workers = wfc.findById(workerId).getBody();
		
		return new Payment(workers.getName(), workers.getDailyIncome(), days);
		
	}
	
	
	
	
	
	
	
}
