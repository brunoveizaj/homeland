package com.homeland.ui.services;

import java.math.BigInteger;
import java.util.List;

import com.homeland.ui.api.clients.AddressClient;
import com.homeland.ui.criterias.AddressRequest;
import com.homeland.ui.models.AddressDTO;
import com.homeland.ui.models.BuildingMAP;

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
	
	public BuildingMAP getBuildingMapById(BigInteger bid) {
		return new AddressClient().getBuildingMapById(bid);
	}
	
	public List<BuildingMAP> getBuildingsMapByUnitId(Integer unitId) {
		return new AddressClient().getBuildingsMapByUnitId(unitId);
	}
	
	
	
	
	
}
