package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProjEurekaServiceRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjEurekaServiceRegisterApplication.class, args);
	}

}
