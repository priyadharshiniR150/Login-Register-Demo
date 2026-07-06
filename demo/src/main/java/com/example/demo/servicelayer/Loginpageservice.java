	package com.example.demo.servicelayer;
	
	
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginResponse;
import com.example.demo.entity.LoginpageEntity;
import com.example.demo.jwtsecurity.LoginpageUtil;
import com.example.demo.repository.LoginpageRepository;
	
	
	
	@Service
	public class Loginpageservice	{
	
	    @Autowired  
		private LoginpageRepository repo;
	    
	    @Autowired
	    PasswordEncoder passwordencoder;
	    @Autowired
	    LoginpageUtil loginpageutil;
		
	    public String register(LoginpageEntity user) {
	    	//register
	    	if(repo.existsByEmail(user.getEmail())){
	    		return "email  already exists";
	    	}
	    
			user.setPassword (passwordencoder.encode(user.getPassword()));
	    	repo.save(user);
	    	return "register successfully";
	    }
	    
	    public LoginResponse login(String email, String password) {

	        Optional<LoginpageEntity> dbuser = repo.findByEmail(email);

	        if(dbuser.isPresent()) {

	            if(passwordencoder.matches(password, dbuser.get().getPassword())) {

	                String accessToken = loginpageutil.generateToken(email);

	                String refreshToken = loginpageutil.generateRefreshToken(email);

	                return new LoginResponse(accessToken, refreshToken);
	            }

	            throw new RuntimeException("Invalid Password");
	        }

	        throw new RuntimeException("Email Not Found");
	    }
	    //create 
	    
	    public LoginpageEntity adduser(LoginpageEntity user) {
	    	
	    	user.setPassword(passwordencoder.encode(user.getPassword()));
	    	return repo.save(user);
	    	
	    }
	  
	     
	    //read 
	    
	    public List<LoginpageEntity> getalluser(){
	    	return repo.findAll();
	    	}
	    
	    //update
	    
	    public LoginpageEntity updateuser(Long id, LoginpageEntity user) {
	    	
	    	LoginpageEntity olduser=repo.findById(id).orElse(null);
	    	
	    	if(olduser !=null) {
	    		olduser.setName(user.getName());
	    		olduser.setEmail(user.getEmail());
	    	
	    		olduser.setPassword(passwordencoder.encode(user.getPassword()));
	    		
	    		
	    	}
	    	return repo.save(olduser);
	    	
	    }
	    
	    //delete
	    public String deleteuser( Long id) {
	    	repo.deleteById(id);
	    	
	    	return "deleted";
	    }
	}
	    
	    
	    
	   
	    
	    
	  
		
	
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	
