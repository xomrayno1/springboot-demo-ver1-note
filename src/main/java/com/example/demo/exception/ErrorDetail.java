package com.example.demo.exception;

import java.util.Date;

public class ErrorDetail {
	private String message;
	private String description;
	private Date date;
	
	
	
	
	public ErrorDetail() {
		super();
	}
	public ErrorDetail(String message, String description, Date date) {
		super();
		this.message = message;
		this.description = description;
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	 
	

}
