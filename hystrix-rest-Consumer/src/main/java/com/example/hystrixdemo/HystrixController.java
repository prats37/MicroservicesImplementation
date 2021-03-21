package com.example.hystrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {
	
	@Autowired
	GreetingService greetingService;
	
	@RequestMapping("/get-greeting/{username}")
	public String greetString(@PathVariable("username") String username) {
		return greetingService.getGreeting(username);
	}

}
