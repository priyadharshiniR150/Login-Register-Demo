//package com.example.demo.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.jwtsecurity.JwtUtil;
//import com.example.demo.modules.AuthRequest;
//
//
//@RestController	
//@RequestMapping("/api")	
//public class AuthController {
//
//private final JwtUtil jwtUtil;
//
//	public AuthController(JwtUtil jwtUtil) {
//		this.jwtUtil=jwtUtil;
//	}
//	@PostMapping("/login")
//		public String login(@RequestBody AuthRequest request) {
//			
//			if(request.getUsername().equals("admin")&&request.getPassword().equals("1234")) {
//				
//				return jwtUtil.generateToken(request.getUsername());
//				
//				
//			}
//			return "Invalid login";
//		}
//		@GetMapping("/hello")
//		public String hello() {
//			return "JWT Protected API";
//		}
//		
//	
//	
//}
//	
//	
//	
//
