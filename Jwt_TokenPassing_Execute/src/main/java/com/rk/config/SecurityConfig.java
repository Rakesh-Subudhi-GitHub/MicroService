package com.rk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rk.filter.JWTSecurityFilter;
import com.rk.service.IUserService;
import com.rk.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserServiceImpl userService;  //this class under one method is there 
												 //public UserDetails loadUserByUsername(String username)
													 //so that need this only
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private InvalidUserAuthEntryPoint authEndPoint;
	
	@Autowired
	private JWTSecurityFilter jwtFilter;
	
//-------------------- config authentication manager ------------------------------------	
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
	
//-------------------------- config with AuthenticationManager--------------------------------------	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		//verify the username or password 
		auth.userDetailsService(userService)
			.passwordEncoder(passwordEncoder); 
		
	}//auth method
	
//------------------------------------------ config with http urls----------------------------------------------------	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/user/save","/user/login").permitAll() //in this url is permit all bcz this Two are 1st is save username password 
																											// 2nd is generate Token
			.anyRequest().authenticated() //any request come then login requried or JWT token
			
			.and()   //Error page 
			.exceptionHandling()
			.authenticationEntryPoint(authEndPoint)
			
			.and()	//session 
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			
			//TODO verify user for 2nd Request on words..
			.and()
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			
			;//end
	}//http method
	
}//class
