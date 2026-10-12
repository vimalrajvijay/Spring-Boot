package com.example.demo_validation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_validation.entity.Student;
import com.example.demo_validation.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(
			@Valid @RequestBody Student student){
		Student stu = studentService.saveStudent(student);
		return new ResponseEntity<>(stu, HttpStatus.CREATED);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Student>> getAllStudentsBasedOnName(
			@PathVariable String name){
		List<Student> students= 
				studentService.findAllStudentBasedOnName(name);
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
}
