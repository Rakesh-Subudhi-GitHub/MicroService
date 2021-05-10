package com.rk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rk.com.IstockPriceComm;

@RestController
public class StockCalController {

	@Autowired
	private IstockPriceComm stockPrice;
	
	@GetMapping(value = "/cost/{companyName}/{qty}")
	public ResponseEntity<String> getStockCalMethod(@PathVariable String companyName,@PathVariable Integer qty)
	{
		ResponseEntity<String> price = stockPrice.getStrockPrice(companyName);
		
		Double cost=Double.parseDouble(price.getBody())*qty;
		
		String finalResp="<h1>Totalcost is : "+cost+"</h1>";
		
		return new ResponseEntity<String>(finalResp,HttpStatus.OK);
		
	}//method
}
