package com.example.ribbondemo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
	@Value("${server.port}")
	String serverPort;
	
	@GetMapping("/")
	public String home() {
		return "Welocome to LOAD Balance Demo";
	}
	
	@GetMapping("/city")
	public String getLocationName() {
		List<String> names=Arrays.asList("Bengaluru","Delhi","Chennai","Mumbai","Hyderabad","Pune","Kolkata");
		Random random=new Random();
		int randCity=random.nextInt(names.size());
		return names.get(randCity)+" from Port Number "+serverPort;
	}

}
