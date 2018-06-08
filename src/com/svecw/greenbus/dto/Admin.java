package com.svecw.greenbus.dto;

public class Admin {
	private String name;
	private String password;
	private String emailId;
	private String phoneNumber;
	public Admin(String name, String password, String emailId, String phoneNumber) {
		super();
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	public Admin() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
}
