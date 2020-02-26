package com.homeland.ui.api.clients;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.homeland.ui.api.security.ApiErrorHandler;
import com.homeland.ui.constants.HttpCode;
import com.homeland.ui.constants.IApiClient;
import com.homeland.ui.models.live.LivePersonRaportDTO;
import com.homeland.ui.utils.Util;

public class LiveRaportClient {

	
	
	
	public void addRequest(String type, String key)
	{
		final String BASE_URL = IApiClient.SERVER+"/live/requestRaport/"+type+"/"+key;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
	/*	
		Map<String,String> map = new HashMap<>();
		map.put("type", type);
		map.put("key", key);
		*/
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,Void.class);
		
	}
	
	public void cancelRequest(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/live/cancelRequest/"+id;		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,Void.class);
		
		
	}
	
	public LivePersonRaportDTO getLiveRaport(String type, String key)
	{
		final String BASE_URL = IApiClient.SERVER+"/live/raport/"+type+"/"+key;		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		/*
		Map<String,String> map = new HashMap<>();
		map.put("type", type);
		map.put("key", key);
		*/
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
				
        ResponseEntity<LivePersonRaportDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, LivePersonRaportDTO.class);//,map
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		
		return null;
		
		
	}
	
	
	
	
	
}
