package com.homeland.ui.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	
	    private int id;
	    private String serialNo;
	    private Date ticketDate;
	    private String ticketPlace;
	    private String officer;
	    private double amount;
	    private String plate;
	    private String producer;
	    private String owner;
	    private String ownerAddress;
	    private String violator;
	    private String violatorNid;
	    private String status;
	    private Long rid;
	    
	    
	  
	    
	    
	    
	    
	    
	
}
