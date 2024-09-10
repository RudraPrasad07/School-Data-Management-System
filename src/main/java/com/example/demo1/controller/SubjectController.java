package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.SubjectService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Subject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/subject")
@Tag(name = "Subject")
public class SubjectController {
	@Autowired
	public SubjectService service;

	@Operation(

			description = "This endpoint retrieves the details of a subject based on its unique identifier (ID). If the subject with the given ID is not found, it returns a 404 status code", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " ID Not Prsent", responseCode = "404") }

	)

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Subject>> fetchSubjectById(@PathVariable("id") int id) {
		ResponseStructure<Subject> structure = service.fetchSubjectById(id);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "This endpoint retrieves the details of a subject based on its subject code. If no subject with the given code is found, it returns a 404 status code", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " Code Not Prsent", responseCode = "404") }

	)

	@GetMapping("/fetchBycode/{code}")
	public ResponseEntity<ResponseStructure<Subject>> fetchSubjecBycode(@PathVariable("code") String code) {
		ResponseStructure<Subject> structure = service.fetchSubjecBycode(code);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "This endpoint retrieves a list of subjects based on the class name. If no subjects are found for the given class name, it returns an empty list", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " Class Name Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchByclassname/{className}")
	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjecClassName(
			@PathVariable("className") String className) {
		ResponseStructure<List<Subject>> structure = service.fetchSubjecClassName(className);
		return new ResponseEntity<ResponseStructure<List<Subject>>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "This endpoint retrieves a list of subjects associated with the given student ID. Returns 404 if no subjects are found for the student ID", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = "Student ID Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchSubjecByStudentID/{sID}")
	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjecByStudentID(@PathVariable("sID") int sID) {
		ResponseStructure<List<Subject>> structure = service.fetchSubjecByStudentID(sID);
		return new ResponseEntity<ResponseStructure<List<Subject>>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "This endpoint saves a new subject and associates it with the specified class name. Returns 409 if a subject with the given code already exists", responses = {
					@ApiResponse(description = "Sucess", responseCode = "201"),
					@ApiResponse(description = " Code Allready Prsent", responseCode = "409") }

	)
	@PostMapping("/SaveSubject/{className}")
	public ResponseEntity<ResponseStructure<Subject>> SaveSubject(@RequestBody Subject s,
			@PathVariable("className") String className) {
		ResponseStructure<Subject> structure = service.SaveSubject(s, className);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Updates an existing Subject based on the subject's ID", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " Code Allready Prsent", responseCode = "409") }

	)
	@PutMapping("Update/{id}")
	public ResponseEntity<ResponseStructure<Subject>> UpdateSubject(@PathVariable("id") int id,
			@RequestBody Subject s) {
		ResponseStructure<Subject> structure = service.UpdateSubject(s, id);

		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "This endpoint updates an existing subject using the subject ID. Returns 409 if a subject with the same code already exists", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = " Id Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/deleteSubjecByID/{id}")
	public ResponseEntity<ResponseStructure<Subject>> deleteSubjecByID(@PathVariable("id") int id) {
		ResponseStructure<Subject> structure = service.deleteSubjecByID(id);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}
}
