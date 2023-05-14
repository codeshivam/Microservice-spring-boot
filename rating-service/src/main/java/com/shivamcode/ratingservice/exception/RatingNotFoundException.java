package com.shivamcode.ratingservice.exception;

public class RatingNotFoundException extends RuntimeException {

	public RatingNotFoundException() {
		super("Rating not found");
		// TODO Auto-generated constructor stub
	}

	public RatingNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
