package com.example.reading_data_from_request;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String requestHeader(@RequestHeader("Authorization") String token) {
		return token;
	}
}
