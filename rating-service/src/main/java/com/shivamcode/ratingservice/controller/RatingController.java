package com.shivamcode.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivamcode.ratingservice.entity.Rating;
import com.shivamcode.ratingservice.service.RatingServiceImpl;


@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingServiceImpl service;
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatig(){
		return ResponseEntity.ok(service.getRatingId());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
	}
	
	@GetMapping("/userid/{useridiii}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String useridiii){
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getByUserId(useridiii));
	}
	
	@GetMapping("/hotelid/{hotelid}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelid){
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getByHotelId(hotelid));
	}

}
