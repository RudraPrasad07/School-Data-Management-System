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

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	public SubjectService service;

	@PostMapping("/SaveSubject/{className}")
	public ResponseEntity<ResponseStructure<Subject>> SaveSubject(@RequestBody Subject s,
			@PathVariable("className") String className) {
		ResponseStructure<Subject> structure = service.SaveSubject(s, className);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@PutMapping("Update/{id}")
	public ResponseEntity<ResponseStructure<Subject>> UpdateSubject(@PathVariable("id") int id,
			@RequestBody Subject s) {
		ResponseStructure<Subject> structure = service.UpdateSubject(s, id);

		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Subject>> fetchSubjectById(@PathVariable("id") int id) {
		ResponseStructure<Subject> structure = service.fetchSubjectById(id);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchBycode/{code}")
	public ResponseEntity<ResponseStructure<Subject>> fetchSubjecBycode(@PathVariable("code") String code) {
	ResponseStructure<Subject> structure = service.fetchSubjecBycode(code);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByclassname/{className}")
	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjecClassName(
			@PathVariable("className") String className) {
		ResponseStructure<List<Subject>> structure = service.fetchSubjecClassName(className);
		return new ResponseEntity<ResponseStructure<List<Subject>>>(structure,HttpStatus.OK);
	}

	@GetMapping("/fetchSubjecByStudentID/{sID}")
	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjecByStudentID(@PathVariable("sID") int sID) {
		ResponseStructure<List<Subject>> structure = service.fetchSubjecByStudentID(sID);
		return new ResponseEntity<ResponseStructure<List<Subject>>>(structure,HttpStatus.OK);
	}

	@DeleteMapping("/deleteSubjecByID/{id}")
	public ResponseEntity<ResponseStructure<Subject>> deleteSubjecByID(@PathVariable("id") int id) {
		ResponseStructure<Subject> structure = service.deleteSubjecByID(id);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}
}
