package com.booking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Books {

	@Id
	@GeneratedValue
	private int book_id;
	private int user_id;
	private String user_name;
	private String user_address;
	private String user_mobile_number;
	private String date_ofJourney;
	private String from_source;
	private String to_destination;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_mobile_number() {
		return user_mobile_number;
	}

	public void setUser_mobile_number(String user_mobile_number) {
		this.user_mobile_number = user_mobile_number;
	}

	public String getDate_ofJourney() {
		return date_ofJourney;
	}

	public void setDate_ofJourney(String date_ofJourney) {
		this.date_ofJourney = date_ofJourney;
	}

	public String getFrom_source() {
		return from_source;
	}

	public void setFrom_source(String from_source) {
		this.from_source = from_source;
	}

	public String getTo_destination() {
		return to_destination;
	}

	public void setTo_destination(String to_destination) {
		this.to_destination = to_destination;
	}

	public Books(int book_id, int user_id, String user_name, String user_address, String user_mobile_number,
			String date_ofJourney, String from_source, String to_destination) {
		super();
		this.book_id = book_id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_mobile_number = user_mobile_number;
		this.date_ofJourney = date_ofJourney;
		this.from_source = from_source;
		this.to_destination = to_destination;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", user_id=" + user_id + ", user_name=" + user_name + ", user_address="
				+ user_address + ", user_mobile_number=" + user_mobile_number + ", date_ofJourney=" + date_ofJourney
				+ ", from_source=" + from_source + ", to_destination=" + to_destination + "]";
	}

}
