package com.exception;

@SuppressWarnings("serial")
public class InvalidOptionInputException extends RuntimeException {
	String message;
	
	 public InvalidOptionInputException(String message) {
		super(message);
	}
}
