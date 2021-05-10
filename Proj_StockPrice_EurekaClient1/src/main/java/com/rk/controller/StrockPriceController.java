package com.rk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rk.entity.StockPrice;
import com.rk.repository.Repository;

@RestController
public class StrockPriceController {

	@Autowired
	private Repository repo;

  @GetMapping(value = "/getPrice/{companyName}")
  public ResponseEntity<String> getPriceMethod(@PathVariable String companyName)
  {
	  System.out.println("Company name is :: "+companyName);
	  
	  StockPrice CompPrice = repo.findByCompanyName(companyName);
	  
	  Double compPrice = CompPrice.getStockPrice();
	  
	  return new ResponseEntity<String>(String.valueOf(compPrice),HttpStatus.OK);
  }
	
}//class
