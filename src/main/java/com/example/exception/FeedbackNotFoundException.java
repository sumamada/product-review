package com.example.exception;


public class FeedbackNotFoundException extends RuntimeException {
	
	private String message;
	
	// CONSTRUTOR
	public FeedbackNotFoundException(String message) {
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
