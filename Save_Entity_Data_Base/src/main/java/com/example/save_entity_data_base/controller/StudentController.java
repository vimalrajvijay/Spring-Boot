package com.example.save_entity_data_base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.save_entity_data_base.entity.Student;
import com.example.save_entity_data_base.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	StudentRepository repository;
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		repository.save(student);
		return "success";
	}
}
