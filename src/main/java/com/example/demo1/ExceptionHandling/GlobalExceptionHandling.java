package com.example.demo1.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo1.Utility.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(EntityAlreadyExistsException.class)
	public ResponseEntity<ResponseStructure<String>> handleEntityAlreadyExists(EntityAlreadyExistsException e) {
		ResponseStructure<String> Structure = new ResponseStructure<>(HttpStatus.CONFLICT.value(), e.getMessage(), null,
				LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(Structure, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(EntityNotPresentexception.class)
	public ResponseEntity<ResponseStructure<String>> handleEntityNotPresentException(EntityNotPresentexception e) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				null, LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
