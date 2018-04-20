package com.homeland.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.TatimeDTO;
import com.homeland.entities.Tatime;
import com.homeland.repositories.TatimeRepository;
import com.homeland.requests.api.TatimeRequest;
import com.homeland.requests.repository.TatimeSQL;

@Service
public class TatimeService {

	@Autowired
	TatimeRepository tatimeDAO;
	
	
	public List<TatimeDTO> searchTatime(TatimeRequest req)
	{
		TatimeSQL criterias = new RequestAssembler().apiToSql(req);
		List<Tatime> tatime = tatimeDAO.searchTatime(criterias);
		return new Assembler().tatimeListToDto(tatime);
	}
	
	@Async
	public CompletableFuture<List<TatimeDTO>> searchAsyncTatime(TatimeRequest req)
	{
		return CompletableFuture.completedFuture(searchTatime(req));
	}
	
}
