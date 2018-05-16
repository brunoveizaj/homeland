package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.PhoneClient;
import com.homeland.ui.criterias.PhoneRequest;
import com.homeland.ui.models.PhoneDTO;

public class PhoneService {

	
	public List<PhoneDTO> searchPhone(PhoneRequest req)
	{
		return new PhoneClient().searchPhone(req);
	}
	
	
}
