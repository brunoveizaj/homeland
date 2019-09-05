package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.PhoneRequest;
import com.homeland.ui.models.PhoneDTO;
import com.homeland.ui.services.PhoneService;
import com.homeland.ui.utils.Messages;




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
		try {
			this.phones = new PhoneService().searchPhone(request);
			if(phones == null || phones.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet asnje telefon", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.phones = null;
		}
	}

}
