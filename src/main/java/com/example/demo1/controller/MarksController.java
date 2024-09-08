package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.MarksService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Mark;

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
public class MarksController {
	@Autowired
	public MarksService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Mark>> saveMark(@RequestBody Mark m, @RequestParam("sid") int studentId,
			@RequestParam("subid") int subjectID) {
		ResponseStructure<Mark> structure = service.saveMark(m, subjectID, subjectID);

		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

	@PutMapping("/updateMark/{id}")
	public ResponseEntity<ResponseStructure<Mark>> upDateMark(@PathVariable("id") int id, @RequestBody Mark m) {
		ResponseStructure<Mark> structure = service.upDateMark(m, id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchBymarkByID/{id}")
	public ResponseEntity<ResponseStructure<Mark>> fetchBymarkByID(@PathVariable("id") int id) {
		ResponseStructure<Mark> structure = service.fetchBymarkByID(id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchMarkByStudentId/{Id}")
	public ResponseEntity<ResponseStructure<List<Mark>>> fetchMarkByStudentId(@PathVariable("Id") int Id) {
		ResponseStructure<List<Mark>> structure = service.fetchMarkByStudentId(Id);
		return new ResponseEntity<ResponseStructure<List<Mark>>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchMarkBySubjectId/{Id}")
	public ResponseEntity<ResponseStructure<List<Mark>>> fetchMarkBySubjectId(@PathVariable("Id") int Id) {
		ResponseStructure<List<Mark>> structure = service.fetchMarkBySubjectId(Id);
		return new ResponseEntity<ResponseStructure<List<Mark>>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{Id}")
	public ResponseEntity<ResponseStructure<Mark>> deleteByID(@PathVariable("Id") int Id) {
		ResponseStructure<Mark> structure = service.deleteByID(Id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}

}
