package com.homeland.ui.models.live;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrisActDTO {
	
	
	String unId;
	String actType;
	Date actDate;
	String officer;
	String organization;
	String notes;
	String uniqueNo;
	String address;
	String dob;
	String fatherName;
	String name;
	String surname;
	String nid;
	BigDecimal timsId;
	String codeOS;

}
