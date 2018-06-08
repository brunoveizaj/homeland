package com.homeland.ui.criterias;

public class SubjectRequest {

	
	String nipt;
	String name;
	String managers;
	Integer firstResult;
	Integer maxResult = 1000;
	
    public SubjectRequest() {}
	
	public SubjectRequest(String nipt) {
		this.nipt = nipt;
		this.maxResult = 1;
	}
	
	public String getNipt() {
		return nipt;
	}
	public void setNipt(String nipt) {
		this.nipt = nipt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagers() {
		return managers;
	}
	public void setManagers(String managers) {
		this.managers = managers;
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
		return "SubjectRequest [nipt=" + nipt + ", name=" + name + ", managers=" + managers + ", firstResult="
				+ firstResult + ", maxResult=" + maxResult + "]";
	}
	
	
	
	
	
	
}
