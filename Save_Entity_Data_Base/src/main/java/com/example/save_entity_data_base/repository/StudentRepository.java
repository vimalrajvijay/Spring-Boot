package com.example.save_entity_data_base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.save_entity_data_base.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}
