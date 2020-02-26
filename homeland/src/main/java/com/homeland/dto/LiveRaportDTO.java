package com.homeland.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class LiveRaportDTO {
	
	private int id;

    private Date requestTime;

    private Date responseTime;
    private String requestUser;
    private String type;
    private String key;
    private String dataJson;
    private String status;

}
