package com.shivamcode.ratingservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Rating {
	
	@Id
	public String rating_id;
	public String hotelid;
	public String userid;
	public int rating;
	public String feedback;
}
