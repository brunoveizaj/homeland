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
import com.homeland.ui.models.TatimeDTO;
import com.homeland.ui.utils.StringUtil;
import com.homeland.ui.utils.Util;

public class TatimeClient {

	
	public List<TatimeDTO> searchTatime(TatimeRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/tatime/searchTatime";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		if(StringUtil.isValid(req.getName()))
		{
			builder.queryParam("name", req.getName());
		}
		if(StringUtil.isValid(req.getNipt()))
		{
			builder.queryParam("nipt", req.getNipt());
		}
		if(StringUtil.isValid(req.getNid()))
		{
			builder.queryParam("nid", req.getNid());
		}
		if(StringUtil.isValid(req.getSubject()))
		{
			builder.queryParam("subject", req.getSubject());
		}
		if(StringUtil.isValid(req.getSurname()))
		{
			builder.queryParam("surname", req.getSurname());
		}
		if(req.getMonth() != null)
		{
			builder.queryParam("month", req.getMonth());
		}
		if(req.getYear() != null)
		{
			builder.queryParam("year", req.getYear());
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
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<TatimeDTO>> typeRef = new ParameterizedTypeReference<List<TatimeDTO>>() {};
		
		ResponseEntity<List<TatimeDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
				
		return null;
	}
	
	
	
	
	
}
