package com.flightService.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.flightService.exeption.InsufficientBalanceException;
import com.flightService.model.Acknowledgement;
import com.flightService.model.BookingRequest;
import com.flightService.model.Passenger;
import com.flightService.model.Payment;
import com.flightService.repo.PassengerRepo;
import com.flightService.repo.PaymentRepo;


@Service
public class FlightBookingService {
	
	@Autowired
	private PassengerRepo passengerRepo;
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Acknowledgement bookFlight(BookingRequest request) {
		
		var acknowledgement=new Acknowledgement();
		
		var passenger=new Passenger();
		passenger.setPid(request.getPid());
		passenger.setpName(request.getpName());
		passenger.setTravelSource(request.getTravelSource());
		passenger.setDestination(request.getDestination());
		passenger.setTravelDate(request.getTravelDate());
		passenger.setFare(request.getFare());
		
		passengerRepo.save(passenger);
		
		var payment= new Payment();
		payment.setPassengerId(request.getPid());
		payment.setAccNo(request.getAccNo());
		payment.setAmount(String.valueOf(request.getFare()));
		int paymentId=new Random().nextInt(1000);
		payment.setPaymentId(paymentId);
		boolean val=PaymentUtils.validatePayment(payment.getAccNo(), Integer.valueOf(payment.getAmount()));
		if(val) {
			paymentRepo.save(payment);
			acknowledgement.setPid(request.getPid());
			acknowledgement.setpName(request.getpName());
			acknowledgement.setStatus("Success");
			acknowledgement.setTotalFare(request.getFare());
			acknowledgement.setTravel(request.getTravelSource()+" - "+request.getDestination());
		}else {
			throw new InsufficientBalanceException("Payment failed....Insuffcient balance!!");
		}
		
		return acknowledgement;
		
	}
	
	public Passenger getPassengerInfo(String id) {
		Optional<Passenger> passenger=passengerRepo.findById(Integer.valueOf(id));
		if(passenger.isPresent()) {
			return passenger.get();
		}else {
			return null;
		}
	}

}
