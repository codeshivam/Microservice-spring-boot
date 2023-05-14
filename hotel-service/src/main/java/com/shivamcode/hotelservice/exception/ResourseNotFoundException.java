package com.shivamcode.hotelservice.exception;

public class ResourseNotFoundException extends RuntimeException {

	public ResourseNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resourse not found");
	}

	public ResourseNotFoundException(String message) {
		super(message);
	}

}
