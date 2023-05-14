package com.shivamcode.ratingservice.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RatingNotFoundException.class)
	public ResponseEntity<HashMap<String,Object>> notFoundHandler(RatingNotFoundException e){
		HashMap<String, Object> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("found", false);
		map.put("status",HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
