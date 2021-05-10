package com.rk.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secretKey}")
	private String secreatKey;
	
	@Value("${app.companyName}")
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
				     .setSigningKey(secreatKey)
				     .parseClaimsJws(token)
				     .getBody();
			
		return c;
			
		}//method
	
	//3.Read ExpireDate
	public Date getExpDate(String token)
	{
		Date expDate=getClaims(token).getExpiration();
		
		return expDate;
	}//method
	
	//4.Read username
	public String getUsername(String token) {
	
		String subject=getClaims(token).getSubject();
		return subject;
	}
	
	//5. Generate Token with Empty Claims
	public String generateTokens(String username) {

		Map<String, Object> claims = new HashMap<>();
		return generateToken(username);
	}
	
	//6. Check Current and Exp Date
	public boolean isTokenExpired(String token) {
		final Date expiration = getExpDate(token);
		return expiration.before(new Date());
	}
	
	//7. validate token user name and request user also expDate
	public boolean validateToken(String token, String username) {
		String usernameInToken = getUsername(token);
		return (usernameInToken.equals(username) && !isTokenExpired(token));
	}
}//class
