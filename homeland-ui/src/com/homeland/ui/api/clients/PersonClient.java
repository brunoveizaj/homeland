package com.homeland.ui.api.clients;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.homeland.ui.criterias.PersonRequest;
import com.homeland.ui.exceptions.ServerException;
import com.homeland.ui.models.PersonDTO;
import com.homeland.ui.models.PersonRaportDTO;
import com.homeland.ui.utils.StringUtil;

public class PersonClient {

	
	public List<PersonDTO> searchPerson(PersonRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/person/searchPerson";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		if(StringUtil.isValid(req.getDob()))
		{
			builder.queryParam("dob", req.getDob());
		}
		if(StringUtil.isValid(req.getFatherName()))
		{
			builder.queryParam("fatherName", req.getFatherName());
		}
		if(StringUtil.isValid(req.getGender()))
		{
			builder.queryParam("gender", req.getGender());
		}
		if(StringUtil.isValid(req.getMaidenName()))
		{
			builder.queryParam("maidenName", req.getMaidenName());
		}
		if(StringUtil.isValid(req.getMotherName()))
		{
			builder.queryParam("motherName", req.getMotherName());
		}
		if(StringUtil.isValid(req.getMunicipality()))
		{
			builder.queryParam("municipality", req.getMunicipality());
		}
		if(StringUtil.isValid(req.getName()))
		{
			builder.queryParam("name", req.getName());
		}
		if(StringUtil.isValid(req.getNid()))
		{
			builder.queryParam("nid", req.getNid());
		}
		if(StringUtil.isValid(req.getPob()))
		{
			builder.queryParam("pob", req.getPob());
		}
		if(StringUtil.isValid(req.getRegion()))
		{
			builder.queryParam("region", req.getRegion());
		}
		if(StringUtil.isValid(req.getSurname()))
		{
			builder.queryParam("surname", req.getSurname());
		}
		if(StringUtil.isValid(req.getUnit()))
		{
			builder.queryParam("unit", req.getUnit());
		}
		if(req.getFamilyId() != null)
		{
			builder.queryParam("familyId", req.getFamilyId());
		}
		if(req.getFirstResult() != null)
		{
			builder.queryParam("firstResult", req.getFirstResult());
		}
		if(req.getFromAge() != null)
		{
			builder.queryParam("fromAge", req.getFromAge());
		}
		if(req.getToAge() != null)
		{
			builder.queryParam("toAge", req.getToAge());
		}
		if(req.getMaxResult() != null)
		{
			builder.queryParam("maxResult", req.getMaxResult());
		}
		
		System.err.println("API REQ PERSON:searchPerson: "+builder.toUriString().toString());
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);// cfare formati i do te dhenat
		//headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE); eshte vetem kur dergon te dhena, tipi i te dhenave. tek get vetem merr
		headers.set("Authorization", "Bearer "+"ckemi");
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		
		ParameterizedTypeReference<List<PersonDTO>> typeRef = new ParameterizedTypeReference<List<PersonDTO>>() {};
		
		ResponseEntity<List<PersonDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		//ResponseEntity<PersonDTO[]> response = getForEntity(builder.toUriString(), PersonDTO[].class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
			//return Arrays.asList(response.getBody());
		}
		
		if(response.getStatusCodeValue() == HttpCode.SERVER_ERROR)
		{
			throw new ServerException("Server Error");
		}
		
		if(response.getStatusCodeValue() == HttpCode.NO_CONTENT)
		{
			System.err.println("API REQ PERSON:searchPerson NO CONTENT Body: "+response.getBody());
			return null;
		}
		
		
		
		return null;
	}
	
	
	public PersonRaportDTO personRaport(String nid)
	{
	    final String BASE_URL = IApiClient.SERVER+"/api/person/personRaport/{nid}";
	    
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("nid", nid);
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.build(nid);
		System.err.println("API REQ PERSON:personRaport: "+builder.toUriString());
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+"ckemi");
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<PersonRaportDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,PersonRaportDTO.class);
		
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
	
	
	public static void main(String[] args)
	{
		PersonClient client = new PersonClient();
		
		PersonRequest req = new PersonRequest();
		req.setName("Hasan");req.setSurname("Bylbyl");
		
	//	client.searchPerson(req);
		client.personRaport("AA4567BB");
		
	}
	
	
	
}
