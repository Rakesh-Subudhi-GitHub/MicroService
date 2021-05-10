package com.rk.com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCKPRICE-API")
public interface IstockPriceComm {

	@GetMapping(value = "getPrice/{companyName}")
	public ResponseEntity<String> getStrockPrice(@PathVariable String companyName);
}
