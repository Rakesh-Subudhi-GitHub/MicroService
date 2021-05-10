package com.rk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.helperInterface.ClientTest1;

@RestController
public class ResponseTest {

	@Autowired
	private ClientTest1 client1;
	
	@GetMapping("/finalResp")
	public String FinalRespTest()
	{
		String client2msg="WELCOME RAKESH ITS YOUR PAGE this is calling (2nd Rest)";
		
		//1st Rest output is
		String client1Msg=client1.invokeClientTest_1_Method();
		
		
		//final msg
		String finalMsg=client1Msg+"  --  "+client2msg;
		
		return finalMsg;
	}//method
}
