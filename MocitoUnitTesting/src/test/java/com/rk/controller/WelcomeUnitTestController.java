package com.rk.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rk.service.MessageService;

@WebMvcTest(value = WelcomeRestController.class)
public class WelcomeUnitTestController {

	@Autowired
	private MockMvc mvc; //it is normal inject the client request to RestController request that to inject
	
	@MockBean
	private MessageService service;//inject the service class as a MOCK
	
 @Test
 public void test_getWelcomeMsg() throws Exception{
	
	 when(service.getMessageMethod()).thenReturn("This is message pass as demo");
	 
 MockHttpServletRequestBuilder reqBuiler = MockMvcRequestBuilders.get("/welcome");//its just send the url to RestController
 MvcResult mvcResult = mvc.perform(reqBuiler).andReturn();//execute the url
 MockHttpServletResponse response = mvcResult.getResponse();//store the Response
 
 int status = response.getStatus();//captcher the status code 
 
 //compaire the status code
 assertEquals(200, status);//Compare with result with actual (200) client value send
 }

}
