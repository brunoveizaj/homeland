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
import com.homeland.ui.criterias.PersonRequest;
import com.homeland.ui.models.PersonDTO;
import com.homeland.ui.models.PersonRaportDTO;
import com.homeland.ui.utils.Util;

public class PersonClient {

	
	public List<PersonDTO> searchPerson(PersonRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/person/searchPerson";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);// cfare formati i do te dhenat
		//headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE); eshte vetem kur dergon te dhena, tipi i te dhenave. tek get vetem merr
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<PersonDTO>> typeRef = new ParameterizedTypeReference<List<PersonDTO>>() {};
		
		ResponseEntity<List<PersonDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
	}
	
	
	public PersonRaportDTO personRaport(String nid)
	{
	    final String BASE_URL = IApiClient.SERVER+"/api/person/personRaport/"+nid;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		/*
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> suppMedias = new ArrayList<>();
		suppMedias.add(MediaType.ALL);
		converter.setSupportedMediaTypes(suppMedias);         
		messageConverters.add(converter);  
			*/	
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		//restTemplate.setMessageConverters(messageConverters);  
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<PersonRaportDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,PersonRaportDTO.class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}		
		
		return null;
		
	}
	
	
	
}
