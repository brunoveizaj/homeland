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

import com.homeland.dto.PhoneDTO;
import com.homeland.requests.api.PhoneRequest;
import com.homeland.services.PhoneService;
import com.homeland.services.TokenService;

@RestController
@RequestMapping("/api/phone")
public class PhoneApi {

	@Autowired
	PhoneService phoneService;
	@Autowired 
	TokenService tokenService;
	
	
	@RequestMapping(value="/searchPhone", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchPhone(@RequestHeader(value="Authorization") String token,@RequestBody PhoneRequest req)
	{
		
		Integer userId = tokenService.getUserIdFromToken(token);
		
		List<PhoneDTO> list = phoneService.searchPhone(req,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
}
