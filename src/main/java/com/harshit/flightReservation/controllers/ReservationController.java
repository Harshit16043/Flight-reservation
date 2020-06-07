package com.harshit.flightReservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshit.flightReservation.dto.ReservationRequest;
import com.harshit.flightReservation.entities.Flight;
import com.harshit.flightReservation.entities.Reservation;
import com.harshit.flightReservation.repos.FlightRepository;
import com.harshit.flightReservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightrepo;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String ShowCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelmap) {
		System.out.println(flightId);
		Flight flight = flightrepo.findById(flightId).get();
		modelmap.addAttribute("flight", flight);
		return "completeReservation";
	
	}
	@RequestMapping(value="/completeReservation" , method=RequestMethod.POST)	
	public String CompleteReser(ReservationRequest request , ModelMap modelmap) {
		Reservation reservation = reservationService.bookflight(request);
		modelmap.addAttribute("msg" , "Reservation created successfully " + reservation.getId());
		return "ReservationConfirmation";
	}
}
