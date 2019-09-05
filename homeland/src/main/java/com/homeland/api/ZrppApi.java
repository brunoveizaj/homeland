package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.PropertyCartelDTO;
import com.homeland.dto.PropertyDTO;
import com.homeland.dto.PropertyMapDTO;
import com.homeland.requests.api.ZrppRequest;
import com.homeland.services.TokenService;
import com.homeland.services.ZrppService;

@RestController
@RequestMapping("/api/zrpp")
public class ZrppApi {

	@Autowired 
	TokenService tokenService;
	@Autowired 
	ZrppService zrppService;
	
	
	
	@RequestMapping(value="/searchProperty", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchProperty(@RequestHeader(value="Authorization") String token, @RequestBody ZrppRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
						
		List<PropertyDTO> list = zrppService.searchProperty(request, userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/searchPropertyByOwner", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchPropertyByOwner(@RequestHeader(value="Authorization") String token, @RequestBody ZrppRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
						
		List<PropertyDTO> list = zrppService.searchPropertyByOwner(request, userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getProperty", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> getProperty(@RequestHeader(value="Authorization") String token, @RequestBody ZrppRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
						
		PropertyDTO dto = zrppService.getProperty(request, userId);
			
				
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getPropertyCartel", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> getPropertyCartel(@RequestHeader(value="Authorization") String token, @RequestBody ZrppRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
						
		PropertyCartelDTO dto = zrppService.getPropertyCartel(request, userId);
			
				
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getPropertyMap", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> getPropertyMap(@RequestHeader(value="Authorization") String token, @RequestBody ZrppRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
						
		PropertyMapDTO dto = zrppService.getPropertyMap(request, userId);
			
				
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
}
