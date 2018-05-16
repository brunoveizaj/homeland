package com.homeland.ui.criterias;

public class PhotoRequest {

	String nid;
	String idn;
	String docType;
	Integer firstResult;
	Integer maxResult;
	
    public PhotoRequest() {}
	
	public PhotoRequest(String nid) {
		this.nid = nid;
	}
	
	public PhotoRequest(String idn,String docType) {
		this.idn = idn;
		this.docType = docType;
		this.maxResult = 1;
	}
	
	
	public String getIdn() {
		return idn;
	}
	public void setIdn(String idn) {
		this.idn = idn;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
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
	
	
}
