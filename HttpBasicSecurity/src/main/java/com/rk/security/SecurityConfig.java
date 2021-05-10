package com.rk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//http basic security
	@Override
	protected void configure(HttpSecurity httpsecurity) throws Exception {
		
		httpsecurity.csrf()
					.disable()
					.authorizeRequests()
					.anyRequest()
					.authenticated()
					.and()
					.httpBasic();
	}
	
	
	//in memory Credential by user and password check 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
		        
				authentication.inMemoryAuthentication()
							  .withUser("admin")
							  .password(passwordEncoder().encode("admin@123"))
							  .authorities("ROLE_USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() 
	{	
		return new BCryptPasswordEncoder();
	}
	
}
