package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.TatimeRequest;
import com.homeland.ui.models.TatimeDTO;
import com.homeland.ui.services.TatimeService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class TatimeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	TatimeRequest request;
	List<TatimeDTO> tatimes;
	
	
	
	public TatimeRequest getRequest() {
		return request;
	}

	public void setRequest(TatimeRequest request) {
		this.request = request;
	}

	public List<TatimeDTO> getTatimes() {
		return tatimes;
	}

	public void setTatimes(List<TatimeDTO> tatimes) {
		this.tatimes = tatimes;
	}

	
	
	
	

	@PostConstruct
	public void load()
	{
		init();
	}
	
	
	public void init()
	{
		this.request = new TatimeRequest();
		this.tatimes = null;
	}
	
	public void clear()
	{
		init();
	}
	
	public void search()
	{
		try {
			this.tatimes = new TatimeService().searchTatime(request);
			if(tatimes == null || tatimes.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet anje listepagese", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.tatimes = null;
		}
	}
	

}
