package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.constants.IDocument;
import com.homeland.ui.criterias.DocumentRequest;
import com.homeland.ui.models.PassportDTO;
import com.homeland.ui.services.DocumentService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class PassportBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	DocumentRequest request;
	List<PassportDTO> passports;
	PassportDTO selectedPassport;
	
	
	public DocumentRequest getRequest() {
		return request;
	}

	public void setRequest(DocumentRequest request) {
		this.request = request;
	}

	public List<PassportDTO> getPassports() {
		return passports;
	}

	public void setPassports(List<PassportDTO> passports) {
		this.passports = passports;
	}

	public PassportDTO getSelectedPassport() {
		return selectedPassport;
	}

	public void setSelectedPassport(PassportDTO selectedPassport) {
		this.selectedPassport = selectedPassport;
	}

	
	
	
	@PostConstruct
	public void load()
	{
		init();
	}
	
	public void init()
	{
		this.request = new DocumentRequest(IDocument.PASSPORT);
		this.passports = null;
		this.selectedPassport = null;
	}
	
	
	public void search()
	{
		try {
			this.selectedPassport = null;
			this.passports = new DocumentService().searchPassports(request);
			if(passports == null || passports.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet asnje karte", 2);
			}
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.passports = null;			
		}
	}
	
	public void clear()
	{
		init();
	}
	
	
	
	
	


}
