package com.rk.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = WelcomeRestController.class)
public class WelcomeUnitTestController {

	@Autowired
	private MockMvc mvc; //it is normal inject the client request to RestController request that to inject
	
 @Test
 public void test_getWelcomeMsg() throws Exception{
	
 MockHttpServletRequestBuilder reqBuiler = MockMvcRequestBuilders.get("/welcome");//its just send the url to RestController
 MvcResult mvcResult = mvc.perform(reqBuiler).andReturn();//execute the url
 MockHttpServletResponse response = mvcResult.getResponse();//store the Response
 
 int status = response.getStatus();//captcher the status code 
 
 //compaire the status code
 assertEquals(200, status);//Compare with result with actual (200) client value send
 }

}
