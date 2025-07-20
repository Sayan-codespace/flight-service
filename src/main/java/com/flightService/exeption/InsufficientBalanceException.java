package com.flightService.exeption;

public class InsufficientBalanceException extends RuntimeException{
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}

}
