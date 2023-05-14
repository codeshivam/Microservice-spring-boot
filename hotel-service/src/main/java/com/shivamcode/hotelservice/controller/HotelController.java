package com.shivamcode.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivamcode.hotelservice.entity.Hotel;
import com.shivamcode.hotelservice.service.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelServiceImpl service;
	
	@PostMapping("/add")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addHotel(hotel));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> findAllHotel(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping("/update")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.FOUND).body(service.update(hotel));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getHotelById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.delete(id));
	}
}
