package com.booking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entities.Bus;
import com.booking.services.BusServices;

@RestController
public class BusController {

	@Autowired
	private BusServices busservices;

	// Add the Bus
	@PostMapping("/addbus")
	public ResponseEntity<String> AddBus(@RequestBody Bus bus) {
		String status = busservices.upsert(bus);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	// Get all the Bus
	@GetMapping("/getbus")
	public ResponseEntity<List<Bus>> GetBus() {
		List<Bus> allBus = busservices.getAllBus();
		return new ResponseEntity<>(allBus, HttpStatus.OK);
	}

	// Search the Bus Based on Source Destination DateofJourney and Class
	@GetMapping("/getsearchbus")
	public List<String> searchbus(@RequestBody Map<String, String> search) {
		return busservices.searchBuses(((search.get("source"))), (search.get("destination")),
				(search.get("dateofJourney")), (search.get("classJourney")));
	}

	// Filter the Details
	@GetMapping("/filterdetail")
	public List<Bus> filterDetail(@RequestBody Map<String, String> details) {
		return busservices.filterDetails(Integer.parseInt(details.get("busId")), details.get("busName"));
	}

}
