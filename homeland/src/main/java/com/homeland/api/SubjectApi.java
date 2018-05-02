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

import com.homeland.dto.SubjectDTO;
import com.homeland.exceptions.NoContentException;
import com.homeland.requests.api.SubjectRequest;
import com.homeland.services.SubjectService;
import com.homeland.services.TokenService;

@RestController
@RequestMapping("/api/subject")
public class SubjectApi {

	
	@Autowired
	SubjectService subjectService;
	@Autowired 
	TokenService tokenService;
	
	
	
	@RequestMapping(value="/{nipt}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSubjectByNipt(@RequestHeader(value="Authorization",required=false) String token, @PathVariable String nipt)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(nipt);
		
		SubjectDTO subject = subjectService.getSubjectByNipt(nipt);
		
		if(subject == null)
		{
			throw new NoContentException("Nuk ka te dhena");
		}
		
		return new ResponseEntity<>(subject,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/searchSubject", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchSubject(@RequestHeader(value="Authorization",required=false) String token, SubjectRequest req)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(req);
		
		List<SubjectDTO> list = subjectService.searchSubject(req);
		
		if(list == null || list.isEmpty())
		{
			throw new NoContentException("Nuk ka te dhena");
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
}
