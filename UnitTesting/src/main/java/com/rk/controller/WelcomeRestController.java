package com.rk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMethod()
	{
		String msg="WELCOME TO MY PAGE this is Rakesh";
	     
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
