package com.rk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class WelcomeController {

	@GetMapping(value = "/welcome")
	@HystrixCommand(fallbackMethod = "methodName",
	                            commandProperties = {
	                            		@HystrixProperty(name = "exception.Isolation.thread.timeOutMillSecands",value = "5000")
			               
	               })
	public String welcomeMethod()
	{
		String msg="<h1>WELCOME METHOD CALLING </h1>";
		
		int i=10/0;//exception create here
		
		return msg;
	}//method
	
	public String methodName()
	{
		String msg="GOOD MORNING ITS FALLBACK METHOD CALLING";
		
		return msg;	
	}
}
