package com.example.demo1.Service;

import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Address;

public interface AddressService {
	ResponseStructure<Address> saveAddress(Address a);

	ResponseStructure<Address> updateAddress(Address a, int id);

	ResponseStructure<Address> deleteAdress(int id);

	ResponseStructure<Address> fetchAddress(int id);

}
