package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class TicketSQL {

	String plate;
	String violatorNid;
	String status;;
	String vin;	
	Integer firstResult;
	Integer maxResult;
	String serialNo;
	
	public TicketSQL() {}
	
	public TicketSQL(String serialNo)
	{
		setSerialNo(serialNo);
		this.maxResult = 1;
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		if(StringUtil.isValid(plate))
		this.plate = plate.replace(" ", "").toUpperCase();
	}
	public String getViolatorNid() {
		return violatorNid;
	}
	public void setViolatorNid(String violatorNid) {
		if(StringUtil.isValid(violatorNid))
		this.violatorNid = violatorNid.replace(" ", "").toUpperCase();
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		if(StringUtil.isValid(vin))
		this.vin = vin.replace(" ", "").toUpperCase();
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
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	
	
	
	
}
