package com.wipro.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrixDashboard
//@EnableCircuitBreaker
public class MsiEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsiEurekaClientApplication.class, args);
		System.out.println("### Server is up and ready at port number 6510 ###");
	}

}
