package com.harshit.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.flightReservation.dto.ReservationUpdateRequest;
import com.harshit.flightReservation.entities.Reservation;
import com.harshit.flightReservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		Reservation reservation = reservationRepo.findById(id).get();
		
		
		return reservation;
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepo.findById(request.getId()).get();
		reservation.setNoOfBags(request.getNoOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		Reservation updatedReservation = reservationRepo.save(reservation);
		return updatedReservation;
	}
	

}
