package com.spring.demo.exception;

public class EmailExistException extends RuntimeException {
	
	public EmailExistException(String message) {
		super(message);
	}

}
