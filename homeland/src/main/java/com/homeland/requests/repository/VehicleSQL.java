package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class VehicleSQL {

	
	String plate;
	String vin;
	String owner;
	String producer;
	String model;
	String color;
	Integer firstResult;
	Integer maxResult;
	
    public VehicleSQL() {}
	
	public VehicleSQL(String plate) {
		
		setPlate(plate);
		this.maxResult = 1;
		
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		if(StringUtil.isValid(plate))
		this.plate = plate.replace(" ", "").toUpperCase();
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		if(StringUtil.isValid(vin))
		this.vin = vin.replace(" ", "").toUpperCase();
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String name,String father,String surname) {
		String o ="";
		if(StringUtil.isValid(name))
		{
			o+=StringUtil.formatSQ(name)+"%";
		}
		if(StringUtil.isValid(father))
		{
			o+="%"+StringUtil.formatSQ(father)+"%";
		}
		if(StringUtil.isValid(surname))
		{
			o+="%"+StringUtil.formatSQ(surname);
		}
		this.owner = o;
		
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = StringUtil.formatSQ(producer);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = StringUtil.formatSQ(model);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = StringUtil.formatSQ(color);
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
