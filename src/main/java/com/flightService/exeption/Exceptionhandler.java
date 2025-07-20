package com.flightService.exeption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.flightService.model.BookingErrorStatus;

@ControllerAdvice
@RestController
public class Exceptionhandler {
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public BookingErrorStatus insufficientbalance(InsufficientBalanceException e) {
		BookingErrorStatus status=new BookingErrorStatus();
		status.setError("InsufficientBalanceException");
		status.setStatus(500);
		status.setMessage(e.getMessage());
		return status;		
	}

}
