package com.svecw.greenbus.dto;

import java.util.Date;

public class Ticket {
	private int ticketId;
	private String registrationNo;
	private int routeId;
	private Date journeyDate;
	private int userId;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String i) {
		this.registrationNo = i;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Ticket(int ticketId, String registrationNo, int routeId, Date journeyDate, int userId) {
		super();
		this.ticketId = ticketId;
		this.registrationNo = registrationNo;
		this.routeId = routeId;
		this.journeyDate = journeyDate;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", registrationNo=" + registrationNo + ", routeId=" + routeId
				+ ", journeyDate=" + journeyDate + ", userId=" + userId + "]";
	}
	public Ticket() {
		super();
	}
	

}
