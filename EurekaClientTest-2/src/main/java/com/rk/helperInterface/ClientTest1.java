package com.rk.helperInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "WELCOME-API")
public interface ClientTest1 {

	@GetMapping("/welcome")
	public String invokeClientTest_1_Method();
	
	
}
