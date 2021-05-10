package com.rk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetTestController {

	@GetMapping("/greet")
	public String greetTestMethod()
	{
		String msg="<h1> GOOD MORNING..!!!! </h1>"+"-"+"(client1 run it) ## ";
		
		return msg;
	}//method
}//class
