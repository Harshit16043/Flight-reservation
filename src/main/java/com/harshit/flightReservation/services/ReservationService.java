package com.harshit.flightReservation.services;

import com.harshit.flightReservation.dto.ReservationRequest;
import com.harshit.flightReservation.entities.Reservation;

public interface ReservationService {
		public Reservation bookflight(ReservationRequest request);
			
		
}
