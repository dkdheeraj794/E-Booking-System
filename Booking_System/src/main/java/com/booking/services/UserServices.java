package com.booking.services;

import java.util.List;

import com.booking.entities.User;

public interface UserServices {

	public String upsert(User user);

	public List<User> getUser();

	// public List<User> bookdetail(int userId);

	public List<String> bookDetails(Integer userId, Integer busId);
}
