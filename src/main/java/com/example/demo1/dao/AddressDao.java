package com.example.demo1.dao;

import com.example.demo1.entity.Address;

public interface AddressDao {

	Address savAddress(Address a);

	Address updateAddress(Address a, int id);

	boolean deleteAddress(int id);

	Address fetchAddress(int id);

}
