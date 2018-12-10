package com.homeland.zrpp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShkarkoKarteleModel {
	
	
	@JsonProperty("rezult")
	String result;
	@JsonProperty("stringu_pergjigjes")
	String message;
	@JsonProperty("permbajtja_dokumentit")
	String content;
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ShkarkoKarteleModel [" + (result != null ? "result=" + result + ", " : "")
				+ (message != null ? "message=" + message + ", " : "") 
				+ "]";
	}
	
	
	
	

}
