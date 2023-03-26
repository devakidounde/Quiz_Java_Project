package com.exception;

@SuppressWarnings("serial")
public class DuplicateUserException extends RuntimeException {
	
	String message;
	
	public DuplicateUserException(String message) {
		super(message);
	}
}
