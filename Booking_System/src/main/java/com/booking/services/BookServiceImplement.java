package com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entities.Books;
import com.booking.repository.BooksRepository;

@Service
public class BookServiceImplement implements BookService {

	@Autowired
	private BooksRepository bookrepo;

	@Override
	public List<Books> checkHistory(int user_id) {
		return bookrepo.findHistory(user_id);
	}

}
