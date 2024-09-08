package com.example.demo1.daoImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.ExceptionHandling.EntityNotPresentexception;
import com.example.demo1.Repositry.AddressRepositry;
import com.example.demo1.dao.AddressDao;
import com.example.demo1.entity.Address;

@Repository
public class AddressDaoImplementation implements AddressDao {
	@Autowired
	private AddressRepositry repositry;

	@Override
	public Address savAddress(Address a) {
		return repositry.save(a);
	}

	@Override
	public Address updateAddress(Address a, int id) {
		if (!repositry.existsById(id)) {
			throw new EntityNotPresentexception("The " + id + "Which You Pass is Not Present In The Data Base");
		}
		a.setId(id);
		return repositry.save(a);
	}

	@Override
	public boolean deleteAddress(int id) {
		Address address = fetchAddress(id);
		repositry.delete(address);
		return true;
	}

	@Override
	public Address fetchAddress(int id) {
		Optional<Address> optional = repositry.findById(id);
		return optional.orElseThrow(() -> new EntityNotPresentexception("Address With " + id + " is Not Prsent"));
	}

}
