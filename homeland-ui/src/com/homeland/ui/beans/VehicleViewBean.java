package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.models.BorderDTO;
import com.homeland.ui.models.TicketDTO;
import com.homeland.ui.models.VehicleDTO;
import com.homeland.ui.models.VehicleRaportDTO;
import com.homeland.ui.services.VehicleService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class VehicleViewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	
	
	VehicleDTO vehicle;
	List<TicketDTO> tickets;
	List<BorderDTO> borders;
	List<VehicleDTO> vehicleHistory;
	
	

	
	public NavigationBean getNav() {
		return nav;
	}


	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}


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

	
	

	public void init()
	{
		String plate = nav.getParam("plate");
		loadVehicleRaport(plate);
	}
	
	
	public void loadVehicleRaport(String plate)
	{
		try {
			VehicleRaportDTO raport = new VehicleService().vehicleRaport(plate);
			if(raport != null) {
				this.vehicle = raport.getVehicle();
				this.tickets = raport.getTickets();
				this.borders = raport.getBorders();
				this.vehicleHistory = raport.getVehicleHistory();
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	

}
