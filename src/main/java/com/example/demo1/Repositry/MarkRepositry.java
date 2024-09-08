package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entity.Mark;

public interface MarkRepositry extends JpaRepository<Mark, Integer> {

}
