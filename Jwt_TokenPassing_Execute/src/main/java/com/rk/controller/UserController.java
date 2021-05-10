package com.rk.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.model.JWTUserResp;
import com.rk.model.JwtUserRequest;
import com.rk.model.User;
import com.rk.service.IUserService;
import com.rk.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	//create UserName and Password store to DataBase
	@PostMapping("/save") //generate user id or password or roles
	public ResponseEntity<String> userGenerate(@RequestBody User user)
	{
		
		System.out.println("User table :: "+user);
		
		Integer id= userService.saveUser(user);
		
		String body= "User id : "+id+" Saved successfully ... !!";
		
		return ResponseEntity.ok(body);
	}//method
	
	//login the user and validate them   or   all are perfectly go then craete Token
	@PostMapping("/login")
	public ResponseEntity<JWTUserResp> loginUser(@RequestBody JwtUserRequest userRequest)
	{
		//TODO: validate the username or password
		authManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(),
																						userRequest.getPassword()));
		
		//create Token 
		String token=jwtUtil.generateToken(userRequest.getUsername());
	
		return ResponseEntity.ok(new JWTUserResp(token,"Successfully Generate Token ...!!!"));
	}//method
	
	
	
//---------------------------after all are end then token fliter then use this url----------------
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMethod()
	{
		String body="THIS IS TEST BCZ THIS IS PRIVATE FILE";
		
		return ResponseEntity.ok(body);
	}
	
	@PostMapping("/access")
	public ResponseEntity<String> accessMethod(Principal p)   //this Principal is security pass that take
	{
		String body="THIS IS TEST BCZ THIS IS PRIVATE FILE :: "+p;
		
		return ResponseEntity.ok(body);
	}
}//class
