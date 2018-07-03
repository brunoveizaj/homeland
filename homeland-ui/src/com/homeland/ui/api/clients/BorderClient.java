package com.homeland.ui.api.clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
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
import com.homeland.ui.criterias.BorderRequest;
import com.homeland.ui.exceptions.ServerException;
import com.homeland.ui.models.BorderDTO;
import com.homeland.ui.models.BorderGateDTO;
import com.homeland.ui.utils.Util;

public class BorderClient {
	
	public List<BorderDTO> searchEntryExits(BorderRequest req)
	{
		
		final String BASE_URL = IApiClient.SERVER+"/api/border/searchEntryExit";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
	
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<BorderDTO>> typeRef = new ParameterizedTypeReference<List<BorderDTO>>() {};
		
		ResponseEntity<List<BorderDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		if(response.getStatusCodeValue() == HttpCode.SERVER_ERROR)
		{
			throw new ServerException("Server Error");
		}		
				
		return null;
	}
	
	public List<BorderGateDTO> loadGates()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/border/listGates";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
	
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<BorderGateDTO>> typeRef = new ParameterizedTypeReference<List<BorderGateDTO>>() {};
		
		ResponseEntity<List<BorderGateDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		if(response.getStatusCodeValue() == HttpCode.SERVER_ERROR)
		{
			throw new ServerException("Server Error");
		}		
				
		return null;
	}
	
}
