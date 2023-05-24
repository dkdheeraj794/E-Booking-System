package com.booking.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bus {

	@Id
	private int busId;
	private String busName;
	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private String dateofJourney;
	private String classJourney;
	private String price;
	private String midStation;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDateofJourney() {
		return dateofJourney;
	}

	public void setDateofJourney(String dateofJourney) {
		this.dateofJourney = dateofJourney;
	}

	public String getClassJourney() {
		return classJourney;
	}

	public void setClassJourney(String classJourney) {
		this.classJourney = classJourney;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMidStation() {
		return midStation;
	}

	public void setMidStation(String midStation) {
		this.midStation = midStation;
	}

	public Bus(int busId, String busName, String source, String destination, String departureTime, String arrivalTime,
			String dateofJourney, String classJourney, String price, String midStation) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.dateofJourney = dateofJourney;
		this.classJourney = classJourney;
		this.price = price;
		this.midStation = midStation;
	}

	public Bus() {
		super();
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", source=" + source + ", destination=" + destination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", dateofJourney="
				+ dateofJourney + ", classJourney=" + classJourney + ", price=" + price + ", midStation=" + midStation
				+ "]";
	}

}
