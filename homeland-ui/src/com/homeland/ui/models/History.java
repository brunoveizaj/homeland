package com.homeland.ui.models;

import java.io.Serializable;
import java.util.List;

public class History implements Serializable{


	private static final long serialVersionUID = 1L;

	String page;
	List<Param> params;
	
	
	public History() {}
	
	public History(String page, List<Param> params) {
		super();
		this.page = page;
		this.params = params;
	}
	
	
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<Param> getParams() {
		return params;
	}
	public void setParams(List<Param> params) {
		this.params = params;
	}
	
	
	
}
