package com.example.api_versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class TestControllerV1 {

	@GetMapping("/{id}")
	public StudentV1 getStudent(@PathVariable int id) {
		return new StudentV1(id, "abc");
	}
	
	
	
	
}
