package com.homeland.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LivePersonRaportDTO {
	
	int lastRaportId;
	Date lastRequestDate;
	Date lastResponseDate;
	String lastRaportStatus;
	String displayMessage;
	boolean canAskRequest;
	boolean hasData;
	String dataJson;
	
}
