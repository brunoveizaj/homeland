package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.PersonDTO;
import com.homeland.requests.api.PersonRequest;
import com.homeland.services.PersonService;


@RestController
public class PersonApi {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value="/searchPerson", method=RequestMethod.GET)
	public ResponseEntity<?> searchPerson(@RequestHeader(value="Authorization") String token, PersonRequest request)
	{
		
		//check Token validity 
		
		List<PersonDTO> list = personService.searchPerson(request);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public ResponseEntity<?>sendData(@RequestHeader HttpHeaders httpHeaders, @RequestBody String payload)
	{
		
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
