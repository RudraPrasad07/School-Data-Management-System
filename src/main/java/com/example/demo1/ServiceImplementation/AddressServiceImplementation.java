package com.example.demo1.ServiceImplementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Service.AddressService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.AddressDao;
import com.example.demo1.entity.Address;

@Service
public class AddressServiceImplementation implements AddressService {
	@Autowired
	private AddressDao dao;

	@Override
	public ResponseStructure<Address> saveAddress(Address a) {
		Address savAddress = dao.savAddress(a);
		return new ResponseStructure<Address>(201, "Address Saved Sucessfully", savAddress, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> updateAddress(Address a, int id) {
		Address updateAddress = dao.updateAddress(a, id);
		return new ResponseStructure<Address>(200, "Address Updated Sucessfully", updateAddress, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> deleteAdress(int id) {
		dao.deleteAddress(id);
		return new ResponseStructure<Address>(200, "Address Saved Sucessfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> fetchAddress(int id) {
		Address address = dao.fetchAddress(id);
		return new ResponseStructure<Address>(200, "Address Saved Sucessfully", address, LocalDateTime.now());
	}

}
