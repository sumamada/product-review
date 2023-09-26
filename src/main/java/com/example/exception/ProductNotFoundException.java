package com.example.exception;

public class ProductNotFoundException extends RuntimeException {
	
	private String message;
	
	// CONSTRUTOR
	public ProductNotFoundException(String message) {
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
