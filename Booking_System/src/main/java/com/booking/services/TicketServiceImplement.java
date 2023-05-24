package com.booking.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entities.TicketBook;
import com.booking.repository.TicketRepository;

@Service
public class TicketServiceImplement implements TicketService {

	@Autowired
	private TicketRepository ticketrepo;

	@Override
	public TicketBook getTicket(int tickets_id) {
		return ticketrepo.findById(tickets_id).get();
	}

	@Override
	public byte[] downloadTicket(int tickets_id) throws IOException {
		TicketBook ticketbook = getTicket(tickets_id);
		return ticketbook.generatePdf();
	}

}
