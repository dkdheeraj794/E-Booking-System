package com.booking.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Component
@Table
@Data
public class User {

	@Id
	private int userId;
	private String userName;
	private String address;
	private String phoneNumber;
	private String emailTo;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public User(int userId, String userName, String address, String phoneNumber, String emailTo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailTo = emailTo;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", emailTo=" + emailTo + "]";
	}

}
