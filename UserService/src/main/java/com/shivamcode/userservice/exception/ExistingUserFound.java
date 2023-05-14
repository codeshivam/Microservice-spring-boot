package com.shivamcode.userservice.exception;

public class ExistingUserFound extends RuntimeException {

	public ExistingUserFound() {
		super("User already exists");
		// TODO Auto-generated constructor stub
	}

	public ExistingUserFound(String message) {
		super(message);
	}

}
