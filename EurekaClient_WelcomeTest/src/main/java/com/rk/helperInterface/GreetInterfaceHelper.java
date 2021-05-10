package com.rk.helperInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface GreetInterfaceHelper {

	@GetMapping("/greet")
	public String invokeGreetInterface();

}
