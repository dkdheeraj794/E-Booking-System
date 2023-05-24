package com.booking.services;

import java.io.IOException;
import java.util.List;

import com.booking.entities.TicketBook;

public interface TicketService {

	public TicketBook getTicket(int tickets_id);

	public byte[] downloadTicket(int tickets_id) throws IOException;

}
