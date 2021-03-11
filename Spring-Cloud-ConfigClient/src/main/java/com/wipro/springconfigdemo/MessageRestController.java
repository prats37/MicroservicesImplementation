package com.wipro.springconfigdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageRestController {
	
	@Value("${message: Hello Default}")
	private String message;
	
	@Value("${user.role:Default Role}")
	private String role;
	
	@RequestMapping("/")
	public String getMessageDefault() {
		return "Use /message to check default message...use /myrole/{username} for role based response";
	}
	
	@RequestMapping("/message")
	public String getMessage() {
		return this.message;
	}
	
	@RequestMapping(
			value="myrole/{username}",
			method=RequestMethod.GET
			)
	public String myrole(@PathVariable("username") String userName) {
		return "Hello you are a " +userName+ " your Role is "+role;
	}

}
