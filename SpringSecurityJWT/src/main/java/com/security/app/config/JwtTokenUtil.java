package com.security.app.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtTokenUtil {
	
	 private final long expirationTimeMillis = 86400000; // 24 hours in milliseconds
	
    private final SecretKey secretKey;
    private final SignatureAlgorithm signatureAlgorithm;

    public JwtTokenUtil(SecretKey secretKey, SignatureAlgorithm signatureAlgorithm) {
        this.secretKey = secretKey;
        this.signatureAlgorithm = signatureAlgorithm;
    }

    public String generateToken(String subject, Map<String, Object> claims, long expirationTimeMillis) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
                .signWith(secretKey, signatureAlgorithm)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    
    
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap();
        // Add any additional claims you want to include in the token

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
                .signWith(secretKey, signatureAlgorithm)
                .compact();
    }
}