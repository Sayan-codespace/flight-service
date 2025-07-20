package com.flightService.service;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
	
	private static Map<String,Integer> banks=new HashMap<>();
	
	static {
		banks.put("acc1", 10000);
		banks.put("acc2", 5000);
		banks.put("acc3", 7000);
		banks.put("acc4", 8000);
	}
	
	public static boolean validatePayment(String accNo,int amount) {
		Integer balance=banks.get(accNo);
		System.out.println("balance: "+balance);
		if(balance>=Integer.valueOf(amount)) {
			return true;
		}
		return false;
	}
	
	

}
