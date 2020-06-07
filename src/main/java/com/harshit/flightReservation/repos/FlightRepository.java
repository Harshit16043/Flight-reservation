package com.harshit.flightReservation.repos;


import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.harshit.flightReservation.entities.Flight;

import antlr.collections.List;


public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	@Query("from Flight where departureCity = :departureCity and arrivalCity= :arrivalCity and dateOfDeparture= :dateOfDeparture" )
	ArrayList<Flight> findFlights(@Param("departureCity")String from, @Param("arrivalCity")String to, @Param("dateOfDeparture") String departureDate);
	

}
