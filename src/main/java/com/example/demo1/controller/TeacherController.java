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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@PostMapping("/saveteacher")
	public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(@RequestBody Teacher t) {
		ResponseStructure<Teacher> teacher = service.saveTeacher(t);
		return new ResponseEntity<ResponseStructure<Teacher>>(teacher, HttpStatus.OK);
	}

	@PutMapping("UpdateTeacher/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> UpdateTeacher(@PathVariable("id") int id,
			@RequestBody Teacher t) {
		ResponseStructure<Teacher> teacher = service.UpdateTeacher(t, id);
		return new ResponseEntity<ResponseStructure<Teacher>>(teacher, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> fetchTeacherById(@PathVariable("id") int id) {
		ResponseStructure<Teacher> structure = service.fetchTeacherById(id);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByNumber/{number}")
	public ResponseEntity<ResponseStructure<Teacher>> fetchByNumber(@PathVariable("number") String number) {
		ResponseStructure<Teacher> structure = service.fetchByNumber(number);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByName/{Classname}")
	public ResponseEntity<ResponseStructure<List<Teacher>>> fetchTeacherByclassName(
			@PathVariable("Classname") String Classname) {
		ResponseStructure<List<Teacher>> structure = service.fetchTeacherByclassName(Classname);
		return new ResponseEntity<ResponseStructure<List<Teacher>>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> deleteByID(@PathVariable("id") int id) {
		ResponseStructure<Teacher> structure = service.deleteByID(id);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/DeleteByNumber/{Number}")
	public ResponseEntity<ResponseStructure<Teacher>> deleteByNumber(@PathVariable("Number") String Number) {
		ResponseStructure<Teacher> structure = service.deleteByNumber(Number);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}
}
