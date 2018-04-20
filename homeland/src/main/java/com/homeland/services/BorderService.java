package com.homeland.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.BorderDTO;
import com.homeland.entities.Border;
import com.homeland.repositories.BorderRepository;
import com.homeland.requests.api.BorderRequest;
import com.homeland.requests.repository.BorderSQL;

@Service
public class BorderService {

	
	@Autowired
	BorderRepository borderDAO;
	
	public List<BorderDTO> searchEntryExit(BorderRequest req)
	{
		BorderSQL criterias = new RequestAssembler().apiToSql(req);
		List<Border> borders = borderDAO.searchEntryExit(criterias);
		return new Assembler().borderListToDto(borders);		
	}
	
	
	@Async
	public CompletableFuture<List<BorderDTO>> searchAsyncEntryExit(BorderRequest req)
	{
		return CompletableFuture.completedFuture(searchEntryExit(req));
	}
	
	
}
