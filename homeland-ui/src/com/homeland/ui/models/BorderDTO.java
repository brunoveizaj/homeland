package com.homeland.ui.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorderDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	    private int id;
	    private String docState;
	    private String docNo;
	    private Date crossingDate;
	    private String citizenType;
	    private String travel;
	    private String crossingGate;
	    private String bcgId; 
	    private boolean driver;
	    private String plate;
	    private String nid;
	    private String nationality;
	    private String name;
	    private String surname;
	    private String fatherName;
	    private String dob;
	    private String gender;
	    private String pupose;
	    private String event;
	    private boolean foreign;
	    
	    
	    
	  
	
	
}
