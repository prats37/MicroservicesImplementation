package com.example.hystrixdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	
	@GetMapping("/")
	public String greetString() {
		return "Hello use/greet/{username} to see response !!!";
	}
	
	@GetMapping("/greet/{username}")
	public String greetString(@PathVariable("username")String username) {
		return String.format("Hello %s!",username);
	}

}
