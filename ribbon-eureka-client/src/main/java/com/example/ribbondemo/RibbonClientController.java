package com.example.ribbondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@RestController
public class RibbonClientController {
	
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
	
	@GetMapping("/whereareyou")
	public String demoRibbon(@RequestParam(value="activity",defaultValue="I am in ")String activity) throws InterruptedException{
		String subject=this.restTemplate.getForObject("http://ribbon-service1-app/city", String.class);
		return String.format("%s %s", activity,subject);
	}
	
	@GetMapping("/")
	public String getWelcome() {
		RestTemplate restTemplate=restTemplateBuilder.build();
		return "Use /whereareyou to see load balance with round robin alogorithm";
	}

}
