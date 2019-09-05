package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class AddressSQL {
	
	
	String nid;
	String municipality;
	String street;
	String fullName;
	String entrance;
	Integer unitId;
		
	
	Integer firstResult;
	Integer maxResult;
	
	
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		if(StringUtil.isValid(nid))
		this.nid = nid.replace(" ", "").toUpperCase();
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		if(StringUtil.isValid(municipality))
		this.municipality = municipality.trim().toUpperCase();
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		if(StringUtil.isValid(fullName))
		this.fullName = fullName.trim().toUpperCase();
	}
	public String getEntrance() {
		return entrance;
	}
	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
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
