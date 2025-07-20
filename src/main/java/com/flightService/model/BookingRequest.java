package com.flightService.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingRequest {
	
	private int pid;
	private String pName;
	private String travelSource;
	private String destination;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate travelDate;
	private int fare;
	private String accNo;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getTravelSource() {
		return travelSource;
	}
	public void setTravelSource(String travelSource) {
		this.travelSource = travelSource;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public BookingRequest(int pid, String pName, String travelSource, String destination, LocalDate travelDate,
			int fare, String accNo) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.travelSource = travelSource;
		this.destination = destination;
		this.travelDate = travelDate;
		this.fare = fare;
		this.accNo = accNo;
	}
	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookingRequest [pid=" + pid + ", pName=" + pName + ", travelSource=" + travelSource + ", destination="
				+ destination + ", travelDate=" + travelDate + ", fare=" + fare + ", accNo=" + accNo + "]";
	}
	
}
