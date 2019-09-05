/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "address_id")
    private BigInteger addressId;
    @Column(name = "subject_type")
    private String subjectType;
    @Column(name = "nid")
    private String nid;
    @Column(name = "name")
    private String name;
    @Column(name = "street")
    private String street;
    @Size(max = 52)
    @Column(name = "building_entrance")
    private String buildingEntrance;
    @Column(name = "adm_unit")
    private String admUnit;
    @Column(name = "city")
    private String city;
    @Column(name = "entrance_id")
    private BigInteger entranceId;
    @Column(name = "entrance_no")
    private String entranceNo;
    @Column(name = "building_id")
    private BigInteger buildingId;
    @Column(name = "building_no")
    private BigInteger buildingNo;
    @Column(name = "building_code")
    private String buildingCode;
    @Column(name = "municipality")
    private String municipality;
    @Column(name = "unit_id")
    private BigInteger unitId;
    
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigInteger getAddressId() {
		return addressId;
	}
	public void setAddressId(BigInteger addressId) {
		this.addressId = addressId;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuildingEntrance() {
		return buildingEntrance;
	}
	public void setBuildingEntrance(String buildingEntrance) {
		this.buildingEntrance = buildingEntrance;
	}
	public String getAdmUnit() {
		return admUnit;
	}
	public void setAdmUnit(String admUnit) {
		this.admUnit = admUnit;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public BigInteger getEntranceId() {
		return entranceId;
	}
	public void setEntranceId(BigInteger entranceId) {
		this.entranceId = entranceId;
	}
	public String getEntranceNo() {
		return entranceNo;
	}
	public void setEntranceNo(String entranceNo) {
		this.entranceNo = entranceNo;
	}
	public BigInteger getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(BigInteger buildingId) {
		this.buildingId = buildingId;
	}
	public BigInteger getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(BigInteger buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getBuildingCode() {
		return buildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public BigInteger getUnitId() {
		return unitId;
	}
	public void setUnitId(BigInteger unitId) {
		this.unitId = unitId;
	}
    
    
    
    
    
}
