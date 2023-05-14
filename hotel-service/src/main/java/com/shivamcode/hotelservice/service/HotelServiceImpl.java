package com.shivamcode.hotelservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivamcode.hotelservice.entity.Hotel;
import com.shivamcode.hotelservice.exception.ResourseNotFoundException;
import com.shivamcode.hotelservice.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepo repo;

	// get hotel by id

	@Override
	public Hotel getHotelById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Resourse not found for " + id));
	}

	// update hotel by id
	@Override
	public Hotel update(Hotel hotel) {
		// TODO Auto-generated method stub
		Hotel h = repo.findById(hotel.getId())
				.orElseThrow(() -> new ResourseNotFoundException("Hotel not found for id : " + hotel.getId()));
		h.setName(hotel.getName());
		h.setAbout(hotel.getAbout());
		h.setLocation(hotel.getLocation());
		repo.save(h);
		return h;
	}

	// delete hotel by id
	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		Hotel hotelToBeDeleted = repo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Hotel not found for id : " + id));
		repo.delete(hotelToBeDeleted);
		return "Hotel deleted successfully";
	}

	// create hotel data
	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return (List<Hotel>) repo.findAll();
	}

}
