package com.booking.services;

import java.util.List;

import com.booking.entities.Books;

public interface BookService {

	public List<Books> checkHistory(int user_id);

}
