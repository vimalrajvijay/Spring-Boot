package com.example.user_management_system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_management_system.dto.ResponseUser;
import com.example.user_management_system.dto.UserUpdate;
import com.example.user_management_system.entity.User;
import com.example.user_management_system.service.UserService;




@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		log.info("Request is Received to Create User");
		User savedUser = userService.saveUser(user);
		log.info("We got saved user and will be returned in the Response");
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseUser> readUser(
			@PathVariable long id){
		ResponseUser responseUser = userService.findUser(id);
		return new ResponseEntity<>(
				responseUser, 
				HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> readAllUsers(){
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<User> modifyUser(
//			@PathVariable long id,
//			@RequestBody UserUpdate userUpdate){
//		User user = userService.updateUser(id, userUpdate);
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeUser(@PathVariable long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
