package com.wipro.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wipro.eurekaclient.entity.Price;

@RestController
public class EurekaClientController {
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	
	
	  @Autowired 
	  RestTemplate restTemplate;
	 
	 
	
	
		
	  @Bean
	  @LoadBalanced 
	  RestTemplate restTemplate() {
		  return new RestTemplate();
	  }
		 
	 
	
	@GetMapping("/")
	public String getWelcome() {
		return "### Greeting from Eureka Client ###";
	}
	
	@HystrixCommand(fallbackMethod="defaultMessage")
	@PostMapping("/addproductprice")
	public ResponseEntity<Price> invokeServiceAddPrice(@RequestBody Price price) {
		//RestTemplate restTemplate=restTemplateBuilder.build();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PriceService",false);
		String baseUrl=instanceInfo.getHomePageUrl(); 
		baseUrl=baseUrl+"/price/add";
		//System.out.println(baseUrl);
		return this.restTemplate.postForEntity(baseUrl, price, Price.class);
		
	}
	
	//@HystrixCommand(fallbackMethod="defaultMessage")
	@PostMapping("/viewproductprice")
	public ResponseEntity<Price> invokeServiceViewPrice(@RequestBody Price price) {
		//RestTemplate restTemplate=restTemplateBuilder.build();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PriceService",false);
		String baseUrl=instanceInfo.getHomePageUrl(); 
		baseUrl=baseUrl+"/price/view";
		//System.out.println(baseUrl);
		return this.restTemplate.postForEntity(baseUrl, price, Price.class);
		
	}
	
	//@HystrixCommand(fallbackMethod="defaultMessage")
	@PostMapping("/updateproductprice")
	public ResponseEntity<Price> invokeServiceUpdatePrice(@RequestBody Price price) {
		//RestTemplate restTemplate=restTemplateBuilder.build();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PriceService",false);
		String baseUrl=instanceInfo.getHomePageUrl(); 
		baseUrl=baseUrl+"/price/update";
		//System.out.println(baseUrl);
		return this.restTemplate.postForEntity(baseUrl, price, Price.class);
		
	}
	
	//@HystrixCommand(fallbackMethod="defaultMessage")
	@PostMapping("/deleteproductprice")
	public ResponseEntity<?> invokeServiceDeletePrice(@RequestBody Price price) {
		//RestTemplate restTemplate=restTemplateBuilder.build();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PriceService",false);
		String baseUrl=instanceInfo.getHomePageUrl(); 
		baseUrl=baseUrl+"/price/delete";
		//System.out.println(baseUrl);
		return this.restTemplate.postForEntity(baseUrl, price, ResponseEntity.class);
		
	}
	
	/*
	 * public String defaultMessage() { return
	 * "Service is currently unavailable. Sorry for the inconvenience caused!!!"; }
	 */
}
