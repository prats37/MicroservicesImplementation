package com.wipro.eurekaserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerImplementationApplication.class, args);
		System.out.println("---Eureka Server is up and running on port number 6500---");
	}

}
