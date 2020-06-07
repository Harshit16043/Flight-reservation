package com.harshit.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.flightReservation.entities.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
