package com.homeland.requests.repository;

import com.homeland.utils.StringUtil;

public class TatimeSQL {
	
	String nid;
	String nipt;
	String name;
	String surname;
	String subject;
	Integer year;
	Integer month;
	Integer firstResult;
	Integer maxResult;
	
	
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = StringUtil.formatSQ(nid);
	}
	public String getNipt() {
		return nipt;
	}
	public void setNipt(String nipt) {
		this.nipt = StringUtil.formatSQ(nipt);
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = StringUtil.formatSQ(subject);
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
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
