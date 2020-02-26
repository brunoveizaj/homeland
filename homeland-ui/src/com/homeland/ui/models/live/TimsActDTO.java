package com.homeland.ui.models.live;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimsActDTO {
	
		
	BigDecimal id;
	String reportType;
	Date reportDate;
	String narration;
	String notes;
	String officer;
	String address;
	String uniqueNo;
	String victimFullName;
	String victimNid;
	BigDecimal victimTimsId;
	String victimCodeOS;
	String suspectFullName;
	String suspectNid;
	BigDecimal suspectTimsId;
	String suspectCodeOS;
	
	
	

}
