package com.homeland.api;

import java.util.Calendar;
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

import com.homeland.dto.PersonDTO;
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
	
	@RequestMapping(value="/searchPerson", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchPerson(@RequestHeader(value="Authorization") String token,@RequestBody PersonRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
						
		List<PersonDTO> list = personService.searchPerson(request,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/personRaport/{nid}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> personRaport(@RequestHeader(value="Authorization") String token, @PathVariable String nid)//@RequestHeader HttpHeaders httpHeaders
	{
		Integer userId = tokenService.getUserIdFromToken(token);
		
		System.out.println(Calendar.getInstance().getTime()+" ["+userId+"] "+nid);
				
		PersonRaportDTO raport = personService.getPersonRaport(nid, userId);
		
		return new ResponseEntity<>(raport,HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
