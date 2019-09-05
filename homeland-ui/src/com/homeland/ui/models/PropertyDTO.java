package com.homeland.ui.models;

import java.io.Serializable;

public class PropertyDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private String zk;
	private String volume;
	private String page;
	private String owner;
	private String propertyNo;
	private String mapIndex;
	private String propertyId;
	private String regDate;
	private String region;
	
	//address
	private String district;
	private String municipaliy;
	private String street;
	private String buildingNo;
	private String entryNo;
	private String appNo;
	private String floor;
	
	
	public String getZk() {
		return zk;
	}
	public void setZk(String zk) {
		this.zk = zk;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPropertyNo() {
		return propertyNo;
	}
	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}
	public String getMapIndex() {
		return mapIndex;
	}
	public void setMapIndex(String mapIndex) {
		this.mapIndex = mapIndex;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
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
	
	public String getAddress()
	{
		return district+", "+municipaliy+" Rr: "+street+", Pall: "+buildingNo+", H: "+entryNo+", Ap: "+appNo+", K: "+floor;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((propertyId == null) ? 0 : propertyId.hashCode());
		result = prime * result + ((propertyNo == null) ? 0 : propertyNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyDTO other = (PropertyDTO) obj;
		if (propertyId == null) {
			if (other.propertyId != null)
				return false;
		} else if (!propertyId.equals(other.propertyId))
			return false;
		if (propertyNo == null) {
			if (other.propertyNo != null)
				return false;
		} else if (!propertyNo.equals(other.propertyNo))
			return false;
		return true;
	}
	
	
	
	
	
	
}
