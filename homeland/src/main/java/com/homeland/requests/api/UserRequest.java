package com.homeland.requests.api;

public class UserRequest {

	String username;
	String role;
	Boolean status;	
	Integer firstResult;
	Integer maxResult;
	
	public UserRequest() {}
	
	public UserRequest(String uname)
	{
		this.username = uname;
		this.maxResult = 1;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public Integer getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", role=" + role + ", status=" + status + ", firstResult="
				+ firstResult + ", maxResult=" + maxResult + "]";
	}
	
	
	
	
	
	
}
