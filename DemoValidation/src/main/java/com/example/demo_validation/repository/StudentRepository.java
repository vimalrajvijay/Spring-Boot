package com.example.demo_validation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo_validation.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value = "select * from student where name = :stu_name", nativeQuery = true)
	List<Student> findStudents(@Param("stu_name") String name);
}
