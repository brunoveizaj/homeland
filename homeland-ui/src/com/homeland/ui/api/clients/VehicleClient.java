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
import com.homeland.ui.criterias.TicketRequest;
import com.homeland.ui.criterias.VehicleRequest;
import com.homeland.ui.models.TicketDTO;
import com.homeland.ui.models.VehicleDTO;
import com.homeland.ui.models.VehicleRaportDTO;
import com.homeland.ui.utils.Util;

public class VehicleClient {
	
	
	public VehicleRaportDTO vehicleRaport(String plate)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/vehicle/vehicleRaport/"+plate;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
	
		RestTemplate restTemplate = new RestTemplate();		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<VehicleRaportDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,VehicleRaportDTO.class);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
		
		
		return null;
	}
	
	public List<VehicleDTO> searchVehicle(VehicleRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/vehicle/searchVehicle";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<VehicleDTO>> typeRef = new ParameterizedTypeReference<List<VehicleDTO>>() {};
		
		ResponseEntity<List<VehicleDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}	
				
		return null;
		
	}
	
	public List<TicketDTO> searchTicket(TicketRequest req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/vehicle/searchTicket";		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(req,headers);
		
		ParameterizedTypeReference<List<TicketDTO>> typeRef = new ParameterizedTypeReference<List<TicketDTO>>() {};
		
		ResponseEntity<List<TicketDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCodeValue() == HttpCode.OK)
		{
			return response.getBody();
		}
				
		return null;
		
	}
	
	
	

}
