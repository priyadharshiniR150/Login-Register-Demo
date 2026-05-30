//package com.example.demo.jwtsecurity;
//
//
//
//import java.security.Key;
//import java.util.Date;
//
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//@Component
//public class JwtUtil {
//	private final String SECRET="mysecretkeywaspersonalinfo12345678";
//
//	private Key getSignKey() {
//		return Keys.hmacShaKeyFor(SECRET.getBytes());	
//		
//	}
//	//Generate token
//	public String generateToken(String username) {
//		return Jwts.builder()
//				.setSubject(username)
//				.setIssuedAt(new Date())
//				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
//				.signWith(getSignKey(), SignatureAlgorithm.HS256)
//				.compact();				
//	}
//	//extract Username
//	public String extractUsername(String token) {
//		
//		return Jwts.parserBuilder()
//				.setSigningKey(getSignKey())
//				.build()
//				.parseClaimsJws(token)
//				.getBody()
//				.getSubject();			
//		
//	}
//	
//	//validate token
//	public boolean validateToken(String token, String username) {
//		String extractedUsername=extractUsername(token);
//		
//		return extractedUsername.equals(username);		
//		
//	}
//	
//	
//}
