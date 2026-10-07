package com.example.user_management_system.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_management_system.dto.ResponseUser;
import com.example.user_management_system.dto.UserUpdate;
import com.example.user_management_system.entity.User;
import com.example.user_management_system.exception.InvalidAgeException;
import com.example.user_management_system.exception.UserNotFoundException;
import com.example.user_management_system.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public User saveUser(User user) {
		if(user.getAge()<18)
			throw new InvalidAgeException("age is less than 18");
		return userRepository.save(user);
	}
	
	public ResponseUser findUser(long id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			ResponseUser responseUser = mapper.map(user, ResponseUser.class);
			return responseUser;
		}
		throw new UserNotFoundException("User with id "+id+" is Not Found");
	}
	
	public List<User> findAllUsers(){
		return  userRepository.findAll();
	}
	
	public User updateUser(long id, UserUpdate userUpdate) {
		User user = findUser(id);
		user.setName(userUpdate.getName());
		user.setAge(userUpdate.getAge());
		user.setEmail(userUpdate.getEmail());
		user.setPassword(userUpdate.getPassword());
		
		return userRepository.save(user);
	}
	
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
}
