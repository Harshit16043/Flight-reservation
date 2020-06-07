package com.harshit.flightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.flightReservation.dto.ReservationRequest;
import com.harshit.flightReservation.entities.Flight;
import com.harshit.flightReservation.entities.Passenger;
import com.harshit.flightReservation.entities.Reservation;
import com.harshit.flightReservation.repos.FlightRepository;
import com.harshit.flightReservation.repos.PassengerRepository;
import com.harshit.flightReservation.repos.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	
	@Autowired
	FlightRepository flightrepo;
	
	@Autowired
	PassengerRepository passengerrepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Override
	public Reservation bookflight(ReservationRequest request) {
		Long flightId = request.getFlightId();
		Flight flight = flightrepo.getOne(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		
		Passenger savedPassenger = passengerrepo.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation SavedReservation = reservationRepo.save(reservation);
		
		
		
		return SavedReservation;
	}

}
