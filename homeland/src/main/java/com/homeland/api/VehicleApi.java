package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.VehicleDTO;
import com.homeland.exceptions.NoContentException;
import com.homeland.models.VehicleRaportDTO;
import com.homeland.requests.api.VehicleRequest;
import com.homeland.services.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApi {

	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value="/searchVehicle", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchVehicle(@RequestHeader HttpHeaders httpHeaders, VehicleRequest request)
	{
		
		//check Token validity 
		
		System.err.println("Headers: "+httpHeaders);
		System.err.println(request);
		
		List<VehicleDTO> list = vehicleService.searchVehicle(request);
		
		if(list == null || list.isEmpty())
		{
			throw new NoContentException("Nuk ka te dhena");
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/vehicleRaport/{plate}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> vehicleRaport(@RequestHeader HttpHeaders httpHeaders, @PathVariable String plate)
	{
		//check Token validity 
		System.err.println("Headers: "+httpHeaders);
		
		VehicleRaportDTO raport = vehicleService.getVehicleRaport(plate);
		
		return new ResponseEntity<>(raport,HttpStatus.OK);
		
	}
	
}
