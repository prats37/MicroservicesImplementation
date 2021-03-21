package com.example.hystrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GreetingService {
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@HystrixCommand(fallbackMethod="defaultGreeting")
	public String getGreeting(String username) {
		RestTemplate restTemplate=restTemplateBuilder.build();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("hystrix-rest-producer",false);
		String baseUrl=instanceInfo.getHomePageUrl();
		baseUrl=baseUrl+"/greet/"+username;
		System.out.println(baseUrl);
		return restTemplate.getForObject(baseUrl, String.class);
		
	}
	
	public String defaultGreeting(String username) {
		return "This is a default greeting message Fallback Method(Static Data)!!!";
	}

}
