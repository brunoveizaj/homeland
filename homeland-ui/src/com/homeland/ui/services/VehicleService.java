package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.VehicleClient;
import com.homeland.ui.criterias.TicketRequest;
import com.homeland.ui.criterias.VehicleRequest;
import com.homeland.ui.models.TicketDTO;
import com.homeland.ui.models.VehicleDTO;
import com.homeland.ui.models.VehicleRaportDTO;

public class VehicleService {

	
	public List<VehicleDTO> searchVehicle(VehicleRequest req)
	{
		return new VehicleClient().searchVehicle(req);
	}
	
	public VehicleRaportDTO vehicleRaport(String plate)
	{
		return new VehicleClient().vehicleRaport(plate);
	}
	
	public List<TicketDTO> searchTicket(TicketRequest req)
	{
		return new VehicleClient().searchTicket(req);
	}
	
}
