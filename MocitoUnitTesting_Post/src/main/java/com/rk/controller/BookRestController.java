package com.rk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rk.helper.Book;
import com.rk.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService bookservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> bookSaveMethod(@RequestBody Book book)
	{
		boolean isSave = bookservice.bookSave(book);
		
		if(isSave)
			return new ResponseEntity<>("SAVED",HttpStatus.CREATED);
		else
			return new ResponseEntity<>("NOTSAVED",HttpStatus.BAD_REQUEST);
	
	}//method
	
}//class
