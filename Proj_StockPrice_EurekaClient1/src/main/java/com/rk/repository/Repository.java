package com.rk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.StockPrice;

public interface Repository extends JpaRepository<StockPrice,Serializable>{

	public StockPrice findByCompanyName(String companyName);
}
