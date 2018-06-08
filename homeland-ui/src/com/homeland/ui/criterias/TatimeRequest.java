package com.homeland.ui.criterias;


public class TatimeRequest {
	
	
	String nid;
	String nipt;
	String name;
	String surname;
	String subject;
	Integer year;
	Integer month;
	Integer firstResult;
	Integer maxResult = 5000;
	
	
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	
	
	@Override
	public String toString() {
		return "TatimeRequest [nid=" + nid + ", nipt=" + nipt + ", name=" + name + ", surname=" + surname + ", subject="
				+ subject + ", year=" + year + ", month=" + month + ", firstResult=" + firstResult + ", maxResult="
				+ maxResult + "]";
	}
	
	
	
	

}
