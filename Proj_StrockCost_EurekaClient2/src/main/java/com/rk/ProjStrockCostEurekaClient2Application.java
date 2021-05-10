package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import jdk.jfr.Enabled;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProjStrockCostEurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjStrockCostEurekaClient2Application.class, args);
	}

}
