package com.rk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishController {

	@GetMapping("/welcome")
	public String methodController() {
		return "<h1>WELCOME Message user !!!!!</h1>";
	}//method
}
