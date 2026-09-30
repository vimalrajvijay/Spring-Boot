package com.example.reading_data_from_request;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
}
