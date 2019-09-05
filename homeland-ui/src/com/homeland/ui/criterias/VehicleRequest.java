package com.homeland.ui.criterias;

import java.io.Serializable;

public class VehicleRequest implements Serializable{


	private static final long serialVersionUID = 1L;

	
	String plate;
	String vin;
	String name;
	String fatherName;
	String surname;
	String producer;
	String model;
	String color;
	Integer firstResult;
	Integer maxResult = 5000;
	
	public VehicleRequest() {}
	
	public VehicleRequest(String plate) {
		
		setPlate(plate);
		this.maxResult = 1;
		
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
		return "VehicleRequest [plate=" + plate + ", vin=" + vin + ", name=" + name + ", fatherName=" + fatherName
				+ ", surname=" + surname + ", producer=" + producer + ", model=" + model + ", color=" + color
				+ ", firstResult=" + firstResult + ", maxResult=" + maxResult + "]";
	}
	
	
	
	
	
}
