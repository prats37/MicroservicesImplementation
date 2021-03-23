package com.wipro.eurekaserver;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsiEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsiEurekaServerApplication.class, args);
		System.out.println("### Eureka Server is up and running at port number 6500 ###");
	}

}
