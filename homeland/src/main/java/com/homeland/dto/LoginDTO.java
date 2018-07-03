package com.homeland.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.homeland.constants.IDate;

public class LoginDTO {

	
	private int id;
	private Integer userId;
	private String username;
	private String ip;
	private String browser;
	private String token;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = IDate.TIMESTAMP_FORMAT)
	private Date loginTime;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = IDate.TIMESTAMP_FORMAT)
	private Date logoutTime;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	
	
	
	
	
	
	
}
