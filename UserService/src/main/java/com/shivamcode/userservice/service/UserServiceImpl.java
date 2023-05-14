package com.shivamcode.userservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shivamcode.userservice.entity.Hotel;
import com.shivamcode.userservice.entity.Rating;
import com.shivamcode.userservice.entity.User;
import com.shivamcode.userservice.exception.RecordNotFoundException;
import com.shivamcode.userservice.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		Iterable<User> li = repo.findAll();
		return (List)li;
	}

	@Override
	public User getUserById(String id) throws RecordNotFoundException {
			Optional<User> result = repo.findById(id);
			if (result.isPresent()) {
				// All rating from this user
				String url = "http://localhost:8083/rating/userid/"+id;
				Rating[] ratingForUser= restTemplate.getForObject(url, Rating[].class);
				List<Rating> li = Arrays.stream(ratingForUser).toList();
				User res = result.get();
				//For each rating find hotel detail
				List<Rating> nl = li.stream().map((rating) -> {
					String url1 = "http://localhost:8082/hotels/"+rating.getHotelid();
					Hotel hotel = restTemplate.getForObject(url1, Hotel.class);
					rating.setHotel(hotel);
					return rating;
				}).collect(Collectors.toList());
				
				res.setRating(nl);
				return res;
			} else {
				throw new RecordNotFoundException("User not found for UserId: " + id + " in " + getClass().getName(),
						null);
			}
	}

	@Override
	public User updateUser(User user)throws Exception{
		Optional<User> userToUpdate = repo.findById(user.getId());
		if(userToUpdate.isPresent()) {
			User up = userToUpdate.get();
			up.setName(user.getName());
			up.setAbout(user.getAbout());
			up.setEmail(user.getEmail());
			repo.save(up);
			return up;
		}else {
			throw new RecordNotFoundException("User not found for UserId: " + user.getId() + " in " + getClass().getName(),
					null);
		}
	}

	@Override
	public String deleteUser(String id) throws Exception {
		Optional<User> userToDelete = repo.findById(id);
		if(userToDelete.isPresent()) {
			User up = userToDelete.get();
			repo.delete(up);
			return "Successfully Deleted";
		}else {
			throw new RecordNotFoundException("User not found for UserId: " + id + " in " + getClass().getName(),
					null);
		}
	}

}
