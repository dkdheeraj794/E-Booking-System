package com.booking.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.booking.entities.TicketBook;
import com.booking.services.TicketService;

@RestController
public class TicketBookController {

	@Autowired
	private TicketService ticketservice;

	@GetMapping("/tickets/{tickets_id}")
	public ResponseEntity<TicketBook> getTicket(@PathVariable int tickets_id) {
		TicketBook ticketbook = ticketservice.getTicket(tickets_id);
		return ResponseEntity.ok().body(ticketbook);

	}

	@GetMapping("/download/{tickets_id}")
	public ResponseEntity<ByteArrayResource> downloadTicket(@PathVariable int tickets_id) throws IOException {
		byte[] ticketPdf = ticketservice.downloadTicket(tickets_id);
		ByteArrayResource resource = new ByteArrayResource(ticketPdf);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"ticket-" + tickets_id + ".pdf\"");
		return ResponseEntity.ok().headers(headers).body(resource);
	}

}
