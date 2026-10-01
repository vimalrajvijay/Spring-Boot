package com.example.api_versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/students")
public class TestControllerV2 {

	@GetMapping("/{id}")
	public StudentV2 getStudent(@PathVariable int id) {
		return new StudentV2(id, "abc", "abc@gamil.com");
	}
}
