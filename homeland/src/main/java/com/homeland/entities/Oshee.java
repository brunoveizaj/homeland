package com.homeland.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oshee")
public class Oshee implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "contract_no")
    private String contractNo;
    @Column(name = "family_id")
    private long familyId;
    @Column(name = "family_relation")
    private String familyRelation;
    @Column(name = "nid")
    private String nid;
    @Column(name = "phone_one")
    private String phoneOne;
    @Column(name = "phone_two")
    private String phoneTwo;
    @Column(name = "phone_three")
    private String phoneThree;
    @Column(name = "municipality")
    private String municipality;
    @Column(name = "street")
    private String street;
    @Column(name = "adm_unit")
    private String admUnit;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "building_no")
    private String buildingNo;
    @Column(name = "entrance_no")
    private String entranceNo;
    @Column(name = "appartment_no")
    private String appNo;
    @Column(name = "geo_x")
    private String geoX;
    @Column(name = "geo_y")
    private String geoY;
    @Column(name = "geo_z")
    private String geoZ;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}
	public String getFamilyRelation() {
		return familyRelation;
	}
	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getPhoneOne() {
		return phoneOne;
	}
	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}
	public String getPhoneTwo() {
		return phoneTwo;
	}
	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}
	public String getPhoneThree() {
		return phoneThree;
	}
	public void setPhoneThree(String phoneThree) {
		this.phoneThree = phoneThree;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAdmUnit() {
		return admUnit;
	}
	public void setAdmUnit(String admUnit) {
		this.admUnit = admUnit;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getEntranceNo() {
		return entranceNo;
	}
	public void setEntranceNo(String entranceNo) {
		this.entranceNo = entranceNo;
	}
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public String getGeoX() {
		return geoX;
	}
	public void setGeoX(String geoX) {
		this.geoX = geoX;
	}
	public String getGeoY() {
		return geoY;
	}
	public void setGeoY(String geoY) {
		this.geoY = geoY;
	}
	public String getGeoZ() {
		return geoZ;
	}
	public void setGeoZ(String geoZ) {
		this.geoZ = geoZ;
	}
	
    
    
    
    
    
    
    
    
    
	
}
