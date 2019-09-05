package com.homeland.ui.api.clients;

import java.math.BigInteger;
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
import com.homeland.ui.criterias.AddressRequest;
import com.homeland.ui.models.AddressDTO;
import com.homeland.ui.utils.Util;

public class AddressClient {

	public List<AddressDTO> searchAddress(AddressRequest req) {


		final String BASE_URL = IApiClient.SERVER+"/api/address/searchAddress";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<AddressDTO>> typeRef = new ParameterizedTypeReference<List<AddressDTO>>() {};
		
		ResponseEntity<List<AddressDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
				
				
		return null;
		
		
		
	}
	
	public List<AddressDTO> getAddressByNid(String nid) {


		final String BASE_URL = IApiClient.SERVER+"/api/address/getByNid/"+nid.trim();		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AddressDTO>> typeRef = new ParameterizedTypeReference<List<AddressDTO>>() {};
		
		ResponseEntity<List<AddressDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
				
				
		return null;
		
		
		
	}
	
	public List<AddressDTO> getAddressByBuildingId(BigInteger bid) {


		final String BASE_URL = IApiClient.SERVER+"/api/address/getByBuildingId/"+bid;		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AddressDTO>> typeRef = new ParameterizedTypeReference<List<AddressDTO>>() {};
		
		ResponseEntity<List<AddressDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
				
				
		return null;
		
		
		
	}
	
	
	

}
