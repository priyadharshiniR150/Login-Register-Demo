//package com.example.demo.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.UserEntity;
////import com.example.demo.modules.User;
//import com.example.demo.repository.UserRepository;
//
//@RestController
//@RequestMapping("/api/users")
//
//public class Controller {
//	@Autowired
//	private UserRepository userRepository;
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//
//	
////@GetMapping
////	public String getUsers() {
////		return "Hellow API";
////	}}
//	
//	@GetMapping
//	public List<UserEntity> getUsers() {
//
//		return userRepository.findAll();
//		
//	}		
//@PostMapping
//	public UserEntity createUser(@RequestBody UserEntity user) {
//	
//		 return userRepository.save(user);
//
//		
//		
//	}
//@GetMapping("/{id}")
//	public Optional<UserEntity>getUserById(@PathVariable Long id)
//
//{
//		return userRepository.findById(id);
//		
//		
//	}
//@PutMapping("/{id}")
//public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
//	UserEntity userData= userRepository.findById(id).orElse(user);
//	userData.setEmail(user.getEmail());
//	userData.setName(user.getName());
//	return userRepository.save(userData);
//}
//
//@DeleteMapping("/{id}")
//public ResponseEntity<?> deleteUser(@PathVariable Long id) {
//	UserEntity userData= userRepository.findById(id).orElse(null);
//
//	if (userData==null) {
//		return ResponseEntity.notFound().build();	
//	}
//	
//	userRepository.delete(userData);
//	return ResponseEntity.ok("User deleted Successfully ");
//	
//}
//
//
//
//
//
////		return Arrays.asList(new User(1L, "priya", "priyaceo@gmail.com"), 
////				new User(2L, "Dhanush", "Dhanushceo@gmail.com")
////				);
//		
//	
//}
//
//	
//	