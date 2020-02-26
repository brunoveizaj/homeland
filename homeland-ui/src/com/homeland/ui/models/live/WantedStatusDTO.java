package com.homeland.ui.models.live;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WantedStatusDTO
{
	Date statusDate;
    String status;
    String cancelReason;
    String protocolNo;
}
