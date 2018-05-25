package com.homeland.imports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.BorderDTO;
import com.homeland.dto.CardDTO;
import com.homeland.dto.ImportDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PhoneDTO;
import com.homeland.dto.PhotoDTO;
import com.homeland.dto.TicketDTO;
import com.homeland.dto.VehicleDTO;


@RestController
@RequestMapping("/import")
public class ImportApi {
	
	@Autowired
	ImportService service;
	
	@RequestMapping(value="/open", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> openImport(@RequestBody String type)
	{
		ImportDTO dto = service.openImport(type);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value="/close", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> closeImport(@RequestBody ImportDTO dto)
	{
		ImportDTO i = service.closeImport(dto);
		return new ResponseEntity<>(i,HttpStatus.OK);
	}
	
	@RequestMapping(value="/lastRid/{type}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getLastRid(@PathVariable(name="type") String type)
	{
		Long rid = service.getLastRid(type);
		
		if(rid == null) rid = 0L;
		
		return new ResponseEntity<>(rid,HttpStatus.OK);
	}
	
	@RequestMapping(value="/save/card", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> saveCard(@RequestBody CardDTO dto)
	{
		service.registerCard(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/save/passport", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> savePassport(@RequestBody PassportDTO dto)
	{
		service.registerPassport(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/save/photoCard", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> savePhotoCard(@RequestBody PhotoDTO dto)
	{
		service.registerPhotoCard(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/save/photoPassport", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> savePhotoPassport(@RequestBody PhotoDTO dto)
	{
		service.registerPhotoPassport(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/save/vehicle", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO dto)
	{
		service.registerVehicle(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/save/ticket", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> saveTicket(@RequestBody TicketDTO dto)
	{
		service.registerTicket(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/save/phone", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> saveVehicle(@RequestBody PhoneDTO dto)
	{
		service.registerPhone(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/save/border", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> saveVehicle(@RequestBody BorderDTO dto)
	{
		service.registerBorder(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
