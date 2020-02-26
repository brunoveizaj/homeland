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

import com.homeland.assemblers.Assembler;
import com.homeland.constants.ILiveRaport;
import com.homeland.dto.LiveRaportDTO;
import com.homeland.models.LiveDataForm;
import com.homeland.models.LivePersonRaportDTO;
import com.homeland.services.LiveRaportService;
import com.homeland.services.TokenService;

@RestController
@RequestMapping("/live")
public class LiveRaportApi {

	
	@Autowired 
	TokenService tokenService;
	@Autowired
	LiveRaportService service;
	
	@RequestMapping(value="/requestRaport/{type}/{key}", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> createLiveRaport(@RequestHeader(value="Authorization") String token, @PathVariable String type, @PathVariable String key)
	{
		
		String user = tokenService.getUsernameFromToken(token);
		
		service.createLiveRaport(type, key, user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/registerJsonData", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerJsonData(@RequestBody LiveDataForm form)
	{
		
		service.registerJsonData(form.getId(), form.getJson());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/pendingRequests", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> pendingRequests()
	{
		
		List<LiveRaportDTO> list = new Assembler().liveRaportToDto(service.getLiveRaportRequests());
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/cancelRequest/{id}", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> cancelRequest(@RequestHeader(value="Authorization") String token, @PathVariable Integer id)
	{
		tokenService.getUsernameFromToken(token);
		
		service.cancelRequest(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/raport/{type}/{key}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getPersonLiveRaport(@RequestHeader(value="Authorization") String token, @PathVariable String type, @PathVariable String key)
	{
		tokenService.getUsernameFromToken(token);
		
		if(type.equals(ILiveRaport.TYPE_PERSON)) 
		{
			LivePersonRaportDTO dto = service.getPersonLiveRaport(key);
			
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
