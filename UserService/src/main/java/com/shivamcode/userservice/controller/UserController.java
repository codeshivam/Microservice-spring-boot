package com.shivamcode.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shivamcode.userservice.entity.User;
import com.shivamcode.userservice.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger= LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = service.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> fetchAllUser(){
		List<User> li= service.getAllUser();
		return ResponseEntity.status(HttpStatus.FOUND).body(li);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable String id){
		try {
			User user = service.getUserById(id);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		try {
			User updatedUser = service.updateUser(user);
			return ResponseEntity.ok(updatedUser);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		try {
			String str = service.deleteUser(id);
			return ResponseEntity.status(HttpStatus.OK).body(str);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
