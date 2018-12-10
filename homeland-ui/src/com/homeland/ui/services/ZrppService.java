package com.homeland.ui.services;

import java.util.List;


import com.homeland.ui.api.clients.ZrppClient;
import com.homeland.ui.criterias.ZrppRequest;
import com.homeland.ui.models.PropertyCartelDTO;
import com.homeland.ui.models.PropertyDTO;
import com.homeland.ui.models.PropertyMapDTO;



public class ZrppService {
	
	
	public List<PropertyDTO> searchProperty(ZrppRequest req)
	{
		return new ZrppClient().searchProperty(req);
	}
	
	public List<PropertyDTO> searchPropertyByOwner(ZrppRequest req)
	{
		return new ZrppClient().searchPropertyByOwner(req);
	}
	
	public PropertyDTO getProperty(String zk, String vol, String page)
	{
		ZrppRequest req = new ZrppRequest(zk, vol, page);
		
		return new ZrppClient().getProperty(req);
	}
	
	public PropertyCartelDTO getPropertyCartel(String propertyId)
	{
		ZrppRequest req = new ZrppRequest(propertyId);
		
		return new ZrppClient().getPropertyCartel(req);
	}
	
	public PropertyMapDTO getPropertyMap(String propertyId)
	{
		ZrppRequest req = new ZrppRequest(propertyId);
		
		return new ZrppClient().getPropertyMap(req);
	}
	

}
