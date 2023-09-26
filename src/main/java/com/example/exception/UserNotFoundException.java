package com.example.exception;

public class UserNotFoundException extends RuntimeException {
	
	private String message;
	
	// CONSTRUTOR
	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
