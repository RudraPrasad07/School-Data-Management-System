package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.AddressService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Address;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	public AddressService addressService;

	@PutMapping("updateaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable("id") int id,
			@RequestBody Address a) {
		ResponseStructure<Address> address = addressService.updateAddress(a, id);
		return new ResponseEntity<ResponseStructure<Address>>(address, HttpStatus.OK);

	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Address>> getMethodName(@PathVariable int id) {
		ResponseStructure<Address> address = addressService.deleteAdress(id);
		return new ResponseEntity<ResponseStructure<Address>>(address, HttpStatus.OK);
	}

}
