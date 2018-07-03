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

import com.homeland.dto.ImportDTO;
import com.homeland.dto.LoginDTO;
import com.homeland.models.EntityCounter;
import com.homeland.services.StatisticService;

@RestController
@RequestMapping("/api/statistic")
public class StatisticApi {
	
	
	@Autowired
	StatisticService statService;
	
	@RequestMapping(value="/listImports/{limit}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getListImports(@PathVariable(name="limit") Integer limit)
	{
		List<ImportDTO> list = statService.getLastImports(limit);
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/logins/{limit}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getListLogins(@PathVariable(name="limit") Integer limit)
	{
		List<LoginDTO> list = statService.logins(limit);
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/entityStatistic}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> entityStatistic(@RequestHeader(value="Authorization") String token)
	{
		List<EntityCounter> list = statService.getEntityStatistics();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	

}
