package com.flightService.model;

public class Acknowledgement {
	
	private int pid;
	private String pName;
	private String travel;
	private int totalFare;
	private String status;
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
	public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Acknowledgement(int pid, String pName, String travel, int totalFare, String status) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.travel = travel;
		this.totalFare = totalFare;
		this.status = status;
	}
	public Acknowledgement() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Acknowledgement [pid=" + pid + ", pName=" + pName + ", travel=" + travel + ", totalFare=" + totalFare
				+ ", status=" + status + "]";
	}
	
	

}
