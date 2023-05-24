package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booking.entities.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	@Query(value = "Select u from Books u where u.user_id=?1 ")
	List<Books> findHistory(int user_id);

}
