package com.rk.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
	
	private static final long serialVersionUID = 8490860682128747910L;
	
	private Integer studId;
	private String studName;
	private Double studeFee;
}
