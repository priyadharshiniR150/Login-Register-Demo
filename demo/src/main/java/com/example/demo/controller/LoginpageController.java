package com.example.demo.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginResponse;
import com.example.demo.entity.LoginpageEntity;
import com.example.demo.jwtsecurity.LoginpageUtil;
import com.example.demo.servicelayer.Loginpageservice;

import jakarta.servlet.http.HttpServletRequest;


@RestController 
@RequestMapping("/api")
public class LoginpageController {
	@Autowired
	Loginpageservice service;
	@Autowired
	LoginpageUtil loginpageutil;
	
	@PostMapping("/register")
	public String register(@RequestBody LoginpageEntity user) {
		
		 return service.register(user);
		
		
		
	}
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginpageEntity user) {
		
		
		return  service.login(user.getEmail(), user.getPassword());
	
			
	}
	@PostMapping("/refresh")
	public LoginResponse refresh(HttpServletRequest request) {

	    String token = request.getHeader("Authorization");

	    if (token == null || !token.startsWith("Bearer ")) {
	        throw new RuntimeException("Refresh Token Missing");
	    }

	    String refreshToken = token.substring(7);

	    if (!loginpageutil.isValidToken(refreshToken)) {
	        throw new RuntimeException("Refresh Token Expired");
	    }

	    String email = loginpageutil.extractEmail(refreshToken);

	    String accessToken = loginpageutil.generateToken(email);
	    String newRefreshToken = loginpageutil.generateRefreshToken(email);

	    return new LoginResponse(accessToken, newRefreshToken);
	}}
	
