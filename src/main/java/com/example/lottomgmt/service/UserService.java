package com.example.lottomgmt.service;

import java.util.Map;

import com.example.lottomgmt.entity.User;

public interface UserService {
	
	Long registerUser(User user) throws Exception;
	
	User loginUser(Map<String, String> credentials) throws Exception;
}
