package com.homeland.ui.services;




import com.homeland.ui.api.clients.LiveRaportClient;
import com.homeland.ui.models.live.LivePersonRaportDTO;

public class LiveRaportService {
	
	
	
	
	public void addRequest(String type, String key)
	{
		
		new LiveRaportClient().addRequest(type, key);
	}
	
	public void cancelRequest(Integer id)
	{
		
		new LiveRaportClient().cancelRequest(id);
		
	}
	
	public LivePersonRaportDTO getLiveRaport(String type, String key)
	{
		
		return new LiveRaportClient().getLiveRaport(type, key);
		
	}
	
	
	
	

}
