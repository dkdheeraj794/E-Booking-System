package com.booking.services;

import java.util.List;

import com.booking.entities.Bus;

public interface BusServices {

	public String upsert(Bus bus);

	public List<Bus> getAllBus();

	public List<String> searchBuses(String source, String destination, String dateofJourney, String classJourney);

	public List<Bus> filterDetails(int busId, String busName);

}
