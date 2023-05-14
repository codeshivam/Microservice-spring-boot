package com.shivamcode.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shivamcode.ratingservice.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
	List<Rating> findByuserid(String user_id);
	List<Rating> findByhotelid(String hotel_id);
}
