package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class PhoneSQL {

	
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
		this.nid = StringUtil.formatSQ(nid);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = StringUtil.formatSQ(name);
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = StringUtil.formatSQ(surname);
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = StringUtil.formatSQ(fatherName);
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		if(StringUtil.isValid(phoneNo))
		{
		  this.phoneNo = phoneNo.replace(" ", "");
		}
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
	
	
	
	
}
