package com.homeland.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.PhoneDTO;
import com.homeland.entities.Phone;
import com.homeland.repositories.PhoneRepository;
import com.homeland.requests.api.PhoneRequest;
import com.homeland.requests.repository.PhoneSQL;

@Service
public class PhoneService {

	
	@Autowired
	PhoneRepository phoneDAO;
	
	public List<PhoneDTO> searchPhone(PhoneRequest req)
	{
		PhoneSQL criterias = new RequestAssembler().apiToSql(req);
		List<Phone> phones = phoneDAO.searchPhone(criterias);
		return new Assembler().phoneListToDto(phones);
	}
	
	
	@Async
	public CompletableFuture<List<PhoneDTO>> searchAsyncPhone(PhoneRequest req)
	{
		return CompletableFuture.completedFuture(searchPhone(req));
	}
	
}
