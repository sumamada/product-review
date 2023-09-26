package com.example.exception;


public class AdminNotFoundException extends RuntimeException {
	
	private String message;
	
	// CONSTRUTOR
	public AdminNotFoundException(String message) {
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
