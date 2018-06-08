package com.homeland.ui.criterias;

public class DocumentRequest {

	String idn;
	String name;
	String surname;
	String fatherName;
	String motherName;
	String nid;
	String dob;
	String gender;
	Integer fromAge;
	Integer toAge;
	Integer firstResult;
	Integer maxResult = 1000;
	String docType;
	
	public DocumentRequest() {}
	
	public DocumentRequest(String type)
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
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
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
		this.gender = gender;
	}
	public Integer getFromAge() {
		return fromAge;
	}
	public void setFromAge(Integer fromAge) {
		this.fromAge = fromAge;
	}
	public Integer getToAge() {
		return toAge;
	}
	public void setToAge(Integer toAge) {
		this.toAge = toAge;
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

	@Override
	public String toString() {
		return "DocumentRequest [idn=" + idn + ", name=" + name + ", surname=" + surname + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", nid=" + nid + ", dob=" + dob + ", gender=" + gender + ", fromAge="
				+ fromAge + ", toAge=" + toAge + ", firstResult=" + firstResult + ", maxResult=" + maxResult
				+ ", docType=" + docType + "]";
	}
	
	
	
}
