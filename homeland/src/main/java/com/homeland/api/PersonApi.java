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

import com.homeland.dto.PersonDTO;
import com.homeland.exceptions.NoContentException;
import com.homeland.models.PersonRaportDTO;
import com.homeland.requests.api.PersonRequest;
import com.homeland.services.PersonService;
import com.homeland.services.TokenService;


@RestController
@RequestMapping("/api/person")
public class PersonApi {

	@Autowired
	PersonService personService;
	@Autowired 
	TokenService tokenService;
	
	@RequestMapping(value="/searchPerson", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchPerson(@RequestHeader(value="Authorization",required=false) String token, PersonRequest request)
	{
		System.err.println("AUTH TOKEN: "+token);
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(request);
		
		List<PersonDTO> list = personService.searchPerson(request);
		
		if(list == null || list.isEmpty())
		{
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			throw new NoContentException("Nuk ka te dhena");
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/personRaport/{nid}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> personRaport(@RequestHeader(value="Authorization",required=false) String token, @PathVariable String nid)//@RequestHeader HttpHeaders httpHeaders
	{
		System.err.println("AUTH TOKEN: "+token);
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println("REQUEST nid="+nid);
		
		PersonRaportDTO raport = personService.getPersonRaport(nid);
		
		return new ResponseEntity<>(raport,HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
