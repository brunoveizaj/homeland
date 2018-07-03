package com.homeland.ui.models;

import java.io.Serializable;

public class Principal implements Serializable{


	private static final long serialVersionUID = 1L;

	String username;
	String password;
	String browser;
	String ip;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}


	
	
}
