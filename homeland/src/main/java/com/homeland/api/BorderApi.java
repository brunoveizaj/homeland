package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.BorderDTO;
import com.homeland.exceptions.NoContentException;
import com.homeland.requests.api.BorderRequest;
import com.homeland.services.BorderService;
import com.homeland.services.TokenService;

@RestController
@RequestMapping("/api/border")
public class BorderApi {

	
	@Autowired
	BorderService borderService;
	@Autowired 
	TokenService tokenService;
	
	
	@RequestMapping(value="/searchEntryExit", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchEntryExit(@RequestHeader(value="Authorization",required=false) String token, BorderRequest request)
	{
		
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(request);
		
		List<BorderDTO> list = borderService.searchEntryExit(request);
		
		if(list == null || list.isEmpty())
		{
			throw new NoContentException("Nuk ka te dhena");
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
	
}
