package com.example.demo.jwtsecurity;



import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

//	import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class LoginpageUtil {

private final String  SECRET="thissecretkeywaspersonal123thissecretkeywaspersonal123thissecretkeywaspersonal123";

private Key getsignKey() {
	
	return Keys.hmacShaKeyFor(SECRET.getBytes());
}
public String generateToken(String email) {
	
	return Jwts.builder()

	.setSubject(email)
	.setIssuedAt(new Date())
	.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60))
	.signWith(getsignKey(), SignatureAlgorithm.HS256)
	.compact();
	
}
public String generateRefreshToken(String email) {

    return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24))
            .signWith(getsignKey(), SignatureAlgorithm.HS256)
            .compact();
}
public boolean isValidToken(String token) {
    try {
        Jwts.parserBuilder().setSigningKey(getsignKey()).build().parseClaimsJws(token);
        return true;
    } catch (Exception e) {
        return false;
    }
}

public String extractEmail(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(getsignKey())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
}

}


	

