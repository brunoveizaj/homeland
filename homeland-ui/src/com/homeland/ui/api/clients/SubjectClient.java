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
import com.homeland.ui.exceptions.ServerException;
import com.homeland.ui.models.SubjectDTO;
import com.homeland.ui.utils.StringUtil;

public class SubjectClient {

	
	public SubjectDTO getSubjectByNipt(String nipt)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/subject/"+nipt;		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+"ckemi");
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<SubjectDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,SubjectDTO.class);
		
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
	
	public List<SubjectDTO> searchSubject(SubjectRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/subject/searchSubject";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		if(StringUtil.isValid(req.getName()))
		{
			builder.queryParam("name", req.getName());
		}
		if(StringUtil.isValid(req.getNipt()))
		{
			builder.queryParam("nipt", req.getNipt());
		}
		if(StringUtil.isValid(req.getManagers()))
		{
			builder.queryParam("managers", req.getManagers());
		}
		if(req.getFirstResult() != null)
		{
			builder.queryParam("firstResult", req.getFirstResult());
		}
		if(req.getMaxResult() != null)
		{
			builder.queryParam("maxResult", req.getMaxResult());
		}
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+"ckemi");
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		
		ParameterizedTypeReference<List<SubjectDTO>> typeRef = new ParameterizedTypeReference<List<SubjectDTO>>() {};
		
		ResponseEntity<List<SubjectDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		if(response.getStatusCodeValue() == HttpCode.SERVER_ERROR)
		{
			throw new ServerException("Server Error");
		}
		
		if(response.getStatusCodeValue() == HttpCode.NO_CONTENT)
		{
			System.err.println("API REQ SUBJECT:searchSubject NO CONTENT Body: "+response.getBody());
			return null;
		}
				
		return null;
		
	}
	
	
	
	
	
	
}