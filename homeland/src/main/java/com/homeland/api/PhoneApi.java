package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.PhoneDTO;
import com.homeland.exceptions.NoContentException;
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
	
	
	@RequestMapping(value="/searchPhone", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchPhone(@RequestHeader(value="Authorization",required=false) String token, PhoneRequest req)
	{
		
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(req);
		
		List<PhoneDTO> list = phoneService.searchPhone(req);
		
		if(list == null || list.isEmpty())
		{
			throw new NoContentException("Nuk ka te dhena");
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
}
