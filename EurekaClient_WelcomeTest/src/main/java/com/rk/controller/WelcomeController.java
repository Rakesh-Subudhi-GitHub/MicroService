package com.rk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.helperInterface.GreetInterfaceHelper;

@RestController
public class WelcomeController {
	
	@Autowired
	private GreetInterfaceHelper greetclient;

	@GetMapping("/welcome")
	public String welcomeMethod()
	{
		String msg="<h3>Rakesh its your page <h3>"+"client2 running";
		
		String client1Msg=greetclient.invokeGreetInterface();
		
		String finalResp=client1Msg+" , "+msg;
		
		return finalResp;
	}
}
