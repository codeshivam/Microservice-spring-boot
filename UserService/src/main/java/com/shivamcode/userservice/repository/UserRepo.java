package com.shivamcode.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shivamcode.userservice.entity.User;

public interface UserRepo extends CrudRepository<User, String> {

}
