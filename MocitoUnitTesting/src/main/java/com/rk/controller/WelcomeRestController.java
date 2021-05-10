package com.rk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.service.MessageService;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private MessageService msgService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMethod()
	{
		String msg=msgService.getMessageMethod();
	     
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
