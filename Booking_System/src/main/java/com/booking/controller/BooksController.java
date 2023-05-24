package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entities.Books;
import com.booking.services.BookService;

@RestController
public class BooksController {

	@Autowired
	private BookService bookservice;

	// Check the History
	@GetMapping("/history")
	public List<Books> checkhistory(@RequestBody String user_id) {
		return bookservice.checkHistory(Integer.parseInt(user_id));
	}

}
