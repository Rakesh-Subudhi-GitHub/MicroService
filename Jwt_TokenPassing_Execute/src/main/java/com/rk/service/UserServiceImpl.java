package com.rk.service;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rk.model.User;
import com.rk.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	private UserRepository userRepo; //HAS-A
	
	@Autowired
	private BCryptPasswordEncoder passowrdEncoder;
	
	//save the method
	@Override
	public Integer saveUser(User user) {
		
		int id=0;
		
		if(user!=null)
		{
			//TODO : Encode the password
			user.setPassword(passowrdEncoder.encode(user.getPassword()));
			
			//TODO: save the user
		   id=userRepo.save(user).getId();
		   
		}
		
		return id;
		
	}//method

	//get user by userName
	@Override
	public Optional<User> findByUserName(String userName)
	{
		return userRepo.findByUserName(userName);
	}

//---------------------------------------that is new user details checker class -------------------------------	
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException
	{
	
		Optional<User> opt= findByUserName(username);
		
		if(opt.isEmpty())
			throw new UsernameNotFoundException("User not Exist ... please try again...!!");
		
		//read user from DataBase
		User user=opt.get();
		
		return new org.springframework.security.core.userdetails.User(
																	username,
																	user.getPassword(),
																	user.getRoles().stream()
																	  .map(role->new SimpleGrantedAuthority(role))
																	  .collect(Collectors.toList())
																	);
	
	}//method
	
}//class
