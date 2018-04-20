package com.homeland.requests.api;

public class OsheeRequest {

	String contractNo;
	Long familyId;
	String nid;
	Integer firstResult;
	Integer maxResult;
	
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
		this.nid = nid;
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
		return "OsheeRequest [contractNo=" + contractNo + ", familyId=" + familyId + ", nid=" + nid + ", firstResult="
				+ firstResult + ", maxResult=" + maxResult + "]";
	}
	
	
	
	
}
