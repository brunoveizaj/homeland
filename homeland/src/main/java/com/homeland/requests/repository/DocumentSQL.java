package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class DocumentSQL {
	
	
	
	String idn;
	String name;
	String surname;
	String fatherName;
	String motherName;
	String nid;
	String dob;
	String gender;
	String fromDob;
	String toDob;
	Integer firstResult;
	Integer maxResult;
	String docType;
	
	public DocumentSQL() {}
	
	public DocumentSQL(String type)
	{
		this.docType = type;
	}

	public String getIdn() {
		return idn;
	}

	public void setIdn(String idn) {
		this.idn = idn;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = StringUtil.formatSQ(gender);
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

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	
	
	
	
	
	
	
	

}
