package com.wipro.clientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class EurekaDemoClient {
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@GetMapping("/")
	public String getWelcome() {
		return "---use /greetfromeureka1 or greetfromeureka2 to get discovered service response url---";
	}
	
	@GetMapping("/greetfromeureka1")
	public String invokeService() {
		RestTemplate restTemplate=restTemplateBuilder.build();
		//Using Eureka Server
		/*
		 * InstanceInfo
		 * instanceInfo=eurekaClient.getNextServerFromEureka("service1-app",false);
		 * String baseUrl=instanceInfo.getHomePageUrl(); baseUrl=baseUrl+"/greet";
		 * return restTemplate.getForObject(baseUrl, String.class);
		 */
		//Using Zuul API Gateway
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("zuul-gateway",false);
		String baseUrl=instanceInfo.getHomePageUrl(); 
		baseUrl=baseUrl+"/api/service1app/greet";
		System.out.println(baseUrl);
		return restTemplate.getForObject(baseUrl, String.class);
		
		
	}

}
