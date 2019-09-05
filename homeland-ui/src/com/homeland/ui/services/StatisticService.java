package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.StatisticClient;
import com.homeland.ui.models.ImportDTO;
import com.homeland.ui.models.LoginDTO;

public class StatisticService {

	public List<ImportDTO> listImports(Integer limit)
	{
		return new StatisticClient().listImports(limit);
	}
	
	
	public List<LoginDTO> logins(Integer limit)
	{
		return new StatisticClient().logins(limit);
	}
	
	
}
