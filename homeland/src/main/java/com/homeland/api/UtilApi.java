package com.homeland.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.services.PhoneService;

@RestController
@RequestMapping("/api/utils")
public class UtilApi {
	
	
	@Autowired
	PhoneService phoneService;
	
	@RequestMapping(value="/updateEagle", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> updateEagle()
	{
				
		phoneService.startUpdateEagle();
		
		return new ResponseEntity<>("Filloi",HttpStatus.OK);
		
	}

}
