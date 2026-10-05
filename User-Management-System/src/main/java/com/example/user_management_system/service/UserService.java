package com.example.user_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_management_system.entity.User;
import com.example.user_management_system.exception.InvalidAgeException;
import com.example.user_management_system.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		if(user.getAge()<18)
			throw new InvalidAgeException("age is less than 18");
		return userRepository.save(user);
	}
}
