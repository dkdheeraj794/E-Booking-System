package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// List<User> bookOption(int userId);

}
