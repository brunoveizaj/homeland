package com.homeland.requests.repository;

import com.homeland.utils.DateUtil;
import com.homeland.utils.StringUtil;

public class PersonSQL {

	
	String name;
	String surname;
	String fatherName;
	String motherName;
	String nid;
	String maidenName;
	String dob;
	String gender;
	String pob;
	String region;
	String municipality;
	String unit;
	String fromDob;
	String toDob;
	Long familyId;
	Integer firstResult;
	Integer maxResult;
	
	
	
	public PersonSQL() {
	}
	
	public PersonSQL(String nid) {
		super();
		setNid(nid);
		this.maxResult = 1;
	}
	
	public PersonSQL(Long familyId) {
		super();
		this.familyId = familyId;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = StringUtil.formatSQ(name);
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = StringUtil.formatSQ(surname);
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = StringUtil.formatSQ(fatherName);
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = StringUtil.formatSQ(motherName);
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = StringUtil.formatSQ(nid);
	}
	public String getMaidenName() {
		return maidenName;
	}
	public void setMaidenName(String maidenName) {
		this.maidenName = StringUtil.formatSQ(maidenName);
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = DateUtil.toReverseDate(dob);
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = StringUtil.formatSQ(gender);
	}
	public String getPob() {
		return pob;
	}
	public void setPob(String pob) {
		this.pob = StringUtil.formatSQ(pob);
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = StringUtil.formatSQ(region);
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = StringUtil.formatSQ(municipality);
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = StringUtil.formatSQ(unit);
	}
	public String getFromDob() {
		return fromDob;
	}
	public void setFromDob(String fromDob) {
		this.fromDob = fromDob;
	}
	public String getToDob() {
		return toDob;
	}
	public void setToDob(String toDob) {
		this.toDob = toDob;
	}
	public Long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public Integer getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	
	
	
	
	
}
