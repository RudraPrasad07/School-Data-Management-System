package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entity.Address;

public interface AddressRepositry extends JpaRepository<Address, Integer> {

}
