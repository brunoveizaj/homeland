package com.homeland.api;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.AddressDTO;
import com.homeland.dto.BuildingMAP;
import com.homeland.requests.api.AddressRequest;
import com.homeland.services.AddressService;
import com.homeland.services.TokenService;

@RestController
@RequestMapping("/api/address")
public class AddressApi {

	
	@Autowired 
	TokenService tokenService;
	@Autowired 
	AddressService addressService;
	
	
	
	@RequestMapping(value="/getByNid/{nid}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getAddressesByNid(@RequestHeader(value="Authorization",required=false) String token, @PathVariable String nid)
	{
						
		List<AddressDTO> list = addressService.getAddressByNid(nid);
				
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getByBuildingId/{bid}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getAddressesByBuildingId(@RequestHeader(value="Authorization",required=false) String token, @PathVariable BigInteger bid)
	{
						
		List<AddressDTO> list = addressService.getAddressByBuildingId(bid);
				
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/searchAddress", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchAddresses(@RequestHeader(value="Authorization") String token, @RequestBody AddressRequest request)
	{
		
		tokenService.getUserIdFromToken(token);
				
		List<AddressDTO> list = addressService.searchAddress(request);
		
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/getBuildingMapById/{buildingId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getBuildingMapById(@RequestHeader(value="Authorization",required=false) String token, @PathVariable BigInteger buildingId)
	{
						
		BuildingMAP map = addressService.getBuildingMapById(buildingId);
				
		if(map == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(map,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getBuildingsMapByUnitId/{unitId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getBuildingsMapByUnitId(@RequestHeader(value="Authorization",required=false) String token, @PathVariable Integer unitId)
	{
						
		List<BuildingMAP> maps = addressService.getBuildingsMapByUnitId(unitId);
				
		if(maps == null || maps.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(maps,HttpStatus.OK);
		
	}
	
	
	
	
}
