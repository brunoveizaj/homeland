package com.homeland.ui.models.live;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeland.ui.models.BorderDTO;
import com.homeland.ui.models.TicketDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveData {
	
	
	PersonDTO person;
	List<PersonDTO> family;
	List<AdamDTO> adams;
	List<ArrestWarrantDTO> arrestWarrants;
	List<BorderDTO> borders;
	List<CriminalCaseDTO> criminalCases;
	List<CrisActDTO> crisActs;
	List<DailyCommunicationDTO> dailyCommunications;
	List<TicketDTO> tickets;
	List<TimsActDTO> timsActs;
	List<WantedPersonDTO> wantedPersons;
	List<AkshiIsshContribution> contributions;
	List<AkshiPayroll> payrolls;
	List<AkshiSubject> subjects;
	List<AkshiVehicle> vehicles;
	List<AkshiZrpp> zrpps;
	
	
	
	public String toJson() throws JsonProcessingException
	{
		ObjectMapper obj = new ObjectMapper(); 
		   
        return obj.writeValueAsString(this); 
  
	}
	
	

}
