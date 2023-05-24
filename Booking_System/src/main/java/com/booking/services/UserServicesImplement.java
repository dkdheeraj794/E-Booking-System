package com.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.booking.entities.Books;
import com.booking.entities.Bus;
import com.booking.entities.TicketBook;
import com.booking.entities.User;
import com.booking.repository.BooksRepository;
import com.booking.repository.BusRepository;
import com.booking.repository.TicketRepository;
import com.booking.repository.UserRepository;

@Service
public class UserServicesImplement implements UserServices {

	@Autowired
	private UserRepository userepo;

	@Autowired
	private BusRepository busrepo;

	@Autowired
	private BooksRepository bookrepo;

	@Autowired
	private TicketRepository ticketrepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String upsert(User user) {

		try {
			userepo.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Success";
	}

	@Override
	public List<User> getUser() {

		return userepo.findAll();
	}

	@Override
	public List<String> bookDetails(Integer userId, Integer busId) {
		String date_of_journey;
		String from_source;
		String to_destination;
		String user_name;
		String user_address;
		String user_phone_numbers;
		String departure;
		String arrival;
		String prices;

		List<String> str = new ArrayList<>();
		str.add("User Id : " + Integer.toString(userId));
		User users = userepo.findById(userId).get();

		user_name = users.getUserName();
		str.add("UserName : " + user_name);

		user_address = users.getAddress();
		str.add("Address : " + user_address);

		user_phone_numbers = users.getPhoneNumber();
		str.add("Phone Number : " + user_phone_numbers);

		Bus buses = busrepo.findById(busId).get();
		date_of_journey = buses.getDateofJourney();
		str.add("Date_of_Journey : " + date_of_journey);

		from_source = buses.getSource();
		str.add("FROM : " + from_source);

		to_destination = buses.getDestination();
		str.add("Destination : " + to_destination);

		departure = buses.getDepartureTime();
		arrival = buses.getArrivalTime();
		prices = buses.getPrice();

		// Storing the data for Booking Repository
		Books book = new Books();
		book.setDate_ofJourney(date_of_journey);
		book.setFrom_source(from_source);
		book.setTo_destination(to_destination);
		book.setUser_address(user_address);
		book.setUser_id(userId);
		book.setUser_mobile_number(user_phone_numbers);
		book.setUser_name(user_name);
		bookrepo.save(book);

		// This is used for the Sending the Mail on Successful Booked of Ticket
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(users.getEmailTo());
		mail.setSubject("Ticket Confirmation");
		mail.setText("Hurray ! You have Booked your ticket Successfully");
		javaMailSender.send(mail);

		// Storing the Data for Ticket Repository
		TicketBook ticket = new TicketBook();
		ticket.setBussid_s(busId);
		ticket.setFrom_s(from_source);
		ticket.setTo_s(to_destination);
		ticket.setDoj_s(date_of_journey);
		ticket.setDeparture_time(departure);
		ticket.setArrival_time(arrival);
		ticket.setUser_name(user_name);
		ticket.setPrice_s(prices);
		ticketrepo.save(ticket);

		return str;

	}

}
