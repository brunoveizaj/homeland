package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class SubjectSQL {
	
	
	String nipt;
	String name;
	String managers;
	Integer firstResult;
	Integer maxResult;
	
	public SubjectSQL() {}
	
	public SubjectSQL(String nipt) {
		setNipt(nipt);
		this.maxResult = 1;
	}
	
	public String getNipt() {
		return nipt;
	}
	public void setNipt(String nipt) {
		if(StringUtil.isValid(nipt))
		this.nipt = nipt.replace(" ", "").toUpperCase();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(StringUtil.isValid(name))
		this.name = name.replace(" ", "").toUpperCase();;
	}
	public String getManagers() {
		return managers;
	}
	public void setManagers(String managers) {
		this.managers = StringUtil.formatSQ(managers);
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
