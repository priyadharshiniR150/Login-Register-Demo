package com.example.demo.controller;






import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoginpageEntity;
import com.example.demo.jwtsecurity.LoginpageUtil;
import com.example.demo.servicelayer.Loginpageservice;


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
	public String login(@RequestBody LoginpageEntity user) {
		
		
		return  service.login(user.getEmail(), user.getPassword());
	
			
	}
	
}
	
	
