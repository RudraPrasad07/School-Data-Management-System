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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/class")
public class ClassController {

	@Autowired
	public ClassService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Class>> Saveclass(@RequestBody Class c) {
		ResponseStructure<Class> structure = service.Saveclass(c);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ResponseStructure<Class>> Updateclass(@PathVariable("id") int id, @RequestBody Class c) {
		ResponseStructure<Class> structure = service.Updateclass(id, c);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Class>> fetchClassById(@PathVariable("id") int id) {
		ResponseStructure<Class> structure = service.fetchClassById(id);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByYear/{year}")
	public ResponseEntity<ResponseStructure<List<Class>>> fetchClassesByAcademiCYear(@PathVariable("year") int year) {
		ResponseStructure<List<Class>> structure = service.fetchClassesByAcademiCYear(year);
		return new ResponseEntity<ResponseStructure<List<Class>>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Class>> deleteClassById(@PathVariable("id") int id) {
		ResponseStructure<Class> structure = service.deleteClassById(id);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByYear/{year}")
	public ResponseEntity<ResponseStructure<Class>> deleteClassesByAcademiCYear(@PathVariable("year") int year) {
		ResponseStructure<Class> structure = service.deleteClassesByAcademiCYear(year);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

}
