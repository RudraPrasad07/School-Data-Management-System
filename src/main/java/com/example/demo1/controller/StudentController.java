package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.StudentService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/student")
@Tag(name = "Student")

public class StudentController {
	@Autowired
	public StudentService service;

	@Operation(

			description = "Creates and saves a new student record. Returns the details of the created student", responses = {
					@ApiResponse(description = "Sucess", responseCode = "201"),
					@ApiResponse(description = "Email And PhoneNumber all ready Present ", responseCode = "409") }

	)
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student s) {
		ResponseStructure<Student> student = service.saveStudent(s);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@Operation(

			description = "Updates the details of an existing student record based on its ID. Returns the updated student details", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = "Email And PhoneNumber all ready Present and Id Id Not Present ", responseCode = "404") }

	)
	@PutMapping("Update/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@PathVariable("id") int id,
			@RequestBody Student s) {
		ResponseStructure<Student> student = service.updateStudent(s, id);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves a student record based on its ID. Returns the student details if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " ID Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<ResponseStructure<Student>> fetchStudentById(@PathVariable("id") int id) {
		ResponseStructure<Student> student = service.fetchstudentById(id);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves a student record based on its number. Returns the student details if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " Number Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchByNumber/{number}")
	public ResponseEntity<ResponseStructure<Student>> fetchByNumber(@PathVariable("number") String number) {
		ResponseStructure<Student> student = service.fetchByNumber(number);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves a student record based on its ClassName. Returns the student details if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " ClassName Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchstudentByclassName/{classname}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchstudentByclassName(
			@PathVariable("classname") String classname) {
		ResponseStructure<List<Student>> student = service.fetchstudentByclassName(classname);
		return new ResponseEntity<ResponseStructure<List<Student>>>(student, HttpStatus.OK);
	}

	@Operation(

			description = "Deletes a student record based on its ID. Returns a 200 status code if the deletion is successful", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = " Id Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/deleteStudentByID/{id}")
	public ResponseEntity<ResponseStructure<Student>> deletestudentById(@PathVariable("id") int id) {
		ResponseStructure<Student> student = service.deletestudentById(id);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

	@Operation(

			description = "Deletes a student record based on its number. Returns a 200 status code if the deletion is successful", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = "Number Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/deleteStudentByNumber/{number}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudentByNumber(@PathVariable("number") String number) {
		ResponseStructure<Student> student = service.deleteStudentByNumber(number);
		return new ResponseEntity<ResponseStructure<Student>>(student, HttpStatus.OK);
	}

}
