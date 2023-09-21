package com.example.lottomgmt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottomgmt.entity.User;
import com.example.lottomgmt.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PutMapping("/register")
	public ResponseEntity<Map<String,Object>> registerUser (@RequestBody User user) {
		Map<String,Object> response = new HashMap<>();
		try {
			Long id = userService.registerUser(user);
			response.put("id",id);
			response.put("message", "Registered Successfully!");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			System.err.println(e.toString());
			response.put("error",e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> loginUser(@RequestBody Map<String,String> credentials){
		Map<String,Object> response = new HashMap<>();
		try {
			User user = userService.loginUser(credentials);
			Map<String,Object> userdata = new HashMap<>();
			userdata.put("id", user.getId());
			userdata.put("name", user.getUsername());
			userdata.put("email", user.getEmail());
			userdata.put("shopType", user.getShop_type());
			userdata.put("lastLogin", user.getLast_login());
			userdata.put("memberSince", user.getCreated_on());
			response.put("user",userdata);
			response.put("message", "Logged in Successfully!");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			System.err.println(e.toString());
			response.put("error",e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	
	@GetMapping("/hello")
	public ResponseEntity<Map<String,Object>> hello () {
		Map<String,Object> response = new HashMap<>();
		response.put("data", "Hello world! This is test");
		return ResponseEntity.ok(response);
	}
}
