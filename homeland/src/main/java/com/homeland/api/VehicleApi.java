package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.TicketDTO;
import com.homeland.dto.VehicleDTO;
import com.homeland.models.VehicleRaportDTO;
import com.homeland.requests.api.TicketRequest;
import com.homeland.requests.api.VehicleRequest;
import com.homeland.services.TokenService;
import com.homeland.services.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApi {

	
	@Autowired
	VehicleService vehicleService;
	@Autowired 
	TokenService tokenService;
	
	@RequestMapping(value="/searchVehicle", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchVehicle(@RequestHeader(value="Authorization") String token, VehicleRequest request)
	{
		
		Integer userId = tokenService.getUserIdFromToken(token);
				
		List<VehicleDTO> list = vehicleService.searchVehicle(request,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/searchTicket", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchTicket(@RequestHeader(value="Authorization",required=false) String token, TicketRequest req)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
						
		List<TicketDTO> list = vehicleService.searchTicket(req,userId);
		
		if(list == null || list.isEmpty()) 
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/vehicleRaport/{plate}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> vehicleRaport(@RequestHeader(value="Authorization",required=false) String token, @PathVariable String plate)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
				
		VehicleRaportDTO raport = vehicleService.getVehicleRaport(plate,userId);
		
		return new ResponseEntity<>(raport,HttpStatus.OK);
		
	}
	
}
