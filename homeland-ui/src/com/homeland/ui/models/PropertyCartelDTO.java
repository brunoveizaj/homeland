package com.homeland.ui.models;

import java.io.Serializable;

public class PropertyCartelDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private String rezult;
	private String message;
	private String data;
	
	
	public String getRezult() {
		return rezult;
	}
	public void setRezult(String rezult) {
		this.rezult = rezult;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	

}
