package com.flightService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	@Id
	private int paymentId;
	private String accNo;
	private String amount;
	private int passengerId;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentId, String accNo, String amount, int passengerId) {
		super();
		this.paymentId = paymentId;
		this.accNo = accNo;
		this.amount = amount;
		this.passengerId = passengerId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", accNo=" + accNo + ", amount=" + amount + ", passengerId="
				+ passengerId + "]";
	}

}
