package com.homeland.ui.models.live;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;




@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyCommunicationDTO {
	
		
	String unId;
	BigDecimal personId;
	String name;
	String surname;
	String fatherName;
	String uniqueNo;
	BigDecimal dossierNo;
	String communicationNo;
	String relationType;
	String notes;
	String region;
	Date reportDate;
	
	

}
