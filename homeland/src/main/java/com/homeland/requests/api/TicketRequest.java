package com.homeland.requests.api;

public class TicketRequest {

	
	String plate;
	String violatorNid;
	String status;;
	String vin;	
	Integer firstResult;
	Integer maxResult;
	String serialNo;
	
	public TicketRequest() {}
	
	public TicketRequest(String serialNo)
	{
		this.serialNo = serialNo;
		this.maxResult = 1;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getViolatorNid() {
		return violatorNid;
	}

	public void setViolatorNid(String violatorNid) {
		this.violatorNid = violatorNid;
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
		this.vin = vin;
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

	@Override
	public String toString() {
		return "TicketRequest [plate=" + plate + ", violatorNid=" + violatorNid + ", status=" + status + ", vin=" + vin
				+ ", firstResult=" + firstResult + ", maxResult=" + maxResult + ", serialNo=" + serialNo + "]";
	}
	
	
	
	
	
	
}
