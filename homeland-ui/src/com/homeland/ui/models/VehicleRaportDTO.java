package com.homeland.ui.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleRaportDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	VehicleDTO vehicle;
	List<TicketDTO> tickets;
	List<BorderDTO> borders;
	List<VehicleDTO> vehicleHistory;
	
	
	public VehicleDTO getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}
	public List<TicketDTO> getTickets() {
		return tickets;
	}
	public void setTickets(List<TicketDTO> tickets) {
		this.tickets = tickets;
	}
	public List<BorderDTO> getBorders() {
		return borders;
	}
	public void setBorders(List<BorderDTO> borders) {
		this.borders = borders;
	}
	public List<VehicleDTO> getVehicleHistory() {
		return vehicleHistory;
	}
	public void setVehicleHistory(List<VehicleDTO> vehicleHistory) {
		this.vehicleHistory = vehicleHistory;
	}
	
	

}
