package com.booking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entities.User;
import com.booking.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userservices;
	
	
	// Adding the User
	@PostMapping("/adduser")
	private ResponseEntity<String> adduser(@RequestBody User user){
		String status = userservices.upsert(user);
		return new ResponseEntity<>(status , HttpStatus.CREATED);
	}
	
	// Get all the User
	@GetMapping("/user")
	public List<User> getuser(){
		return userservices.getUser();
	}
	
    // Booking the Ticket and Email Notification
	@GetMapping("/booking")
	public List<String> bookDetail(@RequestBody Map<String,String> book){
		return userservices.bookDetails(Integer.parseInt(book.get("userId")),Integer.parseInt(book.get("busId")));
	}
	
	
	
	
	
	
}
