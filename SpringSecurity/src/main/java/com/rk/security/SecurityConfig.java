package com.rk.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.inMemoryAuthentication().withUser("SAM").password("{noop}sam").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("RAM").password("{noop}ram").authorities("EMPLOYE");
		auth.inMemoryAuthentication().withUser("YAM").password("{noop}yam").authorities("STUDENT");
	}

	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//url access
		http.authorizeRequests()
		
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/stud").hasAuthority("STUDENT")
		.antMatchers("/emp").hasAuthority("EMPLOYE")
		.antMatchers("/common").hasAnyAuthority("STUDENT","EMPLOYE")
		
		;
	}
}//class
