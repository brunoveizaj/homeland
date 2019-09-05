package com.homeland.services;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.AddressDTO;
import com.homeland.entities.Address;
import com.homeland.repositories.AddressRepository;
import com.homeland.requests.api.AddressRequest;
import com.homeland.requests.repository.AddressSQL;

@Service
public class AddressService {
	
	
	@Autowired AddressRepository addressDAO;
	
	
	public List<AddressDTO> getAddressByNid(String nid)
	{
		List<Address> list = addressDAO.getAddressByNid(nid);
		return new Assembler().addressListToDto(list);
	}
	
	
	public List<AddressDTO> getAddressByBuildingId(BigInteger bid)
	{
		List<Address> list = addressDAO.getAddressByBuildingId(bid);
		return new Assembler().addressListToDto(list);
	}
	
	
	public List<AddressDTO>searchAddress(AddressRequest req)
	{
		AddressSQL criterias = new RequestAssembler().apiToSql(req);
		List<Address> list = addressDAO.searchAddress(criterias);
		return new Assembler().addressListToDto(list);
	}
	
	
	@Async
	public CompletableFuture<List<AddressDTO>> getAsyncAddressByNid(String nid)
	{
		return CompletableFuture.completedFuture(getAddressByNid(nid));
	}
	
	
	
	

}
