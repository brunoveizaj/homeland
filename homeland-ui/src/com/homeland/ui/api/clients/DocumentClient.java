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
import com.homeland.ui.criterias.DocumentRequest;
import com.homeland.ui.criterias.PhotoRequest;
import com.homeland.ui.models.CardDTO;
import com.homeland.ui.models.PassportDTO;
import com.homeland.ui.models.PhotoDTO;
import com.homeland.ui.utils.Util;

public class DocumentClient {

	
	
	public List<CardDTO> searchCards(DocumentRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/document/searchCards";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<CardDTO>> typeRef = new ParameterizedTypeReference<List<CardDTO>>() {};
		
		ResponseEntity<List<CardDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
				
		return null;
		
	}
	
	public List<PassportDTO> searchPassports(DocumentRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/document/searchPassports";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
				
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<PassportDTO>> typeRef = new ParameterizedTypeReference<List<PassportDTO>>() {};
		
		ResponseEntity<List<PassportDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
	
		return null;
		
	}
	
	public PhotoDTO getDocumentPhoto(PhotoRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/document/getDocumentPhoto";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);

		ResponseEntity<PhotoDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,PhotoDTO.class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}

		return null;
	}
	
	
	
	
	
}
