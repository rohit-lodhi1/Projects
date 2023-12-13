package com.portal.app.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portal.app.services.Implementation.UserDetaileServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetaileServiceImpl userDetaileServiceImpl;
	@Autowired
	private JwtUtils  jwtUtil;
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
	final	String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			//yes
			jwtToken = requestTokenHeader.substring(7);
			try {
				
			
			username=this.jwtUtil.extractUsername(jwtToken);
			
			}catch(ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("TOken has expired");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Invalid Token not starts with Bearer");
		}
		
	
		// validate
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userDetails = this.userDetaileServiceImpl.loadUserByUsername(username);
			if(this.jwtUtil.validateToken(jwtToken, userDetails)) {
				// token is valid
				UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}else {
			System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);
	   	
	}
	
	
      
	
}
