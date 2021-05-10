package com.rk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StockPrice {

	@Id
	@Column(name = "STOCK_ID")
	private Integer stockId;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@Column(name = "STOCK_PRICE")
	private Double stockPrice; 
}
