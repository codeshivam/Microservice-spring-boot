package com.shivamcode.userservice.service;

import java.util.List;

import com.shivamcode.userservice.entity.User;
import com.shivamcode.userservice.exception.RecordNotFoundException;

public interface UserService {

	public User addUser(User user);
	public List<User> getAllUser();
	public User getUserById(String id) throws RecordNotFoundException;
	public User updateUser(User user)throws Exception;
	public String deleteUser(String id) throws Exception;
}
