package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entities.TicketBook;

public interface TicketRepository extends JpaRepository<TicketBook, Integer> {

}
