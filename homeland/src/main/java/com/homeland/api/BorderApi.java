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
	public ResponseEntity<?> searchEntryExit(@RequestHeader(value="Authorization") String token, BorderRequest request)
	{
		
		Integer userId = tokenService.getUserIdFromToken(token);
				
		List<BorderDTO> list = borderService.searchEntryExit(request, userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
	
}
