/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.ui.models.live;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


/**
 *
 * @author Bruno
 */
@JsonRootName(value = "Adresa")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AkshiZrppAddress implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("DistrictName")
    String districtName;
    @JsonProperty("MunicipalityName")
    String municipalityName;
    @JsonProperty("StreetName")
    String streetName;
    @JsonProperty("BuildingNumber")
    String buildingNumber;
    @JsonProperty("EntryNumber")
    String entryNumber;
    @JsonProperty("ApartmentNumber")
    String apartmentNumber;
    @JsonProperty("Floor")
    String floor;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(String entryNumber) {
        this.entryNumber = entryNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    
    

    @Override
    public String toString() {
        return "ZrppAddress{" + "districtName=" + districtName + ", municipalityName=" + municipalityName + ", streetName=" + streetName + ", buildingNumber=" + buildingNumber + ", entryNumber=" + entryNumber + ", apartmentNumber=" + apartmentNumber + ", floor=" + floor + '}';
    }   
    
    
}
