package com.homeland.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.BorderDTO;
import com.homeland.dto.TicketDTO;
import com.homeland.dto.VehicleDTO;
import com.homeland.entities.Ticket;
import com.homeland.entities.Vehicle;
import com.homeland.models.VehicleRaportDTO;
import com.homeland.repositories.TicketRepository;
import com.homeland.repositories.VehicleRepository;
import com.homeland.requests.api.BorderRequest;
import com.homeland.requests.api.TicketRequest;
import com.homeland.requests.api.VehicleRequest;
import com.homeland.requests.repository.TicketSQL;
import com.homeland.requests.repository.VehicleSQL;

@Service
public class VehicleService {

	
	@Autowired
	VehicleRepository vehicleDAO;
	@Autowired
	TicketRepository ticketDAO;
	
	@Autowired
	BorderService borderService;
	
	
	public List<VehicleDTO> searchVehicle(VehicleRequest req)
	{
		VehicleSQL criterias = new RequestAssembler().apiToSql(req);
		List<Vehicle> vehicles = vehicleDAO.searchVehicle(criterias);
		return new Assembler().vehicleListToDto(vehicles);
	}
	
	public VehicleDTO searchVehicleByPlate(VehicleRequest req)
	{
		req = new VehicleRequest(req.getPlate());
		VehicleSQL criterias = new RequestAssembler().apiToSql(req);
		List<Vehicle> vehicles = vehicleDAO.searchVehicle(criterias);
		if(vehicles != null && !vehicles.isEmpty())
		{
		  return new Assembler().vehicleListToDto(vehicles).get(0);
		}
		
		return null;
	}
	
	public List<TicketDTO> searchTicket(TicketRequest req)
	{
		TicketSQL criterias = new RequestAssembler().apiToSql(req);
		List<Ticket> tickets = ticketDAO.searchTicket(criterias);
		return new Assembler().ticketListToDto(tickets);
	}
	
	@Async
	public CompletableFuture<List<VehicleDTO>> searchAsyncVehicle(VehicleRequest req)
	{
		return CompletableFuture.completedFuture(searchVehicle(req));
	}
	
	@Async
	public CompletableFuture<VehicleDTO> searchAsyncVehicleByPlate(VehicleRequest req)
	{
		return CompletableFuture.completedFuture(searchVehicleByPlate(req));
	}
	
	@Async
	public CompletableFuture<List<TicketDTO>> searchAsyncTicket(TicketRequest req)
	{
		return CompletableFuture.completedFuture(searchTicket(req));
	}
	
	
	public VehicleRaportDTO getVehicleRaport(String plate)
	{
		VehicleRaportDTO raport = new VehicleRaportDTO();
		
		VehicleDTO vehicle = searchVehicleByPlate(new VehicleRequest(plate));
		
		if(vehicle == null) return null;
		
		VehicleRequest vr = new VehicleRequest();
		vr.setVin(vehicle.getVin());
		CompletableFuture<List<VehicleDTO>> history = searchAsyncVehicle(vr);
		
		TicketRequest tr = new TicketRequest();
		tr.setVin(vehicle.getVin());
		CompletableFuture<List<TicketDTO>> tickets = searchAsyncTicket(tr);
		
		BorderRequest br = new BorderRequest();
		br.setVin(vehicle.getVin());
		CompletableFuture<List<BorderDTO>> borders = borderService.searchAsyncEntryExit(br);
		
		CompletableFuture.allOf(history,tickets,borders).join();
		
		raport.setVehicle(vehicle);
		try {
			raport.setTickets(tickets.get());
			raport.setVehicleHistory(history.get());
			raport.setBorders(borders.get());
		} catch (InterruptedException | ExecutionException e) {
			System.err.println("INTERRUPTION EXCEPTION: VEHICLE RAPORT");
			e.printStackTrace();
		}
		
		return raport;
		
	}
	
	
	
	
}
