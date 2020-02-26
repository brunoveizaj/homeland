package com.homeland.ui.models.live;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WantedPersonDTO {
	
	
	String unId;
	String wpNo;
	String structure;
	String refNo;
	Date refDate;
	String category;
	Date sentenceDate;
	List<WantedStatusDTO> wantedStatuses;
	String notes;
	String fullName;
	String dob;
	String nid;
	BigDecimal timsId;
	String codeOS;
	
	
	

}
