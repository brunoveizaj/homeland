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

import com.homeland.dto.TatimeDTO;
import com.homeland.models.MonthYear;
import com.homeland.requests.api.TatimeRequest;
import com.homeland.services.TatimeService;
import com.homeland.services.TokenService;

@RestController
@RequestMapping("/api/tatime")
public class TatimeApi {

	
	@Autowired
	TatimeService tatimeService;
	@Autowired 
	TokenService tokenService;
	
	@RequestMapping(value="/searchTatime", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchTatime(@RequestHeader(value="Authorization") String token,@RequestBody TatimeRequest req)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
				
		List<TatimeDTO> list = tatimeService.searchTatime(req,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/monthYears", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getMonthYears()
	{
				
		List<MonthYear> list = tatimeService.getTatimeMonthYears();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
}
