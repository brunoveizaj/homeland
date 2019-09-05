package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.AddressRequest;
import com.homeland.ui.models.AddressDTO;
import com.homeland.ui.services.AddressService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class AddressBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	AddressRequest request;
	List<AddressDTO> addresses;
	
	
	public AddressRequest getRequest() {
		return request;
	}
	public void setRequest(AddressRequest request) {
		this.request = request;
	}
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	
	
	
	@PostConstruct
	public void load()
	{
		init();
	}
	
	
	public void init()
	{
		this.request = new AddressRequest();
		request.setMaxResult(10000);
		this.addresses = null;
	}
	
	public void clear()
	{
		init();
	}
	
	public void search()
	{
		try {
			this.addresses = new AddressService().searchAddress(request);
			if(addresses == null || addresses.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet asnje adrese", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.addresses = null;
		}
	}

	
	
	
	

}
