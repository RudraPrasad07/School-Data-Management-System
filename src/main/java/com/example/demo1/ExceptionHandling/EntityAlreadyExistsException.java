package com.example.demo1.ExceptionHandling;

public class EntityAlreadyExistsException extends RuntimeException {

	public EntityAlreadyExistsException(String msg) {
		super(msg);
	}

}
