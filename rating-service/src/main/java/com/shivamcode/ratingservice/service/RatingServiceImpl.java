package com.shivamcode.ratingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivamcode.ratingservice.entity.Rating;
import com.shivamcode.ratingservice.exception.RatingNotFoundException;
import com.shivamcode.ratingservice.repository.RatingRepository;
import com.shivamcode.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository repo;
	
	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		return repo.save(rating);
	}

	@Override
	public List<Rating> getRatingId() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Rating> getByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Rating> li = repo.findByuserid(userId);
		if(li.size() == 0) {
			throw new RatingNotFoundException("Rating not found for userId :"+userId);
		}else {
			return li;
		}
	}

	@Override
	public List<Rating> getByHotelId(String hotelId) {
		List<Rating> li = repo.findByhotelid(hotelId);
		if(li.size() == 0) {
			throw new RatingNotFoundException("Rating not found for hotelId :"+hotelId);
		}else {
			return li;
		}
	}

}
