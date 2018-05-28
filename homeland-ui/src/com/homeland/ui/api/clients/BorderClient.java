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
import com.homeland.ui.utils.StringUtil;
import com.homeland.ui.utils.Util;

public class BorderClient {
//
	
	public List<BorderDTO> searchEntryExits(BorderRequest req)
	{
		
		final String BASE_URL = IApiClient.SERVER+"/api/border/searchEntryExit";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		if(StringUtil.isValid(req.getDocNo()))
		{
			builder.queryParam("docNo", req.getDocNo());
		}
		
		if(StringUtil.isValid(req.getEvent()))
		{
			builder.queryParam("event", req.getEvent());
		}
		
		if(req.getForeign() != null)
		{
			builder.queryParam("foreign", req.getForeign());
		}
		
		if(StringUtil.isValid(req.getBcgId()))
		{
			builder.queryParam("bcgId", req.getBcgId());
		}
		if(StringUtil.isValid(req.getFrom()))
		{
			builder.queryParam("from", req.getFrom());
		}
		if(StringUtil.isValid(req.getTo()))
		{
			builder.queryParam("to", req.getTo());
		}
		if(StringUtil.isValid(req.getPlate()))
		{
			builder.queryParam("plate", req.getPlate());
		}
		if(StringUtil.isValid(req.getVin()))
		{
			builder.queryParam("vin", req.getVin());
		}
		if(StringUtil.isValid(req.getFatherName()))
		{
			builder.queryParam("fatherName", req.getFatherName());
		}
		if(StringUtil.isValid(req.getName()))
		{
			builder.queryParam("name", req.getName());
		}
		if(StringUtil.isValid(req.getNid()))
		{
			builder.queryParam("nid", req.getNid());
		}
		if(StringUtil.isValid(req.getSurname()))
		{
			builder.queryParam("surname", req.getSurname());
		}		
		
		if(req.getFirstResult() != null)
		{
			builder.queryParam("firstResult", req.getFirstResult());
		}
		if(req.getMaxResult() != null)
		{
			builder.queryParam("maxResult", req.getMaxResult());
		}
		
		System.out.println(builder.toUriString());
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<BorderDTO>> typeRef = new ParameterizedTypeReference<List<BorderDTO>>() {};
		
		ResponseEntity<List<BorderDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
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
