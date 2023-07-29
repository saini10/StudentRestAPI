package com.saini.StudentRestAPI.Exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private String message;
	private Long timestamp;
	private HttpStatus status;
	
	
	public ErrorResponse() {
		
	}
	
	public ErrorResponse(String message, Long timestamp, HttpStatus status) {
		
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
		
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
	
	
}
