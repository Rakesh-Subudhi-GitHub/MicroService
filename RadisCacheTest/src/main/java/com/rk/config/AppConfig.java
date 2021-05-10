package com.rk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import com.rk.model.Student;

@Configuration
public class AppConfig {

	//1.Redis Connection
	@Bean
	public RedisConnectionFactory cf()
	{
		return new LettuceConnectionFactory();
	}
	
	//2.Redis RestTemplate
	@Bean
	public RedisTemplate<String,Student> rt(){
		
		RedisTemplate<String,Student> template=new RedisTemplate<String, Student>();
		template.setConnectionFactory(cf());
		
		return template;
	}
	
	
}//class
