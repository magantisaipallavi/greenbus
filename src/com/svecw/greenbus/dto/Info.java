package com.svecw.greenbus.dto;

public class Info {
	private String registrationNo;
	int seatCount;
	private String busTypeName;
	int availableSeats;

	public String getBusTypeName() {
		return busTypeName;
	}

	public void setBusTypeName(String busTypeName) {
		this.busTypeName = busTypeName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Info() {

	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "Info [registrationNo=" + registrationNo + ", seatCount=" + seatCount + ", busTypeName=" + busTypeName
				+ "]";
	}

}
