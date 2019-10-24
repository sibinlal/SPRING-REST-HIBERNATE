package com.luv2code.springdemo.restException;

public class CustomerErrorResponse {
	
	private int statusCode;
	private String messge;
	private long timeStamp;
	
	public CustomerErrorResponse() {
		
	}
	
	public CustomerErrorResponse(int statusCode, String messge, long timeStamp) {
		this.statusCode = statusCode;
		this.messge = messge;
		this.timeStamp = timeStamp;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessge() {
		return messge;
	}
	public void setMessge(String messge) {
		this.messge = messge;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
