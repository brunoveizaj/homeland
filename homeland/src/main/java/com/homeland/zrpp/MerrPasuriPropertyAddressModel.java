package com.homeland.zrpp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerrPasuriPropertyAddressModel implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	@JsonProperty("DistrictName")
	private String district;
	@JsonProperty("MunicipalityName")
	private String municipaliy;
	@JsonProperty("StreetName")
	private String street;
	@JsonProperty("BuildingNumber")
	private String buildingNo;
	@JsonProperty("EntryNumber")
	private String entryNo;
	@JsonProperty("ApartmentNumber")
	private String appNo;
	@JsonProperty("Floor")
	private String floor;
	
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getMunicipaliy() {
		return municipaliy;
	}
	public void setMunicipaliy(String municipaliy) {
		this.municipaliy = municipaliy;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getEntryNo() {
		return entryNo;
	}
	public void setEntryNo(String entryNo) {
		this.entryNo = entryNo;
	}
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	@Override
	public String toString() {
		return "PropertyAddressDTO [" + (district != null ? "district=" + district + ", " : "")
				+ (municipaliy != null ? "municipaliy=" + municipaliy + ", " : "")
				+ (street != null ? "street=" + street + ", " : "")
				+ (buildingNo != null ? "buildingNo=" + buildingNo + ", " : "")
				+ (entryNo != null ? "entryNo=" + entryNo + ", " : "") + (appNo != null ? "appNo=" + appNo + ", " : "")
				+ (floor != null ? "floor=" + floor : "") + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
