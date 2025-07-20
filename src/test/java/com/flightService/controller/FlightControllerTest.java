package com.flightService.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightService.model.Acknowledgement;
import com.flightService.model.BookingRequest;
import com.flightService.model.Passenger;
import com.flightService.service.FlightBookingService;

@ExtendWith(MockitoExtension.class)
public class FlightControllerTest {
	
	@Mock
	FlightBookingService service;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testBookFlight() throws Exception{
		var request=new BookingRequest(101,"Sayan","Kolkata","Mumbai",LocalDate.now(),5000,"acc1");
		var ack=new Acknowledgement(101,"Sayan","Kolkata - Mumbai",5000,"Success");

		when(service.bookFlight(request)).thenReturn(ack);
		mockMvc.perform(post("/book")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request)))
		.andExpect(status().isOk());
	}
	
	@Test
	void testGetInfo() throws Exception {
		var obj=new Passenger(101,"Sayan","Kolkata","Mumbai",LocalDate.now(),5000);
		when(service.getPassengerInfo("101")).thenReturn(obj);
		mockMvc.perform(get("/info/{id}",101)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
