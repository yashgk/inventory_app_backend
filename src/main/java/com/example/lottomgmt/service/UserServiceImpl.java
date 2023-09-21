package com.example.lottomgmt.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lottomgmt.entity.User;
import com.example.lottomgmt.exception.ResourceNotFoundException;
import com.example.lottomgmt.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Long registerUser(User user) throws Exception {
		Optional<User> localUser = userRepository.findByEmail(user.getEmail());

		if (localUser.isPresent()) {
			throw new Exception("User Already Exist!");
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			user.setCreated_on(formatter.format(date));
			user.setPasskey(passwordEncoder.encode(user.getPasskey()));
			return userRepository.save(user).getId();
		}
	}

	@Override
	public User loginUser(Map<String, String> credentials) throws Exception {
		if(credentials.isEmpty()) {
			throw new Exception("Bad Request!");
		}
		Optional<User> localUser = userRepository.findByEmail(credentials.get("email"));
		if (localUser.isPresent()) {
			if(passwordEncoder.matches(credentials.get("password"), localUser.get().getPasskey())) {
				User user = localUser.get();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				user.setLast_login(formatter.format(date));
				userRepository.save(user);
				return localUser.get();
			}else {
				throw new Exception("Invalid Password!");
			}
		}else {
			throw new ResourceNotFoundException("User not Found!");
		}
	}
}
