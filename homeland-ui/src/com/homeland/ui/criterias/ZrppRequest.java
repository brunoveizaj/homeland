package com.homeland.ui.criterias;

import java.io.Serializable;

public class ZrppRequest implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	String zk;
	String vol;
	String page;
	String propertyNo;
	String region;
	String city;
	String street;
	
	String name;
	String surname;
	
	String propertyId;
	
	
	public ZrppRequest() {}

	public ZrppRequest(String propertyId) {
		super();
		this.propertyId = propertyId;
	}
	
	public ZrppRequest(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public ZrppRequest(String zk, String vol, String page) {
		super();
		this.zk = zk;
		this.vol = vol;
		this.page = page;
	}
	
	public ZrppRequest(String zk, String vol, String page, String propertyNo, String region, String city,
			String street) {
		super();
		this.zk = zk;
		this.vol = vol;
		this.page = page;
		this.propertyNo = propertyNo;
		this.region = region;
		this.city = city;
		this.street = street;
	}




	

	public String getZk() {
		return zk;
	}


	public void setZk(String zk) {
		this.zk = zk;
	}


	public String getVol() {
		return vol;
	}


	public void setVol(String vol) {
		this.vol = vol;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public String getPropertyNo() {
		return propertyNo;
	}


	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
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


	public String getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	
	
	

}
