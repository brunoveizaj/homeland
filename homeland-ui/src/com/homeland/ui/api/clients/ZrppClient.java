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
import com.homeland.ui.criterias.ZrppRequest;
import com.homeland.ui.models.PropertyCartelDTO;
import com.homeland.ui.models.PropertyDTO;
import com.homeland.ui.models.PropertyMapDTO;
import com.homeland.ui.utils.Util;

public class ZrppClient {
	
	
	public List<PropertyDTO> searchProperty(ZrppRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/zrpp/searchProperty";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<PropertyDTO>> typeRef = new ParameterizedTypeReference<List<PropertyDTO>>() {};
		
		ResponseEntity<List<PropertyDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
	}
	
	public List<PropertyDTO> searchPropertyByOwner(ZrppRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/zrpp/searchPropertyByOwner";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<PropertyDTO>> typeRef = new ParameterizedTypeReference<List<PropertyDTO>>() {};
		
		ResponseEntity<List<PropertyDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
	}
	
	
	public PropertyDTO getProperty(ZrppRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/zrpp/getProperty";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		
		ResponseEntity<PropertyDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, PropertyDTO.class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
	}
	
	public PropertyCartelDTO getPropertyCartel(ZrppRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/zrpp/getPropertyCartel";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		
		ResponseEntity<PropertyCartelDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, PropertyCartelDTO.class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
	}
	
	public PropertyMapDTO getPropertyMap(ZrppRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/zrpp/getPropertyMap";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		
		ResponseEntity<PropertyMapDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, PropertyMapDTO.class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
	}
	
	
	

}
