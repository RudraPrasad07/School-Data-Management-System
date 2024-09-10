package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.TeacherService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Teacher;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/teacher")
@Tag(name = "Teacher")
public class TeacherController {

	@Autowired
	private TeacherService service;
	@Operation(

			description = "Creates and saves a new Teacher record. Returns the details of the created Teacher", responses = {
					@ApiResponse(description = "Sucess", responseCode = "201"),
					@ApiResponse(description = "Email And PhoneNumber all ready Present ", responseCode = "409") }

	)
	@PostMapping("/saveteacher")
	public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(@RequestBody Teacher t) {
		ResponseStructure<Teacher> teacher = service.saveTeacher(t);
		return new ResponseEntity<ResponseStructure<Teacher>>(teacher, HttpStatus.OK);
	}
	@Operation(

			description = "Updates the details of an existing Teacher record based on its ID. Returns the updated Teacher details", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = "Email And PhoneNumber all ready Present and Id Id Not Present ", responseCode = "404") }

	)
	@PutMapping("UpdateTeacher/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> UpdateTeacher(@PathVariable("id") int id,
			@RequestBody Teacher t) {
		ResponseStructure<Teacher> teacher = service.UpdateTeacher(t, id);
		return new ResponseEntity<ResponseStructure<Teacher>>(teacher, HttpStatus.OK);
	}
	@Operation(

			description = "Retrieves a Teacher record based on its ID. Returns the Teacher details if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " ID Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> fetchTeacherById(@PathVariable("id") int id) {
		ResponseStructure<Teacher> structure = service.fetchTeacherById(id);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}
	@Operation(

			description = "Retrieves a Teacher record based on its Number. Returns the Teacher details if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " Number Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchByNumber/{number}")
	public ResponseEntity<ResponseStructure<Teacher>> fetchByNumber(@PathVariable("number") String number) {
		ResponseStructure<Teacher> structure = service.fetchByNumber(number);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}
	@Operation(

			description = "Retrieves a Teacher record based on its ClassName. Returns the Teacher details if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " ClassName Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchByName/{Classname}")
	public ResponseEntity<ResponseStructure<List<Teacher>>> fetchTeacherByclassName(
			@PathVariable("Classname") String Classname) {
		ResponseStructure<List<Teacher>> structure = service.fetchTeacherByclassName(Classname);
		return new ResponseEntity<ResponseStructure<List<Teacher>>>(structure, HttpStatus.OK);
	}
	@Operation(

			description = "Deletes a Teacher record based on its Id. Returns a 200 status code if the deletion is successful", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = "Id Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> deleteByID(@PathVariable("id") int id) {
		ResponseStructure<Teacher> structure = service.deleteByID(id);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}
	@Operation(

			description = "Deletes a Teacher record based on its Number. Returns a 200 status code if the deletion is successful", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = "Number Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/DeleteByNumber/{Number}")
	public ResponseEntity<ResponseStructure<Teacher>> deleteByNumber(@PathVariable("Number") String Number) {
		ResponseStructure<Teacher> structure = service.deleteByNumber(Number);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}
}
