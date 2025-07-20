package com.flightService.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	
	@Id
	private int pid;
	private String pName;
	private String travelSource;
	private String destination;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate travelDate;
	private int fare;
	
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
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(int pid, String pName, String travelSource, String destination, LocalDate travelDate, int fare) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.travelSource = travelSource;
		this.destination = destination;
		this.travelDate = travelDate;
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Passenger [pid=" + pid + ", pName=" + pName + ", travelSource=" + travelSource + ", destination=" + destination
				+ ", travelDate=" + travelDate + ", fare=" + fare + "]";
	}
	
}
