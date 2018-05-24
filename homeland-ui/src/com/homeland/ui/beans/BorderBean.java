package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.BorderRequest;
import com.homeland.ui.models.BorderDTO;
import com.homeland.ui.services.BorderService;
import com.homeland.ui.utils.Messages;


@ManagedBean
@ViewScoped
public class BorderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	BorderRequest request;
	List<BorderDTO> borders;
	

	public BorderRequest getRequest() {
		return request;
	}
	public void setRequest(BorderRequest request) {
		this.request = request;
	}
	public List<BorderDTO> getBorders() {
		return borders;
	}
	public void setBorders(List<BorderDTO> borders) {
		this.borders = borders;
	}


	
	@PostConstruct
	public void load()
	{
		init();
	}
	
	
	public void init()
	{
		this.request = new BorderRequest();
		this.borders = null;
	}
	
	public void clear()
	{
		init();
	}
	
	public void search()
	{
		try {
			this.borders = new BorderService().searchEntryExits(request);
			if(borders == null || borders.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka HYRJE-DALJE", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.borders = null;
		}
	}
	

}
