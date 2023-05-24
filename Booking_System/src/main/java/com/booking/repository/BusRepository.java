package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booking.entities.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {

	@Query(value = "Select u.busId , u.busName from Bus u where u.source=?1 and u.destination =?2 and u.dateofJourney =?3 and u.classJourney=?4 ")
	List<String> findbus(String source, String destination, String dateofJourney, String classJourney);

	@Query(value = "Select u from Bus u where u.busId=?1 and u.busName=?2")
	List<Bus> filterdetail(int busId, String busName);

}
