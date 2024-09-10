package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.ClassService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Class;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/class")
@Tag(name = "Calss")
public class ClassController {

	@Autowired
	public ClassService service;

	@Operation(

			description = "Creates and saves a new class in the system. Returns the details of the created class", responses = {
					@ApiResponse(description = "Sucess", responseCode = "201"),
					@ApiResponse(description = "Year And Name all ready Present ", responseCode = "409") }

	)
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Class>> Saveclass(@RequestBody Class c) {
		ResponseStructure<Class> structure = service.Saveclass(c);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Updates the details of an existing class based on its ID. Returns the updated class details", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = "Year And Name all ready Present and Id Id Not Present ", responseCode = "404") }

	)

	@PutMapping("update/{id}")
	public ResponseEntity<ResponseStructure<Class>> Updateclass(@PathVariable("id") int id, @RequestBody Class c) {
		ResponseStructure<Class> structure = service.Updateclass(id, c);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves the details of a class based on its unique ID. Returns 404 if no class is found with the given ID", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " ID Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Class>> fetchClassById(@PathVariable("id") int id) {
		ResponseStructure<Class> structure = service.fetchClassById(id);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves a list of classes based on the academic year. Returns an empty list if no classes are found for the given year", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " Year Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchByYear/{year}")
	public ResponseEntity<ResponseStructure<List<Class>>> fetchClassesByAcademiCYear(@PathVariable("year") int year) {
		ResponseStructure<List<Class>> structure = service.fetchClassesByAcademiCYear(year);
		return new ResponseEntity<ResponseStructure<List<Class>>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Deletes a class based on its unique ID. Returns 404 if no class is found with the given ID", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = " Id Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Class>> deleteClassById(@PathVariable("id") int id) {
		ResponseStructure<Class> structure = service.deleteClassById(id);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Deletes all classes associated with the given academic year. Returns 404 if no classes are found for the year", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = " Id Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/deleteByYear/{year}")
	public ResponseEntity<ResponseStructure<Class>> deleteClassesByAcademiCYear(@PathVariable("year") int year) {
		ResponseStructure<Class> structure = service.deleteClassesByAcademiCYear(year);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

}
