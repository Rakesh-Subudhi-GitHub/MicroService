package com.rk.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rk.service.UserServiceImpl;
import com.rk.util.JwtUtil;

@Component
public class JWTSecurityFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
										HttpServletResponse response, 
												FilterChain filterChain)throws ServletException, IOException 
	{
	
		//1.read the token from auth head
		String token=request.getHeader("Authorization");
		
		if(token !=null) {
			
		  //filter the token
		  String username=jwtUtil.getUsername(token);
		  
		  //username should not be empty   or context-auth must be empty
		  if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null)
		  {
			  UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			  
			  //all are perfect then comes to 
			            //validate the token
			 boolean isValid=jwtUtil.validateToken(token, userDetails.getUsername());//collect the username in help of 
				                                                                     //Userdetails bcz that is db value so 
		 if(isValid)
		 {        //then password to check user password or db password  check
			 
		    UsernamePasswordAuthenticationToken authToken= 
		    		                  new UsernamePasswordAuthenticationToken(username, 
		    		                       		                                userDetails.getPassword(),
		    		                       		                                    userDetails.getAuthorities());
		 
		    //web security pass request
		    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		    
		    //final object store the SecurityContext with UserDetails(username, password)
		    SecurityContextHolder.getContext().setAuthentication(authToken);
		    
		 }//if
			 
		  }//if
		}//if
		filterChain.doFilter(request, response);
		
	}//dofilter

}//class
