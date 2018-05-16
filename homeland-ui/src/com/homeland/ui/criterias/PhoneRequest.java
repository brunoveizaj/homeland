package com.homeland.ui.criterias;

public class PhoneRequest {

	
	String nid;
	String name;
	String surname;
	String fatherName;
	String phoneNo;
	Integer firstResult;
	Integer maxResult;
	
	
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
		return "PhoneRequest [nid=" + nid + ", name=" + name + ", surname=" + surname + ", fatherName=" + fatherName
				+ ", phone_no=" + phoneNo + ", firstResult=" + firstResult + ", maxResult=" + maxResult + "]";
	}
	
	
	
	
	
	
}
