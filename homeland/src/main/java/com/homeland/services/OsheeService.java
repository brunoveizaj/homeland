package com.homeland.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.OsheeDTO;
import com.homeland.entities.Oshee;
import com.homeland.repositories.OsheeRepository;
import com.homeland.requests.api.OsheeRequest;
import com.homeland.requests.repository.OsheeSQL;

@Service
public class OsheeService {

	
	@Autowired
	OsheeRepository osheeDAO;
	
	public List<OsheeDTO> searchOshee(OsheeRequest req, Integer userId)
	{
		OsheeSQL criterias = new RequestAssembler().apiToSql(req);
		List<Oshee> oshees = osheeDAO.searchOshee(criterias);
		return new Assembler().osheeListToDto(oshees);		
	}
	
	
	@Async
	public CompletableFuture<List<OsheeDTO>> searchAsyncOshee(OsheeRequest req, Integer userId)
	{
		return CompletableFuture.completedFuture(searchOshee(req,userId));
	}
	
	
}
