package com.homeland.ui.models.live;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdamDTO {
	
	long id;
	String name;
	String surname;
	String fatherName;
	String dob;
	String nid;
	BigDecimal timsId;
	String codeOS;
	String comment;
	String adamDate;
	String adamPlace;
	String officer;

}
