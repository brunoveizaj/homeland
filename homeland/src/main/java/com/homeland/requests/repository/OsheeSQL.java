package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class OsheeSQL {

	String contractNo;
	Long familyId;
	String nid;
	Integer firstResult;
	Integer maxResult;
	
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		if(StringUtil.isValid(contractNo))
		this.contractNo = contractNo.replace(" ", "").toUpperCase();
	}
	public Long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		if(StringUtil.isValid(nid))
		this.nid = nid.replace(" ", "").toUpperCase();
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
