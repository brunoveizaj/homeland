package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.criterias.PhoneRequest;
import com.homeland.ui.models.PhoneDTO;
import com.homeland.ui.services.PhoneService;




@ManagedBean
@ViewScoped
public class PhoneBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	PhoneRequest request;
	List<PhoneDTO> phones;
	
	
	
	public PhoneRequest getRequest() {
		return request;
	}
	public void setRequest(PhoneRequest request) {
		this.request = request;
	}
	public List<PhoneDTO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

	
	

	@PostConstruct
	public void load()
	{
		init();
	}
	
	
	public void init()
	{
		this.request = new PhoneRequest();
		this.phones = null;
	}
	
	public void clear()
	{
		init();
	}
	
	public void search()
	{
		this.phones = new PhoneService().searchPhone(request);
	}

}
