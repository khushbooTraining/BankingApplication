package com.banking.banking_app.exception;

import java.time.LocalDateTime;

public class ErrorMessage {
	
	private LocalDateTime time;
	private String message;
	public ErrorMessage(LocalDateTime time, String message) {
		super();
		this.time = time;
		this.message = message;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
