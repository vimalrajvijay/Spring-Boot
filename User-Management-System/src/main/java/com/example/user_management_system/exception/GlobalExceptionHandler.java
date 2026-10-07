package com.example.user_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<String> handleInvalidAgeException(InvalidAgeException ex){
		return new ResponseEntity<String>(ex.getMessage(), 
				                HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), 
				                HttpStatus.NOT_FOUND);
	}
}
