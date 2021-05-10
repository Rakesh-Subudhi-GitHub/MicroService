package com.rk.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secreatKey;
	
	@Value("${app.company}")
	private String company;
	
	@Value("${app.expTime}")
	private String expTime;
	
	//1.Generate Token
	public String generateToken(String subject) //subject -> username
	{
		String token=Jwts.builder()
			         .setSubject(subject)
			         .setIssuer(company)
			         .setIssuedAt(new Date(System.currentTimeMillis()))
			         .setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(Integer.parseInt(expTime))))
			         
			         //algorithm impl
			         .signWith(SignatureAlgorithm.HS512, secreatKey)
			         
			         //all are convert to String
			         .compact();
		
		return token;
		
	}//method
	
	//2.Read Token
	public Claims getClaims(String token)
	{
		Claims c=Jwts.parser()
					 .setSigningKey(secreatKey.getBytes())
					 .parseClaimsJws(token)
					 .getBody();
		
		return c;
		
	}//method
	
}//class
