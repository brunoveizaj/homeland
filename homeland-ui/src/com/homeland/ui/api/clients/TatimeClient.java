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

import com.homeland.ui.constants.HttpCode;
import com.homeland.ui.constants.IApiClient;
import com.homeland.ui.criterias.TatimeRequest;
import com.homeland.ui.models.MonthYear;
import com.homeland.ui.models.TatimeDTO;
import com.homeland.ui.utils.Util;

public class TatimeClient {

	
	public List<TatimeDTO> searchTatime(TatimeRequest req)
	{
				
		final String BASE_URL = IApiClient.SERVER+"/api/tatime/searchTatime";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<TatimeDTO>> typeRef = new ParameterizedTypeReference<List<TatimeDTO>>() {};
		
		ResponseEntity<List<TatimeDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
				
		return null;
	}
	
	public List<MonthYear> getTatimeMonthYears()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/tatime/monthYears";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<MonthYear>> typeRef = new ParameterizedTypeReference<List<MonthYear>>() {};
		
		ResponseEntity<List<MonthYear>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
				
		return null;
	}
	
	
	
	
}
