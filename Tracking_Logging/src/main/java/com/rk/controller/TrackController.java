package com.rk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

@RestController
public class TrackController {

	private static final Logger logger= LoggerFactory.getLogger(TrackController.class);
	
	@GetMapping("/wish")
	public String trackMethod()
	{
	   logger.info("**********Start the logging **********");	
	   
	   String msg="<h1>WELCOME MESSAGE RAKESH ITS MEEE....!!!!!!</h1>";
	   
	   logger.info("*******End of the logger*****************");
	   
	   return msg;
	   
	}//method
	
}//class
