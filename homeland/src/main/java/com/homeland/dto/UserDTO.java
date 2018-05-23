package com.homeland.dto;



public class UserDTO {

	
	private int id;
    private String username;
    private String secret;
    private Integer status;
    private String role;
    private String createdTime;
    private Integer createdUserId;
    private String modifyTime;
    private Integer modifyUserId;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getModifyUserId() {
		return modifyUserId;
	}
	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
    
    


    
	
	
}
