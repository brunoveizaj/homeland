package com.homeland.ui.models.live;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {
	
	String nid;
	String name;
	String surname;
	String fatherName;
	String motherName;
	String maidenName;
	String gender;
	String civilStatus;
    String dob;
    String pob;
    String street;
    String familyRelation;
    String region;
    String municipality;
    String unit;
    List<String> addresses;
    List<String> otherNames;
	@Override
	public String toString() {
		return "PersonDTO [nid=" + nid + ", name=" + name + ", surname=" + surname + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", maidenName=" + maidenName + ", gender=" + gender + ", civilStatus="
				+ civilStatus + ", dob=" + dob + ", pob=" + pob + ", region=" + region + ", municipality="
				+ municipality + ", unit=" + unit + ", addresses=" + addresses + ", otherNames=" + otherNames + "]";
	};
	

    
    
}
