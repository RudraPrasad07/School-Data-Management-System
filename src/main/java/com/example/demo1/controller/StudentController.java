package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.StudentService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	public StudentService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student s) {
		ResponseStructure<Student> student = service.saveStudent(s);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@PutMapping("Update/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@PathVariable("id") int id,
			@RequestBody Student s) {
		ResponseStructure<Student> student = service.updateStudent(s, id);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@GetMapping("/fetchById/{id}")
	public ResponseEntity<ResponseStructure<Student>> fetchStudentById(@PathVariable("id") int id) {
		ResponseStructure<Student> student = service.fetchstudentById(id);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@GetMapping("/fetchByNumber/{number}")
	public ResponseEntity<ResponseStructure<Student>> fetchByNumber(@PathVariable("number") String number) {
		ResponseStructure<Student> student = service.fetchByNumber(number);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@GetMapping("/fetchstudentByclassName/{classname}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchstudentByclassName(
			@PathVariable("classname") String classname) {
		ResponseStructure<List<Student>> student = service.fetchstudentByclassName(classname);
		return new ResponseEntity<ResponseStructure<List<Student>>>(student, HttpStatus.OK);
	}

	@DeleteMapping("/deleteStudentByID/{id}")
	public ResponseEntity<ResponseStructure<Student>> deletestudentById(@PathVariable("id") int id) {
		ResponseStructure<Student> student = service.deletestudentById(id);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@DeleteMapping("/deleteStudentByNumber/{number}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudentByNumber(@PathVariable("number") String number) {
		ResponseStructure<Student> student = service.deleteStudentByNumber(number);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

}
