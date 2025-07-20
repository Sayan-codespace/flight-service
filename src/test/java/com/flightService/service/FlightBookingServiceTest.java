package com.flightService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.flightService.model.Acknowledgement;
import com.flightService.model.BookingRequest;
import com.flightService.model.Passenger;
import com.flightService.model.Payment;
import com.flightService.repo.PassengerRepo;
import com.flightService.repo.PaymentRepo;

@ExtendWith(MockitoExtension.class)
public class FlightBookingServiceTest {
	
	//Method method=FlightService.class.getDeclaredMethod("calculateFare",Integer.class);
	//method.setAccessible(true);
	//assertEquals(500,method.invoke(null,50));

	
	@Mock
	PassengerRepo passengerRepo;
	
	@Mock
	PaymentRepo paymentRepo;
	
	@InjectMocks
	FlightBookingService flightService;
	
	@InjectMocks
	FlightBookingService paymentService;
	
	@Test
	void getPassengerByIdSuccess(){
		
		var obj=new Passenger(101,"Sayan","Kolkata","Mumbai",LocalDate.now(),5000);
		when(passengerRepo.findById(101)).thenReturn(Optional.of(obj));
		assertEquals(obj, flightService.getPassengerInfo("101"));
	}
	@Test
	void getPassengerByIdFailed(){
		
		var obj=new Passenger(101,"Sayan","Kolkata","Mumbai",LocalDate.now(),5000);
		lenient().when(passengerRepo.findById(102)).thenReturn(Optional.of(obj));
		assertNotEquals(obj, flightService.getPassengerInfo("101"));
	}
	
	@Test
	void bookFlightSuccess() {
		var request=new BookingRequest(101,"Sayan","Kolkata","Mumbai",LocalDate.now(),5000,"acc1");
		var passenger=new Passenger();
		passenger.setPid(request.getPid());
		passenger.setpName(request.getpName());
		passenger.setTravelSource(request.getTravelSource());
		passenger.setDestination(request.getDestination());
		passenger.setTravelDate(request.getTravelDate());
		passenger.setFare(request.getFare());
		
		var payment= new Payment();
		payment.setPassengerId(request.getPid());
		payment.setAccNo(request.getAccNo());
		payment.setAmount(String.valueOf(request.getFare()));
		int paymentId=new Random().nextInt(1000);
		payment.setPaymentId(paymentId);

		lenient().when(passengerRepo.save(passenger)).thenReturn(passenger);
		lenient().when(paymentRepo.save(payment)).thenReturn(payment);
		var ack=new Acknowledgement(101,"Sayan","Kolkata - Mumbai",5000,"Success");
		assertEquals(ack.getStatus(), flightService.bookFlight(request).getStatus());

	}
	
	@Test
	void bookFlightFailed() {
		var request=new BookingRequest(101,"Sayan","Kolkata","Mumbai",LocalDate.now(),50000,"acc1");
		var passenger=new Passenger();
		passenger.setPid(request.getPid());
		passenger.setpName(request.getpName());
		passenger.setTravelSource(request.getTravelSource());
		passenger.setDestination(request.getDestination());
		passenger.setTravelDate(request.getTravelDate());
		passenger.setFare(request.getFare());
		
		var payment= new Payment();
		payment.setPassengerId(request.getPid());
		payment.setAccNo(request.getAccNo());
		payment.setAmount(String.valueOf(request.getFare()));
		int paymentId=new Random().nextInt(1000);
		payment.setPaymentId(paymentId);

		lenient().when(passengerRepo.save(passenger)).thenReturn(passenger);
		lenient().when(paymentRepo.save(payment)).thenReturn(payment);
		
		assertThrows(RuntimeException.class, ()->flightService.bookFlight(request),"Payment failed....Insuffcient balance!!");
	}
}
