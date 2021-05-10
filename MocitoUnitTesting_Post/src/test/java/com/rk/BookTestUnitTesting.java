package com.rk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rk.controller.BookRestController;
import com.rk.helper.Book;
import com.rk.service.BookService;

@WebMvcTest(value = BookRestController.class)
public class BookTestUnitTesting {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private BookService service;
	
	public void getMethodTest1()throws Exception {
		
		//saved the book in unit test class
		Book book=new Book();
		book.setBookId(100);
		book.setBookName("Spring");
		book.setBookAuth("abc");
		book.setBookPrice(5897.54);
	
		//convert java to json format      bcz client send data in json format na so check it as json only
		ObjectMapper mapper=new ObjectMapper();
		String bookJson=mapper.writeValueAsString(book);//all are saved to json convert
	
	   when(service.bookSave(book)).thenReturn(true);//bcz this method() return type is set boolean value so
	
	   MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/save") //call method url
	   						                             .content(bookJson) //converting format of saved value
	   						                             .contentType("application/json");//type is json that way
	  
	   //calling method url
	   MvcResult mvcResult = mvc.perform(reqBuilder).andReturn();
	   
	   //collect the status code
	   int status = mvcResult.getResponse().getStatus();
	   
	   //compare the status code
	   assertEquals(201,status);
	        //fast test in take (ture)  
	
	}//method
	
	
public void getMethodTest2()throws Exception {
		
		//saved the book in unit test class
		Book book=new Book();
		book.setBookId(100);
		book.setBookName("Spring");
		book.setBookAuth("abc");
		book.setBookPrice(5897.54);
	
		//convert java to json format      bcz client send data in json format na so check it as json only
		ObjectMapper mapper=new ObjectMapper();
		String bookJson=mapper.writeValueAsString(book);//all are saved to json convert
	
	   when(service.bookSave(book)).thenReturn(false);//bcz this method() return type is set boolean value so
	
	   MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/save") //call method url
	   						                             .content(bookJson) //converting format of saved value
	   						                             .contentType("application/json");//type is json that way
	  
	   //calling method url
	   MvcResult mvcResult = mvc.perform(reqBuilder).andReturn();
	   
	   //collect the status code
	   int status = mvcResult.getResponse().getStatus();
	   
	   //compare the status code
	   assertEquals(400,status);
	        //fast test in take (false)  
	   
	}//method

}//class
