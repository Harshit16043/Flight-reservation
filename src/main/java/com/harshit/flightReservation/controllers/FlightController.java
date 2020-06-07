package com.harshit.flightReservation.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshit.flightReservation.entities.Flight;
import com.harshit.flightReservation.repos.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	FlightRepository flightrepo;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departuredate")  String departureDate,
			ModelMap modelmap) {

		ArrayList<Flight> flights = (ArrayList<Flight>) flightrepo.findFlights(from, to, departureDate);
		modelmap.addAttribute("flights", flights);
		return "displayFlights";

	}
}
