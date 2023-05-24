package com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entities.Bus;
import com.booking.repository.BusRepository;

@Service
public class BusServicesImplement implements BusServices {

	@Autowired
	private BusRepository busrepo;

	@Override
	public String upsert(Bus bus) {

		try {
			busrepo.save(bus);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "Success";
	}

	@Override
	public List<Bus> getAllBus() {
		return busrepo.findAll();
	}

	@Override
	public List<String> searchBuses(String source, String destination, String dateofJourney, String classJourney) {
		return busrepo.findbus(source, destination, dateofJourney, classJourney);
	}

	@Override
	public List<Bus> filterDetails(int busId, String busName) {
		return busrepo.filterdetail(busId, busName);
	}

}
