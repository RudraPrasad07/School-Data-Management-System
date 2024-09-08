package com.example.demo1.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entity.Teacher;

public interface TecherRepositry extends JpaRepository<Teacher, Integer> {

	boolean existsByEmail(String email);

	boolean existsByPhoneNo(String phoneNo);

	Optional<Teacher> findByEmail(String email);

	Optional<Teacher> findByPhoneNo(String phoneNo);
}
