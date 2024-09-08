package com.example.demo1.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entity.Subject;

public interface SubjectRepositry extends JpaRepository<Subject, Integer> {

	boolean existsByCode(String code);

	Optional<Subject> findByCode(String code);
}
