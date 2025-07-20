package com.flightService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightService.model.Acknowledgement;
import com.flightService.model.BookingRequest;
import com.flightService.model.Passenger;
import com.flightService.service.FlightBookingService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	private FlightBookingService service;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Flight Booking System";
	}
	
	@PostMapping("/book")
	public Acknowledgement bookFlight(@RequestBody BookingRequest request) {
		return service.bookFlight(request);
		
	}
	
	@GetMapping("/info/{id}")
	public Passenger getInfo(@PathVariable String id) {
		return service.getPassengerInfo(id);
	}

}
