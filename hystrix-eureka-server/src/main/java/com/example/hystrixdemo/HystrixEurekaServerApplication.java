package com.example.hystrixdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HystrixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixEurekaServerApplication.class, args);
		System.out.println("--- Eureka server is up and running and port number 6502 ---");
	}

}
