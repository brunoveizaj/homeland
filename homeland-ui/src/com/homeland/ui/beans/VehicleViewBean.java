package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.homeland.ui.models.BorderDTO;
import com.homeland.ui.models.TicketDTO;
import com.homeland.ui.models.VehicleDTO;
import com.homeland.ui.models.VehicleRaportDTO;
import com.homeland.ui.services.VehicleService;

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
	
	
	
	public void init()
	{
		if(FacesContext.getCurrentInstance().isPostback())
		{
			System.out.println("POSTBACKKKKK");
		}
		else
		{
			System.out.println("NOOOOOOO    POSTBACKKKKK");
		}
		
		String plate = nav.getParam("plate");
		System.out.println("PLATE nga params e nav : PLATE="+plate);
		
		loadVehicleRaport(plate);
		
	}
	
	
	public void loadVehicleRaport(String plate)
	{
		VehicleRaportDTO raport = new VehicleService().vehicleRaport(plate);
		this.vehicle = raport.getVehicle();
		this.tickets = raport.getTickets();
		this.borders = raport.getBorders();
		this.vehicleHistory = raport.getVehicleHistory();
	}
	

}
