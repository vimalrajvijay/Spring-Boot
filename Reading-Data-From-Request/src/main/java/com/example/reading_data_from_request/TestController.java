package com.example.reading_data_from_request;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@PostMapping("/path/{id}/{name}")
	public String pathVariable(
			@PathVariable(value = "id") int stuId,
			@PathVariable String name) {
		return "Id : "+stuId+" Name : "+name;
	}
	
	@PostMapping("/sample")
	public String queryString(
			@RequestParam(value = "id") int stuId,
			@RequestParam String name) {
		return "Id : "+stuId+" Name : "+name;
	}
	
	@PostMapping("/test")
	public String requestHeader(
			@RequestHeader("Authorization") String token) {
		return token;// Ex : Bearer abc123 
	}
	
	@PostMapping("/test1")
	public Student requestBody(@RequestBody Student student) {
		return student;
	}
	
	@PostMapping("/test2")
	public String cookieValue(@CookieValue(value = "username") String username) {
		return username;
	}
	
	@PostMapping("/test3")
	public String readRequest(RequestEntity<Student> req) {
		System.out.println(req.getUrl());
		System.out.println(req.getMethod());
		System.out.println(req.getHeaders().getFirst("Authorization"));
		System.out.println(req.getHeaders().getFirst("Content-Type"));
		System.out.println(req.getHeaders().getFirst("Cookie"));
		System.out.println(req.getBody());
		return "Success";
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<String> findStudent(@PathVariable int id) {
		List<Integer> ids = List.of(101, 102, 103);
		if(ids.contains(id))
			return new ResponseEntity<>("Found", HttpStatus.OK);
		else
			return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String test() {
		return "success";
	}
}
