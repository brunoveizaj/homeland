package com.homeland.requests.repository;

import java.util.Date;

import com.homeland.utils.StringUtil;

public class BorderSQL {

	String event;
	String nid;
	String name;
	String surname;
	String fatherName;
	String docNo;
	String plate;
	String vin;
	String bcgId;
	Date from;
	Date to;
	Integer firstResult;
	Integer maxResult;
	
	
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		if(StringUtil.isValid(nid))
		this.nid = nid.replace(" ", "").toUpperCase();
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
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		if(StringUtil.isValid(docNo))
		this.docNo = docNo.replace(" ", "").toUpperCase();
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		if(StringUtil.isValid(plate))
		this.plate = plate.replace(" ", "").toUpperCase();
	}	
	public String getBcgId() {
		return bcgId;
	}
	public void setBcgId(String bcgId) {
		this.bcgId = bcgId;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public Integer getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		if(StringUtil.isValid(vin))
	    this.vin = vin.replace(" ", "").toUpperCase();
	}
	
	
	
	
	
	
	
	
	
}
