package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.BorderClient;
import com.homeland.ui.criterias.BorderRequest;
import com.homeland.ui.models.BorderDTO;

public class BorderService {

	
	public List<BorderDTO> searchEntryExits(BorderRequest req)
	{
		return new BorderClient().searchEntryExits(req);
	}
	
	
	
	
}
