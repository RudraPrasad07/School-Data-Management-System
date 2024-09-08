package com.example.demo1.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entity.Student;

public interface StudentRepositry extends JpaRepository<Student, Integer> {
	public boolean existsByEmail(String email);

	public boolean existsByPhoneno(String phoneno);

	public Optional<Student> findByEmail(String email);

	public Optional<Student> findByPhoneno(String phoneno);

	public void deleteByPhoneno(String phoneno);
}
