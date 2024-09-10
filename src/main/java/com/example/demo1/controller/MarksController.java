package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.MarksService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Mark;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/Mark")
@Tag(name = "Mark")

public class MarksController {
	@Autowired
	public MarksService service;

	@Operation(

			description = "Creates and saves a new mark record in the system. Requires studentId and subjectID as query parameters. Returns the details of the created mark", responses = {
					@ApiResponse(description = "Sucess", responseCode = "201"),
					@ApiResponse(description = "StudentId and SubjectID is not Present", responseCode = "409") }

	)

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Mark>> saveMark(@RequestBody Mark m, @RequestParam("sid") int studentId,
			@RequestParam("subid") int subjectID) {
		ResponseStructure<Mark> structure = service.saveMark(m, subjectID, subjectID);

		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Updates the details of an existing mark record based on its ID. Returns the updated mark details", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = "Id Id Not Present ", responseCode = "404") }

	)
	@PutMapping("/updateMark/{id}")
	public ResponseEntity<ResponseStructure<Mark>> upDateMark(@PathVariable("id") int id, @RequestBody Mark m) {
		ResponseStructure<Mark> structure = service.upDateMark(m, id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves a mark record based on its ID. Returns the mark details if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = " Id Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchBymarkByID/{id}")
	public ResponseEntity<ResponseStructure<Mark>> fetchBymarkByID(@PathVariable("id") int id) {
		ResponseStructure<Mark> structure = service.fetchBymarkByID(id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves all mark records associated with the given student ID. Returns a list of marks if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = "Student Id Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchMarkByStudentId/{Id}")
	public ResponseEntity<ResponseStructure<List<Mark>>> fetchMarkByStudentId(@PathVariable("Id") int Id) {
		ResponseStructure<List<Mark>> structure = service.fetchMarkByStudentId(Id);
		return new ResponseEntity<ResponseStructure<List<Mark>>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Retrieves all mark records associated with the given subject ID. Returns a list of marks if found", responses = {
					@ApiResponse(description = "Sucess", responseCode = "200"),
					@ApiResponse(description = "Subject Id Not Prsent", responseCode = "404") }

	)
	@GetMapping("/fetchMarkBySubjectId/{Id}")
	public ResponseEntity<ResponseStructure<List<Mark>>> fetchMarkBySubjectId(@PathVariable("Id") int Id) {
		ResponseStructure<List<Mark>> structure = service.fetchMarkBySubjectId(Id);
		return new ResponseEntity<ResponseStructure<List<Mark>>>(structure, HttpStatus.OK);
	}

	@Operation(

			description = "Deletes a mark record based on its ID. Returns a 200 status code if the deletion is successful", responses = {
					@ApiResponse(description = "Sucess", responseCode = "204"),
					@ApiResponse(description = " Id Not Prsent", responseCode = "404") }

	)
	@DeleteMapping("/deleteById/{Id}")
	public ResponseEntity<ResponseStructure<Mark>> deleteByID(@PathVariable("Id") int Id) {
		ResponseStructure<Mark> structure = service.deleteByID(Id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

}
