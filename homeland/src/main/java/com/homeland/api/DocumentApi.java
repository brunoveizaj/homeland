package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.CardDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PhotoDTO;
import com.homeland.exceptions.NoContentException;
import com.homeland.requests.api.DocumentRequest;
import com.homeland.requests.api.PhotoRequest;
import com.homeland.services.DocumentService;
import com.homeland.services.TokenService;

@RestController
@RequestMapping("/api/document")
public class DocumentApi {

	
	@Autowired
	DocumentService documentService;
	@Autowired 
	TokenService tokenService;
	
	@RequestMapping(value="/searchCards", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchCards(@RequestHeader(value="Authorization",required=false) String token, DocumentRequest request)
	{
		
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(request);
		
		List<CardDTO> list = documentService.searchCard(request);
		
		if(list == null || list.isEmpty())
		{
			throw new NoContentException("Nuk ka te dhena");
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/searchPassports", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchPassports(@RequestHeader(value="Authorization",required=false) String token, DocumentRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(request);
		
		List<PassportDTO> list = documentService.searchPassport(request);
		
		if(list == null || list.isEmpty())
		{
			throw new NoContentException("Nuk ka te dhena");
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getDocumentPhoto", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getDocumentPhoto(@RequestHeader(value="Authorization",required=false) String token, PhotoRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(request);
		
		PhotoDTO photo = documentService.getDocumentPhoto(request);
		
		if(photo == null)
		{
			throw new NoContentException("Nuk ka te dhena");
		}
				
		return new ResponseEntity<>(photo,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
}
