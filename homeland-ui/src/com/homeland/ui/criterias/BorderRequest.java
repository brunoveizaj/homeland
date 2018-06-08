package com.homeland.ui.criterias;


public class BorderRequest {

	
	
	
	String event;
	String nid;
	String name;
	String surname;
	String fatherName;
	String docNo;
	String plate;
	String vin;
	String bcgId;
	String from;
	String to;
	Boolean foreign;
	Integer firstResult;
	Integer maxResult = 10000;
	
	
	
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
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}	
	public String getBcgId() {
		return bcgId;
	}
	public void setBcgId(String bcgId) {
		this.bcgId = bcgId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
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
		this.vin = vin;
	}
	public Boolean getForeign() {
		return foreign;
	}
	public void setForeign(Boolean foreign) {
		this.foreign = foreign;
	}
	
	
	@Override
	public String toString() {
		return "BorderRequest [" + (event != null ? "event=" + event + ", " : "")
				+ (nid != null ? "nid=" + nid + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (surname != null ? "surname=" + surname + ", " : "")
				+ (fatherName != null ? "fatherName=" + fatherName + ", " : "")
				+ (docNo != null ? "docNo=" + docNo + ", " : "") + (plate != null ? "plate=" + plate + ", " : "")
				+ (vin != null ? "vin=" + vin + ", " : "") + (bcgId != null ? "bcgId=" + bcgId + ", " : "")
				+ (from != null ? "from=" + from + ", " : "") + (to != null ? "to=" + to + ", " : "")
				+ (firstResult != null ? "firstResult=" + firstResult + ", " : "")
				+ (maxResult != null ? "maxResult=" + maxResult : "") + "]";
	}
	
	
	
}
