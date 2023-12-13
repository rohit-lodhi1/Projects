package com.security.app.util;

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
public class JWTUtils {
    
	@Value("${app.secret}")
	private  String secretKey;
	
   private String generateToken(Map<String, Object> claims, String subject) {
	   
	  return Jwts.builder()
			  .setClaims(claims)
			  .setSubject(subject)
			  .setIssuer("ROHIT ")
			  .setIssuedAt(new Date(System.currentTimeMillis()))
			  .setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
			  .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
			  .compact();
			  
   }

   
   private Claims getClaims(String token) {
	   return Jwts.parser()
			   .setSigningKey(secretKey.getBytes())
			   .parseClaimsJws(token)
			   .getBody();
   }
   
   public String generateToken(String subject) {
	   Map<String, Object> claims = new HashMap<>();
	   
	   return generateToken(claims, subject);
   }
	
   
   public String getUserName(String token) {
	   return getClaims(token).getSubject();
   }
}
