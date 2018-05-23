package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.VehicleRequest;
import com.homeland.ui.models.Param;
import com.homeland.ui.models.VehicleDTO;
import com.homeland.ui.services.VehicleService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class VehicleSxBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	
	
	VehicleRequest request;
	
	List<VehicleDTO> vehicles;
	VehicleDTO vehicle;
	
	

	public NavigationBean getNav() {
		return nav;
	}


	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}


	public VehicleRequest getRequest() {
		return request;
	}


	public void setRequest(VehicleRequest request) {
		this.request = request;
	}


	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}


	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}


	public VehicleDTO getVehicle() {
		return vehicle;
	}


	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	
	

	@PostConstruct
	public void load()
	{
		init();
	}
	
	
	public void init()
	{
		this.request = new VehicleRequest();
		this.vehicle = null;
		this.vehicles = null;
	}
	
	public void onVehicleSelect()
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("plate",vehicle.getPlate()));
		nav.navigate("vehicle_view",params);
	}
	
	public void search()
	{
		try {
			this.vehicles = new VehicleService().searchVehicle(request);
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	public void clear()
	{
		init();
	}
	

}
