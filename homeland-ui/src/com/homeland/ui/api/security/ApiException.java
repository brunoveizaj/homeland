package com.homeland.ui.api.security;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	int severity;
	String message;
	
	
	public ApiException() {}
	
	
	public ApiException(String message, int severity) {
		super();
		this.severity = severity;
		this.message = message;
	}


	public int getSeverity() {
		return severity;
	}


	public void setSeverity(int severity) {
		this.severity = severity;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	

}