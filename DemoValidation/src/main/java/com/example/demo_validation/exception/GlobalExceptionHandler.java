package com.example.demo_validation.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex){
		Map<String, String> map = new HashMap<>();
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		for(FieldError error : errors) {
			map.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
}
