package com.homeland.ui.models.live;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LivePersonRaportDTO {
	
	int lastRaportId;
	Date lastRequestDate;
	Date lastResponseDate;
	String lastRaportStatus;
	String displayMessage;
	boolean canAskRequest;
	boolean hasData;
	String dataJson;
	@Override
	public String toString() {
		return "LivePersonRaportDTO [lastRaportId=" + lastRaportId + ", lastRequestDate=" + lastRequestDate
				+ ", lastResponseDate=" + lastResponseDate + ", lastRaportStatus=" + lastRaportStatus
				+ ", displayMessage=" + displayMessage + ", canAskRequest=" + canAskRequest + ", hasData=" + hasData
				+ ", dataJson=xxxxx]";
	}
	
	
}
