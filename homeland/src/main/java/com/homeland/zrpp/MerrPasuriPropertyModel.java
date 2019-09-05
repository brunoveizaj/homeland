package com.homeland.zrpp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerrPasuriPropertyModel implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@JsonProperty("ZonaKadastrale")
	private String zk;
	@JsonProperty("Volumi")
	private String volume;
	@JsonProperty("Faqja")
	private String page;
	@JsonProperty("Pronaret")
	private String owner;
	@JsonProperty("NumerPasurie")
	private String propertyNo;
	@JsonProperty("IndeksHarte")
	private String mapIndex;
	@JsonProperty("IDPasuria")
	private String propertyId;
	@JsonProperty("Data_regjistrimit")
	private String regDate;
	@JsonProperty("rrethi")
	private String region;
	@JsonProperty("Adresa")
	private KerkoPasuriPropertyAddressModel address;
	
	
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
	public KerkoPasuriPropertyAddressModel getAddress() {
		return address;
	}
	public void setAddress(KerkoPasuriPropertyAddressModel address) {
		this.address = address;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "PropertyDTO [" + (zk != null ? "zk=" + zk + ", " : "")
				+ (volume != null ? "volume=" + volume + ", " : "") + (page != null ? "page=" + page + ", " : "")
				+ (owner != null ? "owner=" + owner + ", " : "")
				+ (propertyNo != null ? "propertyNo=" + propertyNo + ", " : "")
				+ (mapIndex != null ? "mapIndex=" + mapIndex + ", " : "")
				+ (propertyId != null ? "propertyId=" + propertyId + ", " : "")
				+ (regDate != null ? "regDate=" + regDate + ", " : "")
				+ (region != null ? "region=" + region + ", " : "") + (address != null ? "address=" + address : "")
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}
