package com.shivamcode.hotelservice.service;

import java.util.List;

import com.shivamcode.hotelservice.entity.Hotel;

public interface HotelService {
	public List<Hotel> getAll();
	public Hotel getHotelById(String id);
	public Hotel update(Hotel hotel);
	public String delete(String id);
	public Hotel addHotel(Hotel hotel);
}
