package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.CardDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PhotoDTO;
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
	
	@RequestMapping(value="/searchCards", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchCards(@RequestHeader(value="Authorization") String token,@RequestBody DocumentRequest request)
	{
		
		Integer userId = tokenService.getUserIdFromToken(token);		
		
		List<CardDTO> list = documentService.searchCard(request,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/searchPassports", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchPassports(@RequestHeader(value="Authorization") String token,@RequestBody DocumentRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
		
		List<PassportDTO> list = documentService.searchPassport(request,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getDocumentPhoto", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> getDocumentPhoto(@RequestHeader(value="Authorization") String token,@RequestBody PhotoRequest request)
	{
		Integer userId = tokenService.getUserIdFromToken(token);		
		
		PhotoDTO photo = documentService.getDocumentPhoto(request, userId);
		
		
		if(photo == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(photo,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
}
