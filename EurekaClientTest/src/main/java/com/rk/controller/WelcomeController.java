package com.rk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcomeMethod()
	{
		return "GoodMorning !!!!"+" 1st Rest client ";
	}
}
