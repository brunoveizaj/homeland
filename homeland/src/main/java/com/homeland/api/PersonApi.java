package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.PersonDTO;
import com.homeland.exceptions.NoContentException;
import com.homeland.models.PersonRaportDTO;
import com.homeland.requests.api.PersonRequest;
import com.homeland.services.PersonService;


@RestController
@RequestMapping("/api/person")
public class PersonApi {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value="/searchPerson", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchPerson(@RequestHeader HttpHeaders httpHeaders,
			//(value="Authorization",required=false) String token, 
			PersonRequest request)
	{
		
		//check Token validity 
		
		System.err.println("Headers: "+httpHeaders);
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
	public ResponseEntity<?> personRaport(@RequestHeader HttpHeaders httpHeaders, @PathVariable String nid)
	{
		//check Token validity 
		System.err.println("Headers: "+httpHeaders);
		System.err.println("REQUEST nid="+nid);
		
		PersonRaportDTO raport = personService.getPersonRaport(nid);
		
		return new ResponseEntity<>(raport,HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public ResponseEntity<?>sendData(@RequestHeader HttpHeaders httpHeaders, @RequestBody String payload)
	{
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
