package com.svecw.greenbus.exception;

public class GreenBusException extends Exception{

	
	private String message;
	
	public GreenBusException(String message){
		this.message = message;
	}

	@Override
	public String toString() {
		return "GreenBusException [message=" + message + "]";
	}
	
}
