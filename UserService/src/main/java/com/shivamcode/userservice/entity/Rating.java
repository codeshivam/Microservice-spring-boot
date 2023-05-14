package com.shivamcode.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	
	public String rating_id;
	public String hotelid;
	public String userid;
	public int rating;
	public String feedback;
	public Hotel hotel;

}
