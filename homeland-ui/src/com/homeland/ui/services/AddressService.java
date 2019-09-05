package com.homeland.ui.services;

import java.math.BigInteger;
import java.util.List;

import com.homeland.ui.api.clients.AddressClient;
import com.homeland.ui.criterias.AddressRequest;
import com.homeland.ui.models.AddressDTO;

public class AddressService {

	public List<AddressDTO> searchAddress(AddressRequest request) {
		return new AddressClient().searchAddress(request);
	}
	
	public List<AddressDTO> getAddressByNid(String nid) {
		return new AddressClient().getAddressByNid(nid);
	}
	
	public List<AddressDTO> getAddressByBuildingId(BigInteger bid) {
		return new AddressClient().getAddressByBuildingId(bid);
	}
	
	
}
