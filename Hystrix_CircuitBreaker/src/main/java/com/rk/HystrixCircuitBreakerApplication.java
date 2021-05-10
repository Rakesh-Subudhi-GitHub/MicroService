package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class HystrixCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixCircuitBreakerApplication.class, args);
	}

}
