package com.example.demo_validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_validation.entity.Student;
import com.example.demo_validation.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> findAllStudentBasedOnName(String name){
		return studentRepository.findStudents(name);
	}
}
