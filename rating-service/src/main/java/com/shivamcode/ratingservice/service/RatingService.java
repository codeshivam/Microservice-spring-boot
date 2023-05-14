package com.shivamcode.ratingservice.service;

import java.util.List;

import com.shivamcode.ratingservice.entity.Rating;

public interface RatingService {
	
	public Rating createRating(Rating rating);
	public List<Rating> getRatingId();
	public List<Rating> getByUserId(String userId);
	public List<Rating> getByHotelId(String hotelId);

}
