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
import com.homeland.ui.criterias.SubjectRequest;
import com.homeland.ui.models.SubjectDTO;
import com.homeland.ui.utils.Util;

public class SubjectClient {

	
	public SubjectDTO getSubjectByNipt(String nipt)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/subject/"+nipt;		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<SubjectDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,SubjectDTO.class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
		
	}
	
	public List<SubjectDTO> searchSubject(SubjectRequest req)
	{
		
		
		final String BASE_URL = IApiClient.SERVER+"/api/subject/searchSubject";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<SubjectDTO>> typeRef = new ParameterizedTypeReference<List<SubjectDTO>>() {};
		
		ResponseEntity<List<SubjectDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		return null;
		
	}
	
	
	
	
	
	
}
