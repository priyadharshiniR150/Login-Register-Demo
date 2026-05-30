package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoginpageEntity;
import com.example.demo.jwtsecurity.LoginpageUtil;
import com.example.demo.servicelayer.Loginpageservice;
@RestController
@RequestMapping("/api")
public class Loginmanage {
	@Autowired
	Loginpageservice service;
	
	@Autowired
	LoginpageUtil loginpageutil;
	
	@PostMapping("/add")
	public LoginpageEntity adduser(@RequestBody LoginpageEntity user) {
			return service.adduser(user);
	}
	@GetMapping("/get")
	public List<LoginpageEntity> getalluser(){
		
		return service.getalluser();
		
	}
	@PutMapping("/update/{id}")
	public LoginpageEntity updateuser(@PathVariable Long id, @RequestBody LoginpageEntity user) {
		
		return service.updateuser(id, user);
		
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable Long id) {
		
		return service.deleteuser(id);
		
	}
	
	
	
	
}
