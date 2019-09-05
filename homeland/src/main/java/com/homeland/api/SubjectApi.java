package com.homeland.api;

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

import com.homeland.dto.SubjectDTO;
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
	public ResponseEntity<?> getSubjectByNipt(@RequestHeader(value="Authorization") String token, @PathVariable String nipt)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
				
		SubjectDTO subject = subjectService.getSubjectByNipt(nipt,userId);
		
		if(subject == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(subject,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/searchSubject", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchSubject(@RequestHeader(value="Authorization") String token,@RequestBody SubjectRequest req)
	{
				
		Integer userId = tokenService.getUserIdFromToken(token);
				
		List<SubjectDTO> list = subjectService.searchSubject(req,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
}
