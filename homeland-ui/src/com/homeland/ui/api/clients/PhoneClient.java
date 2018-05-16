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
import com.homeland.ui.criterias.PhoneRequest;
import com.homeland.ui.exceptions.ServerException;
import com.homeland.ui.models.PhoneDTO;
import com.homeland.ui.utils.StringUtil;

public class PhoneClient {
	
	
	public List<PhoneDTO> searchPhone(PhoneRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/phone/searchPhone";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		
		if(StringUtil.isValid(req.getPhoneNo()))
		{
			builder.queryParam("phoneNo", req.getPhoneNo());
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
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+"ckemi");
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		
		ParameterizedTypeReference<List<PhoneDTO>> typeRef = new ParameterizedTypeReference<List<PhoneDTO>>() {};
		
		ResponseEntity<List<PhoneDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
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
