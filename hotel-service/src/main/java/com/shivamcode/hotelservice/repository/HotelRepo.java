package com.shivamcode.hotelservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shivamcode.hotelservice.entity.Hotel;

public interface HotelRepo extends CrudRepository<Hotel, String> {

}
