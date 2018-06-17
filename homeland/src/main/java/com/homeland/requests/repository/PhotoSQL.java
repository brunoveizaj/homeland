package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class PhotoSQL {

	
	String nid;
	String idn;
	String docType;
	Integer firstResult;
	Integer maxResult;
	
	public PhotoSQL() {}
	
	public PhotoSQL(String nid) {
		this.nid = nid;
	}
	
	public PhotoSQL(String idn,String docType) {
		setIdn(idn);
		setDocType(docType);
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
		this.nid = StringUtil.formatSQ(nid);
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
		return "PhotoSQL [" + (nid != null ? "nid=" + nid + ", " : "") + (idn != null ? "idn=" + idn + ", " : "")
				+ (docType != null ? "docType=" + docType + ", " : "")
				+ (firstResult != null ? "firstResult=" + firstResult + ", " : "")
				+ (maxResult != null ? "maxResult=" + maxResult : "") + "]";
	}

	
	
}
