package com.rk.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.util.JwtUtil;

import io.jsonwebtoken.Claims;

@RestController
public class JwtTokenController {

	@Autowired
	private JwtUtil jwtUtil;
	
	String token;
	
	@PostMapping("/generateToken")
    public ResponseEntity<String> generateToken()
    {
    	String token= jwtUtil.generateToken("Text123");
    	
    	return ResponseEntity.ok(token);
    }//method
    
	@PostMapping("/read")
	public LinkedList<String> getClaims() {
	
		String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZXh0MTIzIiwiaXNzIjoiUmFrZXNoQ29tcGFueSIsImlhdCI6MTYyMDE4MTEwNiwiZXhwIjoxNjIwMTgxNzA2fQ.yKk8D00tzRNj40qga2lzPRn2D-N35As_x8VI0DNkyCFmypJBqTY30XmKtV5vHc_hW7MqU7n7i9L7hxSUk7N2RA";
		Claims c=jwtUtil.getClaims(token);
		System.out.println(c.getSubject());
		System.out.println(c.getId());
		System.out.println(c.getIssuer());
		System.out.println(c.getExpiration());
		System.out.println(c.getIssuedAt());
		
		LinkedList<String> list=new LinkedList<String>();
		list.add(c.getSubject());
		list.add(c.getId());
		list.add(c.getIssuer());
		list.addAll((Collection<? extends String>) c.getExpiration());
		list.addAll((Collection<? extends String>) c.getIssuedAt());
		
		return list;
	}//method
}//class

