package com.rk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String welcomeMethod()
	{
		String msg="WELCOME MESSAGE RUNNING HERE...!!!!";
		
		return msg;
	}//method
}
