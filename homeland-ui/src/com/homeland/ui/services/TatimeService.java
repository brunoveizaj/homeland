package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.TatimeClient;
import com.homeland.ui.criterias.TatimeRequest;
import com.homeland.ui.models.MonthYear;
import com.homeland.ui.models.TatimeDTO;

public class TatimeService {

	
	public List<TatimeDTO> searchTatime(TatimeRequest req)
	{
		return new TatimeClient().searchTatime(req);
	}
	
	public List<MonthYear> getTatimeMonthYears()
	{
		return new TatimeClient().getTatimeMonthYears();
	}
	
}
