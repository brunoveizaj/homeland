package com.homeland.requests.api;


public class PersonRequest {

	
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
	Integer fromAge;
	Integer toAge;
	Long familyId;
	Integer firstResult;
	Integer maxResult;
	
	
	public PersonRequest() {
	}
	
	public PersonRequest(String nid) {
		super();
		this.nid = nid;
		this.maxResult = 1;
	}
	
	public PersonRequest(Long familyId) {
		super();
		this.familyId = familyId;
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

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
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

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	@Override
	public String toString() {
		return "PersonRequest [name=" + name + ", surname=" + surname + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", nid=" + nid + ", maidenName=" + maidenName + ", dob=" + dob + ", gender=" + gender
				+ ", pob=" + pob + ", region=" + region + ", municipality=" + municipality + ", unit=" + unit
				+ ", fromAge=" + fromAge + ", toAge=" + toAge + ", familyId=" + familyId + ", firstResult="
				+ firstResult + ", maxResult=" + maxResult + "]";
	}



	


	
	
	
}
