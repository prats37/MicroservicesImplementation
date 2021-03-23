package com.wipro.springconfigdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		System.out.println("--- Starting Client application---");
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
		System.out.println("--- SpringCoundConfigClientApplication is running at port 6000 ---");
	}

}
