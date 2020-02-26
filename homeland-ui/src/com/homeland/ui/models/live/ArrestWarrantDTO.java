package com.homeland.ui.models.live;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrestWarrantDTO {


	long id;
	String arrestWarrantNo;
	String court;
	String decisionCourtNo;
	String decisionCourtDate;
	String category;
	String requestStructure;
	String decisionType;
	String security;
	String protocolNo;
	String executiveStructure;
	//String status;
	//Date statusDate;
	String notes;
	String fullName;
	String dob;
	String nid;
	BigDecimal timsId;
	String codeOS;
	List<ArrestStatusDTO> arrestStatuses;
	
	
	
	public ArrestWarrantDTO()
	{
		this.arrestStatuses = new ArrayList<>();
	}
	
	
	
	
}

