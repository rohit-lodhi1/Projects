package com.commerce.app.utils;

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

//	@Value("${app.secret}")
	private String secret_Key="rohit";
	
	public String generateToken(Map<String, Object> claims , String subject) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuer("ROhit Lodhi")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(20)))
				.signWith(SignatureAlgorithm.HS256, secret_Key.getBytes())
				.compact();
	}
	
	
	public String generateToken(String subject) {
		Map<String, Object> claims = new HashMap<>();
		return generateToken(claims,subject);
	}
	
	private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secret_Key.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
	
	public String getUserName(String token) {
		return getClaims(token).getSubject();
	}
	
}
