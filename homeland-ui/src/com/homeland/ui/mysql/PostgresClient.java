package com.homeland.ui.mysql;

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
import com.homeland.ui.models.PhotoDTO;

public class PostgresClient {

	
	public void sendPhotoCard(PhotoDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/import/save/photoCard";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<PhotoDTO>(dto,headers);
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Void.class);
		
				
		
	}
	
	public void sendPhotoPassport(PhotoDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/import/save/photoPassport";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<PhotoDTO>(dto,headers);
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Void.class);
		
				
		
	}
	
	
	public int getLastRid(String type)
	{
			final String BASE_URL = IApiClient.SERVER+"/import/lastRid/"+type;
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setErrorHandler(new ApiErrorHandler());
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<?> entity = new HttpEntity<>(headers);

			ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,Long.class);
			
			if(response.getStatusCodeValue() == HttpCode.OK)
			{
				return response.getBody().intValue();
			}

			return 0;		
		
	}
	
	
	
}
