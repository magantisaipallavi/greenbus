package com.svecw.greenbus.dto;
public class Bus {
	private String registrationNo;
	private int busTypeId;
	private int seatCount;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getBusTypeId() {
		return busTypeId;
	}

	public void setBusTypeId(int busTypeId) {
		this.busTypeId = busTypeId;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Bus(String registrationNo, int busTypeId, int seatCount) {
		
		this.registrationNo = registrationNo;
		this.busTypeId = busTypeId;
		this.seatCount = seatCount;
	}

	public Bus() {

	}

}
